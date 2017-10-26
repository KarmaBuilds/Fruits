package com.codetest.karma.myapplication.presenters;

import com.codetest.karma.myapplication.contants.Const;
import com.codetest.karma.myapplication.interfaces.imodel.IData;
import com.codetest.karma.myapplication.interfaces.ipresenter.IMainPresenter;
import com.codetest.karma.myapplication.interfaces.iview.IBaseView;
import com.codetest.karma.myapplication.interfaces.iview.IMainView;
import com.codetest.karma.myapplication.utils.LocalDataUtil;
import com.codetest.karma.myapplication.utils.NetworkUtil;

/**
 * Created by karma on 25/10/2017.
 */

public class MainPresenter extends BasePresenter implements IMainPresenter {
    IData data;
    IMainView view;

    public MainPresenter(IData data, NetworkUtil networkUtil) {
        super(data, networkUtil);
        this.data = data;
    }

    @Override
    public void fetchFruits() {
        if (isNetworkAvailable()) {
            data.fetchDataFromServer(fruits -> {
                data.storeFruitData(LocalDataUtil.toStringFromList(fruits));
                view.onFruitListFetchSuccess(fruits);
            });
            return;
        }
        String localFruits = data.retrieveStoredFruits();
        if (localFruits != null && !localFruits.isEmpty()) {
            view.onFruitListFetchSuccess(LocalDataUtil.toFruitListFromString(localFruits));
            return;
        }
        view.showError(Const.NO_INTERNET_ERROR);
    }

    @Override
    public void attachView(IBaseView view) {
        super.attachView(view);
        this.view = (IMainView) view;
    }
}
