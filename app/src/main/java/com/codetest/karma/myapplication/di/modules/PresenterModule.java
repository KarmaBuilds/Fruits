package com.codetest.karma.myapplication.di.modules;

import android.app.Application;

import com.codetest.karma.myapplication.data.DataService;
import com.codetest.karma.myapplication.data.LocalData;
import com.codetest.karma.myapplication.data.ServerData;
import com.codetest.karma.myapplication.di.scopes.PresenterScope;
import com.codetest.karma.myapplication.interfaces.imodel.IData;
import com.codetest.karma.myapplication.utils.NetworkUtil;

import dagger.Module;
import dagger.Provides;

/**
 * Created by karma on 25/10/2017.
 */
@Module
public class PresenterModule {
    @Provides
    @PresenterScope
    NetworkUtil providesNetworkUtil(Application application) {
        return new NetworkUtil(application);
    }

    @Provides
    @PresenterScope
    IData provideIData(LocalData localData, ServerData serverData) {
        return new DataService(localData, serverData);
    }

}
