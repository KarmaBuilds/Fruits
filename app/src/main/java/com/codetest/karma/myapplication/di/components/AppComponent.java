package com.codetest.karma.myapplication.di.components;

import android.app.Application;

import com.codetest.karma.myapplication.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by karma on 25/10/2017.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Application application();
}
