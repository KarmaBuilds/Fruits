package com.codetest.karma.myapplication.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by karma on 26/10/2017.
 */

public class FruitData implements Parcelable {
    List<Fruit> fruit;


    public List<Fruit> getFruit() {
        return fruit;
    }

    public void setFruit(List<Fruit> fruit) {
        this.fruit = fruit;
    }

    protected FruitData(Parcel in) {
        in.readList(fruit, Fruit.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(fruit);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FruitData> CREATOR = new Creator<FruitData>() {
        @Override
        public FruitData createFromParcel(Parcel in) {
            return new FruitData(in);
        }

        @Override
        public FruitData[] newArray(int size) {
            return new FruitData[size];
        }
    };
}
