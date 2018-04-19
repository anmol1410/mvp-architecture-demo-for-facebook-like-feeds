package com.android.anmol.feeds_mvp.feed_details;

import android.support.annotation.NonNull;

import com.android.anmol.feeds_mvp.base.BaseView;
import com.android.anmol.feeds_mvp.feeds.model.FeedModel;

/**
 * Created by anmolsehgal on 27-03-2018.
 * <p>
 * This specifies the contract between the view and the presenter.
 */
public interface FeedDetailsContract {

    interface View extends BaseView<FeedDetailsPresenter> {

        void updateView(FeedModel newFeed);
    }

    interface FeedDetailsPresenter {

        void configureLikeStatus(@NonNull FeedModel feedModel);
    }
}
