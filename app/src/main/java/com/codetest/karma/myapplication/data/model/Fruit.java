package com.codetest.karma.myapplication.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by karma on 25/10/2017.
 */

public class Fruit implements Parcelable {
    private String type;
    private String price;
    private String weight;

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(price);
        dest.writeString(weight);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Fruit> CREATOR = new Creator<Fruit>() {
        @Override
        public Fruit createFromParcel(Parcel in) {
            Fruit fruit = new Fruit();
            fruit.setType(in.readString());
            fruit.setPrice(in.readString());
            fruit.setWeight(in.readString());
            return fruit;
        }

        @Override
        public Fruit[] newArray(int size) {
            return new Fruit[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return type + "|" + price + "|" + weight;
    }
}
