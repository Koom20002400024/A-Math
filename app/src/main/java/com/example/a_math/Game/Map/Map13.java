package com.example.a_math.Game.Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Map13 {
    public Map13(HashMap<Integer, List<String>> table_map, HashMap<Integer, String> select_chip, HashMap<Integer, Integer> point){
        table_map.put(0, Arrays.asList(null, null, null, null, null, null, null, "8", null, null, null, null, null, null, null));
        table_map.put(1, Arrays.asList(null, "7", "=", "6", "+", "3", "/kl", "3", "+", "0", "/", "9", "8", "7", null));
        table_map.put(2, Arrays.asList(null, null, null, null, null, null, null, "*", null, "-", null, null, null, null, null));
        table_map.put(3, Arrays.asList(null, null, null, "1", "0", "=", "3", "0", "-c", "16", "-c", "4", null, null, null));
        table_map.put(4, Arrays.asList(null, null, null, null, null, null, null, "+", null, "+", null, null, null, null, null));
        table_map.put(5, Arrays.asList(null, null, null, null, null, "7", "=", "5", "+", "12", "/", "6", null, null, null));
        table_map.put(6, Arrays.asList(null, null, null, null, null, null, null, "=", null, "*kl", null, null, null, null, null));
        table_map.put(7, Arrays.asList("12c",  null, null, null, null, null, null,"5", null, "2", null, null, null, null, null));
        table_map.put(8, Arrays.asList("/kl", null, null, null, null, null, null, "*kl", null, "=", null,  null, null, null, null));
        table_map.put(9, Arrays.asList("12", null, "18", null, null, null, null, "1", null, "8", null,  null, null, null, null));
        table_map.put(10, Arrays.asList("-", "15", "*", "3", "+kl", "4", "8", "=", "3", null, null, null, null, null, null));
        table_map.put(11, Arrays.asList("11", null, "4", null, null, null, null, "1", null, null, null, null, null, null, null));
        table_map.put(12, Arrays.asList("=", null, "=", null, null, null, null, "0", null, null, null, null, null, null, null));
        table_map.put(13, Arrays.asList("-kl", null, "7", null, null, null, null, "/", null, null, null, null, null, null, null));
        table_map.put(14, Arrays.asList("10", null, "2", null, null, "2", "=", "2", "+kl", "0", "*", "9", "1", "5", null));

        select_chip.put(0, "*");
        select_chip.put(1, "9");
        select_chip.put(2, "+/-");
        select_chip.put(3, "9");
        select_chip.put(4, "=");
        select_chip.put(5, "1");
        select_chip.put(6, "19");
        select_chip.put(7, "blank");

        point.put(1, 15);
        point.put(2, 30);
        point.put(3, 90);
    }
    public static void getChip1(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "blank");
        select_chip.put(1, "+/-");
        select_chip.put(2, "=");
        select_chip.put(3, "2");
        select_chip.put(4, "1");
        select_chip.put(5, "4");
        select_chip.put(6, "*");
        select_chip.put(7, "3");
    }

    public static void getChip2(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "+/-");
        select_chip.put(1, "=");
        select_chip.put(2, "12");
        select_chip.put(3, "blank");
        select_chip.put(4, "18");
        select_chip.put(5, "+/-");
        select_chip.put(6, "*//");
        select_chip.put(7, "14");
    }

    public static void getChip3(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "blank");
        select_chip.put(1, "=");
        select_chip.put(2, "13");
        select_chip.put(3, "+/-");
        select_chip.put(4, "1");
        select_chip.put(5, "6");
        select_chip.put(6, "+/-");
        select_chip.put(7, "9");
    }

    public static void getChip4(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "2");
        select_chip.put(1, "=");
        select_chip.put(2, "11");
        select_chip.put(3, "1");
        select_chip.put(4, "1");
        select_chip.put(5, "-");
        select_chip.put(6, "+");
        select_chip.put(7, "blank");
    }
}
