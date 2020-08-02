package com.module.nix.firstTask.main;

import com.module.nix.firstTask.ConvertDate;
import com.module.nix.secondTask.FirstUniqueName;
import com.module.nix.thirdTask.FindMinCost;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {

        List<String> listDates = new ArrayList<>();
        List<String> listName = new ArrayList<>();

        listName.add("Jennifer");
        listName.add("John");
        listName.add("Adam");
        listName.add("Adam");
        listName.add("Ben");
        listName.add("Jennifer");
        listName.add("John");

        listDates.add("05/04/2020");
        listDates.add("04-05-2020");
        listDates.add("2020/04/05");


        System.out.println("\n1. Дан список дат (строковая запись) в форматах типа “2020/04/05”,\n" +
                "“05/04/2020”, “04-05-2020” (все даты в примере - 5е апреля 2020)\n" +
                "Вернуть список дат (строковая запись) в формате “20200405”. Даты с неверным\n" +
                "форматом - игнорировать.\n");

        System.out.println(ConvertDate.convertAnyDate(listDates) + "\n");


        System.out.println("2. Дан список имен. Найти первое уникальное имя. Допустимая временная\n" +
                "сложность - O(n) при условии, что доступ к элементу списка по индексу - O(1).\n");

        System.out.println(FirstUniqueName.getFirstUniqueName(listName) + "\n");


        System.out.println("3. Дан список городов. Каждый путь между городами имеет цену (целое\n" +
                "положительное число). Задача - найти самый выгодный путь между двумя\n" +
                "городами. Максимально возможная цена пути - 200000.\n" +
                "Данные условия необходимо считать из файла input.txt\n" +
                "Результат надо записать в файл output.txt\n");

        try {
            FindMinCost.writeResultToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
