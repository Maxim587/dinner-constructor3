package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {

    Random random;
    DishesList dishesList;

    DinnerConstructor(DishesList dishesList, Random random) {
        this.random = random;
        this.dishesList = dishesList;
    }

    ArrayList<ArrayList<String>> generateCombos(int numberOfCombos, ArrayList<String> dishTypes) {
        ArrayList<ArrayList<String>> combos = new ArrayList<>();
        String comboDishName;
        int randomDishNumber;
        ArrayList<String> dishNames;

        for (int i = 1; i <= numberOfCombos; i++) {
            ArrayList<String> dishesInCombo = new ArrayList<>();
            for (String dishType : dishTypes) {
                dishNames = dishesList.getDishList(dishType);
                randomDishNumber = random.nextInt(dishNames.size());
                comboDishName = dishNames.get(randomDishNumber);
                dishesInCombo.add(comboDishName);
            }
            combos.add(dishesInCombo);
        }
        return combos;
    }
}
