package com.android.anmol.feeds_mvp.source;

import android.support.annotation.NonNull;

import com.android.anmol.feeds_mvp.feeds.FeedStatusType;
import com.android.anmol.feeds_mvp.utility.Utils;

/**
 * Created by anmolsehgal on 27-03-2018.
 * <p>
 * Implementation to load Feeds from Data source.
 */
public class FeedsRepository implements FeedsDataSource {

    private static FeedsRepository INSTANCE = null;

    private final FeedsDataSource mFeedsRemoteDataSource;

    private ResFeed[] mCachedFeeds;

    // Prevent direct instantiation.
    private FeedsRepository(@NonNull FeedsDataSource feedsRemoteDataSource) {
        mFeedsRemoteDataSource = Utils.checkNotNull(feedsRemoteDataSource);
    }

    /**
     * Returns the single instance of this class, creating it if necessary.
     *
     * @param feedsRemoteDataSource the backend data source
     * @return the {@link FeedsRepository} instance
     */
    public static FeedsRepository getInstance(FeedsDataSource feedsRemoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new FeedsRepository(feedsRemoteDataSource);
        }
        return INSTANCE;
    }

    /**
     * Gets Feeds from cache, local data source or remote data source, whichever is
     * available first.
     * <p>
     * Note: {@link FetchFeedsCallback#onDataNotAvailable()} is fired if all data sources fail to
     * get the data.
     */
    @Override
    public void getFeeds(@NonNull FetchFeedsCallback callback, boolean forceUpdate) {
        Utils.checkNotNull(callback);

        if (mCachedFeeds != null && !forceUpdate) {
            callback.onFeedsFetched(mCachedFeeds);
        } else {
            getFeedsFromRemoteDataSource(callback);
        }
    }

    @Override
    public void configureLikeStatus(final int feedId, @FeedStatusType int oldLikeStatus, @NonNull final FeedLikeStatus callback) {

        mFeedsRemoteDataSource.configureLikeStatus(feedId, oldLikeStatus, new FeedLikeStatus() {

            @Override
            public void configureLikeStatus(@FeedStatusType final int newLikeStatus) {
                callback.configureLikeStatus(newLikeStatus);

                mCachedFeeds[feedId].setFeedStatus(newLikeStatus);
            }
        });
    }

    private void getFeedsFromRemoteDataSource(@NonNull final FetchFeedsCallback callback) {
        mFeedsRemoteDataSource.getFeeds(new FetchFeedsCallback() {

            @Override
            public void onFeedsFetched(ResFeed[] feeds) {
                for (int x = 0; x < feeds.length; x++) {
                    feeds[x].setId(x);
                }
                refreshFeeds(feeds);
                callback.onFeedsFetched(feeds);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        }, true);
    }

    private void refreshFeeds(ResFeed[] feeds) {
        mCachedFeeds = feeds;
    }
}
