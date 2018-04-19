package com.android.anmol.feeds_mvp.feeds;

/**
 * Created by anmolsehgal on 27-03-2018.
 * <p>
 * Triggered when te Feed is clicked or the like button is clicked.
 */
interface FeedClickListener {

    /**
     * To listen to the Feed click, so that details page can be launched.
     *
     * @param feedPos Pos of the Feed clicked.
     */
    void onFeedClicked(int feedPos);

    /**
     * To listen to the Like Button clicked, so that its status can be changed.
     *
     * @param feedPos Pos of the Feed clicked.
     */
    void onLikeButtonClicked(int feedPos);
}
