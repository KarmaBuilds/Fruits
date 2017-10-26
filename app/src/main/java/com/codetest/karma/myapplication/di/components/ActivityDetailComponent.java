package com.codetest.karma.myapplication.di.components;

import com.codetest.karma.myapplication.di.modules.ActivityDetailModule;
import com.codetest.karma.myapplication.di.scopes.ActivityDetailScope;
import com.codetest.karma.myapplication.views.DetailActivity;

import dagger.Component;

/**
 * Created by karma on 25/10/2017.
 */
@ActivityDetailScope
@Component(dependencies = PresenterComponent.class, modules = ActivityDetailModule.class)
public interface ActivityDetailComponent {
    void inject(DetailActivity detailActivity);
}
