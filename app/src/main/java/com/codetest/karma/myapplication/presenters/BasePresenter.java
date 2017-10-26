package com.codetest.karma.myapplication.presenters;

import com.codetest.karma.myapplication.interfaces.imodel.IData;
import com.codetest.karma.myapplication.interfaces.ipresenter.IBasePresenter;
import com.codetest.karma.myapplication.interfaces.iview.IBaseView;
import com.codetest.karma.myapplication.utils.NetworkUtil;

/**
 * Created by karma on 25/10/2017.
 */

public class BasePresenter implements IBasePresenter {
    private NetworkUtil networkUtil;
    private IData data;
    private IBaseView view;

    public BasePresenter(IData data, NetworkUtil networkUtil) {
        this.data = data;
        this.networkUtil = networkUtil;
    }

    boolean isNetworkAvailable() {
        return networkUtil.isNetworkOnline();
    }

    @Override
    public void attachView(IBaseView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
