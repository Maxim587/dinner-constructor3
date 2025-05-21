package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

class DishesList {

    HashMap<String, ArrayList<String>> dishes = new HashMap<>();

    void addDish(String dishType, String dishName) {
        dishes.computeIfAbsent(dishType,type -> new ArrayList<>()).add(dishName);
        //Георгий, привет! Спасибо за интересную подсказку. Сделал через IfAbsent
        //dishes.compute(dishType, (type, names) -> (names == null) ? new ArrayList<>() : names).add(dishName);
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
