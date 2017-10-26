package com.codetest.karma.myapplication.interfaces.api;

import com.codetest.karma.myapplication.contants.ConstAPI;
import com.codetest.karma.myapplication.data.model.Fruit;
import com.codetest.karma.myapplication.data.model.FruitData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by karma on 25/10/2017.
 */

public interface IFruitApi {
    @GET(ConstAPI.FRUIT_LIST)
    Call<FruitData> getFruitData();
}
