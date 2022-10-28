package com.example.a_math.Game.Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Map14 {
    public Map14(HashMap<Integer, List<String>> table_map, HashMap<Integer, String> select_chip, HashMap<Integer, Integer> point){
        table_map.put(0, Arrays.asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        table_map.put(1, Arrays.asList(null, "4", null, null, null, null, null, null, null, null, null, null, null, "16", null));
        table_map.put(2, Arrays.asList(null, "*kl", null, null, null, null, "5", null, null, null, null, null, null, "+", null));
        table_map.put(3, Arrays.asList(null, "9", null, "12", "-", "2", "0", "=", "-", "13", "+",  "5", null, "18", null));
        table_map.put(4, Arrays.asList(null, "-", null, null, null, null, "2", null, null, null, null,  null, null, "-kl", null));
        table_map.put(5, Arrays.asList(null, "1", null, null, "7", "1", "=", "3", "+kl", "8", "/", "2", "*kl", "17", null));
        table_map.put(6, Arrays.asList(null, "8", null, null, null, null, "10", null, null, null, null, null, null, "-kl", null));
        table_map.put(7, Arrays.asList("2",   "=",  "-kl",  "10",  "-c",  "4c",  "+", "16", "=",  "2",  "*",  "1",  "=",  "2", null));
        table_map.put(8, Arrays.asList(null, "3", null, null, null, null, "4", null, null, null, null,  null, null, "0", null));
        table_map.put(9, Arrays.asList(null, "5",  "=",  "5",  "=", "-c", "9", "/kl", "1", "+", "14",  null, null, "=", null));
        table_map.put(10, Arrays.asList(null, "-", null, null, null, null, "2", null, null, null, null, null, null, "-kl", null));
        table_map.put(11, Arrays.asList(null, "12", null, null, null, null, "/", null, null, null, null, null, null, "7", null));
        table_map.put(12, Arrays.asList(null, "-", null, null, null, null, "1", null, null, null, null, null, null, "+kl", null));
        table_map.put(13, Arrays.asList(null, "5c", null, null, null, null, null, null, null, null, null, null, null, "4", null));
        table_map.put(14, Arrays.asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));

        select_chip.put(0, "19");
        select_chip.put(1, "=");
        select_chip.put(2, "1");
        select_chip.put(3, "9");
        select_chip.put(4, "-");
        select_chip.put(5, "0");
        select_chip.put(6, "/");
        select_chip.put(7, "4");

        point.put(1, 15);
        point.put(2, 30);
        point.put(3, 90);
    }
    public static void getChip1(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "blank");
        select_chip.put(1, "1");
        select_chip.put(2, "=");
        select_chip.put(3, "2");
        select_chip.put(4, "1");
        select_chip.put(5, "4");
        select_chip.put(6, "+/-");
        select_chip.put(7, "blank");
    }

    public static void getChip2(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "-");
        select_chip.put(1, "=");
        select_chip.put(2, "12");
        select_chip.put(3, "blank");
        select_chip.put(4, "blank");
        select_chip.put(5, "-");
        select_chip.put(6, "*//");
        select_chip.put(7, "14");
    }

    public static void getChip3(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "blank");
        select_chip.put(1, "=");
        select_chip.put(2, "13");
        select_chip.put(3, "1");
        select_chip.put(4, "2");
        select_chip.put(5, "-");
        select_chip.put(6, "+");
        select_chip.put(7, "6");
    }

    public static void getChip4(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "2");
        select_chip.put(1, "=");
        select_chip.put(2, "19");
        select_chip.put(3, "1");
        select_chip.put(4, "1");
        select_chip.put(5, "+/-");
        select_chip.put(6, "*//");
        select_chip.put(7, "blank");
    }
}
