package com.codetest.karma.myapplication.di.modules;

import com.codetest.karma.myapplication.di.scopes.ActivityMainScope;
import com.codetest.karma.myapplication.interfaces.imodel.IData;
import com.codetest.karma.myapplication.interfaces.ipresenter.IBasePresenter;
import com.codetest.karma.myapplication.interfaces.ipresenter.IMainPresenter;
import com.codetest.karma.myapplication.presenters.MainPresenter;
import com.codetest.karma.myapplication.utils.NetworkUtil;

import dagger.Module;
import dagger.Provides;

/**
 * Created by karma on 25/10/2017.
 */
@Module
public class ActivityMainModule {
    @Provides
    @ActivityMainScope
    IBasePresenter provideIMainPresenter(IData data, NetworkUtil networkUtil) {
        return new MainPresenter(data, networkUtil);
    }
}
