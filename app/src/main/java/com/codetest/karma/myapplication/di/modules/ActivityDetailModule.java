package com.codetest.karma.myapplication.di.modules;

import com.codetest.karma.myapplication.di.scopes.ActivityDetailScope;
import com.codetest.karma.myapplication.interfaces.imodel.IData;
import com.codetest.karma.myapplication.interfaces.ipresenter.IBasePresenter;
import com.codetest.karma.myapplication.interfaces.ipresenter.IDetailPresenter;
import com.codetest.karma.myapplication.presenters.DetailPresenter;
import com.codetest.karma.myapplication.utils.NetworkUtil;

import dagger.Module;
import dagger.Provides;

/**
 * Created by karma on 25/10/2017.
 */
@Module
public class ActivityDetailModule {
    @Provides
    @ActivityDetailScope
    IBasePresenter providesIDetailPresenter(IData data, NetworkUtil networkUtil) {
        return new DetailPresenter(data, networkUtil);
    }
}
