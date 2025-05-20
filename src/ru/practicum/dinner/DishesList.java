package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

class DishesList {

    HashMap<String, ArrayList<String>> dishes = new HashMap<>();
    ArrayList<String> dishesNames;

    void addDish(String dishType, String dishName) {
        if (dishes.containsKey(dishType)) {
            dishes.get(dishType).add(dishName);
        } else {
            dishesNames = new ArrayList<>();
            dishesNames.add(dishName);
            dishes.put(dishType, dishesNames);
        }
    }

    ArrayList<String> getDishList(String dishType) {
        return dishes.get(dishType);
    }

    boolean dishesListIsEmpty() {
        return dishes.isEmpty();
    }

    boolean isDishTypeExists(String type) {
        return dishes.containsKey(type);
    }
}
