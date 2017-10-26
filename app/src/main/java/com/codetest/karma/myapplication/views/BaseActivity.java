package com.codetest.karma.myapplication.views;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.codetest.karma.myapplication.TheApplication;
import com.codetest.karma.myapplication.interfaces.ipresenter.IBasePresenter;
import com.codetest.karma.myapplication.interfaces.iview.IBaseView;

import javax.inject.Inject;

/**
 * Created by karma on 25/10/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {
    @Inject
    IBasePresenter basePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupDagger();
        onPresenterAttachSuccess(basePresenter);
        basePresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        basePresenter.detachView();
    }

    private void setupDagger() {
        ((TheApplication) getApplication()).inject(this);
    }

    @Override
    public Context getContext() {
        return this;
    }
}
