package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    HashMap<String, ArrayList<String>> dishes = new HashMap<>();
    Random random = new Random(); //move to main???

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

    boolean isDishTypeExists(String type) { //checkType
        return dishes.containsKey(type);
    }

    ArrayList<ArrayList<String>> generateCombos(int numberOfCombos, ArrayList<String> dishTypes) {
        ArrayList<ArrayList<String>> combos = new ArrayList<>();
        String comboDishName;// = "";
        int randomDishNumber;// = -1;

        for (int i = 1; i <= numberOfCombos; i++) {
            ArrayList<String> dishesInCombo = new ArrayList<>();
            for (String dishType : dishTypes) {
                randomDishNumber = random.nextInt(dishTypes.size());
                comboDishName = dishes.get(dishType).get(randomDishNumber);
                dishesInCombo.add(comboDishName);
            }
            combos.add(dishesInCombo);
        }
        return combos;
    }


}
