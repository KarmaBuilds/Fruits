package com.codetest.karma.myapplication.interfaces.ipresenter;

import com.codetest.karma.myapplication.interfaces.iview.IBaseView;

/**
 * Created by karma on 25/10/2017.
 */

public interface IBasePresenter<View extends IBaseView> {
    void attachView(View view);

    void detachView();
}
