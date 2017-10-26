package com.codetest.karma.myapplication.di.components;

import com.codetest.karma.myapplication.di.modules.PresenterModule;
import com.codetest.karma.myapplication.di.scopes.PresenterScope;
import com.codetest.karma.myapplication.interfaces.imodel.IData;
import com.codetest.karma.myapplication.utils.NetworkUtil;

import dagger.Component;

/**
 * Created by karma on 25/10/2017.
 */
@PresenterScope
@Component(dependencies = DataComponent.class, modules = PresenterModule.class)
public interface PresenterComponent {
    IData data();

    NetworkUtil networkUtil();
}
