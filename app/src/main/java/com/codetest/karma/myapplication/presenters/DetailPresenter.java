package com.codetest.karma.myapplication.presenters;

import com.codetest.karma.myapplication.interfaces.imodel.IData;
import com.codetest.karma.myapplication.interfaces.ipresenter.IDetailPresenter;
import com.codetest.karma.myapplication.utils.NetworkUtil;

/**
 * Created by karma on 25/10/2017.
 */

public class DetailPresenter extends BasePresenter implements IDetailPresenter {

    public DetailPresenter(IData data, NetworkUtil networkUtil) {
        super(data, networkUtil);
    }
}
