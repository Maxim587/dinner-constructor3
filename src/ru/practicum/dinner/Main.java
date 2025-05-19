package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static DinnerConstructor dinnerConstructor;
    static Scanner scanner;

    public static void main(String[] args) {
        dinnerConstructor = new DinnerConstructor();
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

        // добавьте новое блюдо
        dinnerConstructor.addDish(dishType, dishName);
    }

    private static void addDishTypeForCombo(String dishType, ArrayList<String> dishTypes, DinnerConstructor dc) {
        if (!dc.isTypeExists(dishType)) {
            System.out.println("Вы ввели несуществующий тип блюда. Пожалуйста, повторите ввод");
        } else {
            dishTypes.add(dishType);
        }
    }

    private static void generateDishCombo() {
        if (dinnerConstructor.dishesListIsEmpty()) {
            System.out.println("Список блюд пуст. Сначала нужно его наполнить");
            return;
        }

        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        ArrayList<String> dishTypes = new ArrayList<>();
        addDishTypeForCombo (nextItem, dishTypes, dinnerConstructor);

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            nextItem = scanner.nextLine();
        }

        // сгенерируйте комбинации блюд и выведите на экран

    }
}
