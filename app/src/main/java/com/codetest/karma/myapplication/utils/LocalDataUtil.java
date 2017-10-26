package com.codetest.karma.myapplication.utils;

import com.codetest.karma.myapplication.data.model.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by karma on 26/10/2017.
 */

public class LocalDataUtil {

    public static String toStringFromList(List<Fruit> fruitList) {
        String fruitsString = null;
        if (fruitList == null || fruitList.isEmpty())
            return fruitsString;
        for (Fruit fruit : fruitList) {
            if (fruitsString == null)
                fruitsString = fruit.toString();
            else
                fruitsString += "," + fruit.toString();
        }
        return fruitsString;
    }

    public static List<Fruit> toFruitListFromString(String fruits) {
        if (fruits == null || fruits.isEmpty())
            return null;
        String[] fruitArray = fruits.split(",");
        List<Fruit> fruitList = new ArrayList<>();
        Fruit f;
        String[] fruitFields;
        for (String fruit : fruitArray) {
            fruitFields = fruit.split("|");
            if (fruit.length() != 3)
                continue;
            f = new Fruit();
            f.setType(fruitFields[0]);
            f.setPrice(fruitFields[1]);
            f.setWeight(fruitFields[2]);
            fruitList.add(f);
        }
        return fruitList;
    }
}
