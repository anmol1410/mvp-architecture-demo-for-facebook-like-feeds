/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.anmol.feeds_mvp.feeds;

import android.support.annotation.NonNull;

import com.android.anmol.feeds_mvp.base.BasePresenter;
import com.android.anmol.feeds_mvp.base.BaseView;
import com.android.anmol.feeds_mvp.feeds.model.BaseFeedItemModel;
import com.android.anmol.feeds_mvp.feeds.model.FeedModel;

import java.util.List;

/**
 * Created by anmolsehgal on 27-03-2018.
 * <p>
 * This specifies the contract between the view and the presenter.
 */
public interface FeedsContract {

    interface View extends BaseView<FeedsPresenter> {

        void setLoadingIndicator(boolean active);

        void showFeeds(List<BaseFeedItemModel> feeds);

        void showFeedDetailsUi(int feedPos);

        boolean isActive();

        void showLoadingFeedsError(boolean showError);

        void updateView(int feedPositionToUpdate, FeedModel newFeed);
    }

    interface FeedsPresenter extends BasePresenter {

        void fetchFeeds(boolean forceUpdate);

        void openFeedDetails(int feedPos);

        void configureLikeStatus(@NonNull FeedModel feedModel, int pos);

        void refreshLikeStatus(FeedModel feedModel, int feedPos);
    }
}
