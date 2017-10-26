package com.codetest.karma.myapplication.data;

import android.content.SharedPreferences;

import com.codetest.karma.myapplication.contants.Const;

/**
 * Created by karma on 25/10/2017.
 */

public class LocalData {
    private SharedPreferences sharedPreferences;

    public LocalData(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void storeFruitData(String fruitData) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Const.FRUIT_DATA_KEY, fruitData);
        editor.apply();
    }

    public String getStoredFruitData() {
        return sharedPreferences.getString(Const.FRUIT_DATA_KEY, null);
    }
}
