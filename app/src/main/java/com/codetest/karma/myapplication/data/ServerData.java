package com.codetest.karma.myapplication.data;

import android.util.Log;

import com.codetest.karma.myapplication.data.model.Fruit;
import com.codetest.karma.myapplication.data.model.FruitData;
import com.codetest.karma.myapplication.interfaces.api.IFruitApi;
import com.codetest.karma.myapplication.interfaces.listeners.FetchListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by karma on 25/10/2017.
 */

public class ServerData implements Callback<FruitData> {
    private Retrofit retrofit;
    private IFruitApi api;

    private FetchListener listener;

    public ServerData(Retrofit retrofit) {
        this.retrofit = retrofit;
        this.api = retrofit.create(IFruitApi.class);
    }


    public void requestFruitList(FetchListener listener) {
        this.listener = listener;
        api.getFruitData().enqueue(this);
    }

    private void returnFetchResult(List<Fruit> fruits) {
        if (listener == null)
            return;
        listener.onFruitFetchComplete(fruits);

    }

    @Override
    public void onResponse(Call<FruitData> call, Response<FruitData> response) {
        Log.d("Server", "onResponse: Good " + response);
        returnFetchResult(response.body().getFruit());
    }

    @Override
    public void onFailure(Call<FruitData> call, Throwable t) {
        Log.d("ServerData", "onFailure: Bad: " + t.toString());
        returnFetchResult(null);
    }
}