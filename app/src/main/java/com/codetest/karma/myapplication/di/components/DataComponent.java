package com.codetest.karma.myapplication.di.components;

import android.app.Application;

import com.codetest.karma.myapplication.data.LocalData;
import com.codetest.karma.myapplication.data.ServerData;
import com.codetest.karma.myapplication.di.modules.DataModule;
import com.codetest.karma.myapplication.di.modules.NetModule;
import com.codetest.karma.myapplication.di.scopes.DataScope;
import com.codetest.karma.myapplication.utils.NetworkUtil;

import dagger.Component;

/**
 * Created by karma on 25/10/2017.
 */
@DataScope
@Component(dependencies = AppComponent.class, modules = {NetModule.class, DataModule.class})
public interface DataComponent {

    LocalData localData();

    ServerData serverData();

    Application application();
}
