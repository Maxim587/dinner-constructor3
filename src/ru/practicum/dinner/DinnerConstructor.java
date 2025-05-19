package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {

    HashMap<String, ArrayList<String>> dishes = new HashMap<>();


    void addDish(String dishType, String dishName) {
        if (dishes.containsKey(dishType)) {
            dishes.get(dishType).add(dishName);
        } else {
            ArrayList<String> dishesNames = new ArrayList<>();
            dishesNames.add(dishName);
            dishes.put(dishType, dishesNames);
        }
    }

    boolean dishesListIsEmpty() {
        return dishes.isEmpty();
    }

    boolean isTypeExists(String type) {
        return dishes.containsKey(type);
    }
}
