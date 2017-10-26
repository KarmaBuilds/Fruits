package com.codetest.karma.myapplication.interfaces.iview;

import android.content.Context;

import com.codetest.karma.myapplication.interfaces.ipresenter.IBasePresenter;

/**
 * Created by karma on 25/10/2017.
 */

public interface IBaseView<Presenter extends IBasePresenter> {
    void onPresenterAttachSuccess(Presenter presenter);

    Context getContext();
}
