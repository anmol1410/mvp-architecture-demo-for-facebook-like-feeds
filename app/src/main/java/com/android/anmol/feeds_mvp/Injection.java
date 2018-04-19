package com.android.anmol.feeds_mvp;

import com.android.anmol.feeds_mvp.source.FeedsRepository;
import com.android.anmol.feeds_mvp.source.remote.FeedsRemoteDataSource;

/**
 * Created by anmolsehgal on 27-03-2018.
 * <p>
 * Injects various components throughout the application.
 */
public class Injection {

    /**
     * Provides the Feeds repository which handles the Network Calls, Databases etc anything.
     *
     * @return The Feeds Repository.
     */
    public static FeedsRepository provideFeedsRepository() {
        return FeedsRepository.getInstance(FeedsRemoteDataSource.getInstance());
    }
}