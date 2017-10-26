package com.codetest.karma.myapplication.di.components;

import com.codetest.karma.myapplication.di.modules.ActivityMainModule;
import com.codetest.karma.myapplication.di.scopes.ActivityMainScope;
import com.codetest.karma.myapplication.views.MainActivity;

import dagger.Component;

/**
 * Created by karma on 25/10/2017.
 */
@ActivityMainScope
@Component(dependencies = PresenterComponent.class, modules = ActivityMainModule.class)
public interface ActivityMainComponent {
    void inject(MainActivity mainActivity);
}
