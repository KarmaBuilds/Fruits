package com.codetest.karma.myapplication.di.modules;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.codetest.karma.myapplication.data.LocalData;
import com.codetest.karma.myapplication.data.ServerData;
import com.codetest.karma.myapplication.di.scopes.DataScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by karma on 25/10/2017.
 */

@Module
public class DataModule {
    @Provides
    @DataScope
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @DataScope
    LocalData providesLocalData(SharedPreferences sharedPreferences) {
        return new LocalData(sharedPreferences);
    }

    @Provides
    @DataScope
    ServerData providesServerData(Retrofit retrofit) {
        return new ServerData(retrofit);
    }
}
