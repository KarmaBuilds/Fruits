package com.codetest.karma.myapplication.interfaces.imodel;

import com.codetest.karma.myapplication.interfaces.listeners.FetchListener;

/**
 * Created by karma on 25/10/2017.
 */

public interface IData {
    void fetchDataFromServer(FetchListener listener);

    String retrieveStoredFruits();

    void storeFruitData(String fruitData);
}
