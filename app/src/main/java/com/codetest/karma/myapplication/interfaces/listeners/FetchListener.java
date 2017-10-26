package com.codetest.karma.myapplication.interfaces.listeners;

import com.codetest.karma.myapplication.data.model.Fruit;

import java.util.List;

/**
 * Created by karma on 26/10/2017.
 */

public interface FetchListener {
    void onFruitFetchComplete(List<Fruit> fruits);
}
