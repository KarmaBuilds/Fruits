package com.codetest.karma.myapplication.interfaces.iview;


import com.codetest.karma.myapplication.data.model.Fruit;

import java.util.List;

/**
 * Created by karma on 25/10/2017.
 */

public interface IMainView extends IBaseView {
    void onFruitListFetchSuccess(List<Fruit> fruitList);

    void showError(String error);
}
