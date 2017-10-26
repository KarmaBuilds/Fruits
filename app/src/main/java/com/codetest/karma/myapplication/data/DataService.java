package com.codetest.karma.myapplication.data;

import com.codetest.karma.myapplication.data.model.Fruit;
import com.codetest.karma.myapplication.interfaces.imodel.IData;
import com.codetest.karma.myapplication.interfaces.listeners.FetchListener;
import com.codetest.karma.myapplication.utils.LocalDataUtil;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by karma on 25/10/2017.
 */

public class DataService implements IData {
    private LocalData localData;
    private ServerData serverData;
    private FetchListener listener;

    public DataService(LocalData localData, ServerData serverData) {
        this.localData = localData;
        this.serverData = serverData;
    }

    @Override
    public void fetchDataFromServer(FetchListener listener) {
        serverData.requestFruitList(listener);
    }

    @Override
    public String retrieveStoredFruits() {
        return localData.getStoredFruitData();
    }

    @Override
    public void storeFruitData(String fruitData) {
        localData.storeFruitData(fruitData);
    }
}
