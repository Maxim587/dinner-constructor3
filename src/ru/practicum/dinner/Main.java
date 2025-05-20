package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {

    static DinnerConstructor dinnerConstructor;
    static Scanner scanner;
    static Random random;
    static DishesList dishesList;

    public static void main(String[] args) {
        dishesList = new DishesList();
        random = new Random();
        dinnerConstructor = new DinnerConstructor(dishesList, random);
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dishesList.addDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        if (dishesList.dishesListIsEmpty()) {
            System.out.println("Список блюд пуст. Сначала нужно его наполнить");
            System.out.println();
            return;
        }

        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать (0 для возврата в меню):");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();
        if (numberOfCombos == 0) {
            return;
        }

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). " +
                "Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        ArrayList<String> dishTypes = new ArrayList<>();
        addDishTypeForCombo(nextItem, dishTypes);

        while (!nextItem.isEmpty()) {
            nextItem = scanner.nextLine();
            addDishTypeForCombo(nextItem, dishTypes);
        }

        int combosCounter = 1;
        for (ArrayList<String> combo : dinnerConstructor.generateCombos(numberOfCombos, dishTypes)) {
            System.out.println("Комбо " + combosCounter);
            System.out.println(combo);
            combosCounter++;
        }
        System.out.println();
    }

    private static void addDishTypeForCombo(String dishType, ArrayList<String> dishTypes) {
        if (dishType.isEmpty()) {
            return;
        }

        if (!dishesList.isDishTypeExists(dishType)) {
            System.out.println("Вы ввели несуществующий тип блюда. Пожалуйста, повторите ввод");
        } else {
            dishTypes.add(dishType);
        }
    }
}
