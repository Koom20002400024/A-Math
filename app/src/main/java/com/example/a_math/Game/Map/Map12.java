package com.example.a_math.Game.Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Map12 {
    public Map12(HashMap<Integer, List<String>> table_map, HashMap<Integer, String> select_chip, HashMap<Integer, Integer> point){
        table_map.put(0, Arrays.asList("9", "3", "+kl", "9", "3", "=", "1", "8", "6", "-kl", "16", "/", "8", "+", "2"));
        table_map.put(1, Arrays.asList("4", null, null, null, null, null, null, null, "+", null, null, null, null, null, null));
        table_map.put(2, Arrays.asList("7", null, null, null, null, null, null, null, "10", null, null, null, null, null, null));
        table_map.put(3, Arrays.asList("*kl", null, null, "4", null, null, null, null, "=", null, null,  "6", null, null, null));
        table_map.put(4, Arrays.asList("0", null, null, "3", null, null, null, null, "2", null, null,  "/kl", null, null, null));
        table_map.put(5, Arrays.asList("+kl", null, null, "=", null, null, null, null, "5", null, null, "2", null, null, null));
        table_map.put(6, Arrays.asList("2", null, null, "3", null, null, null, null, "6", null, null,  "-", null, null, null));
        table_map.put(7, Arrays.asList("4",   "/",  "1",  "4",  "=",  "2",  "/", "7", "/c",  "1",  "/kl",  "1",  "9",  "*",  "19"));
        table_map.put(8, Arrays.asList("0", null, null, "+", null, null, null, null, "16", null, null,  "=", null, null, null));
        table_map.put(9, Arrays.asList("/kl", null, null, "9", null, null, null, null, null, "5", "=",  "5", null, null, null));
        table_map.put(10, Arrays.asList("12", null, null, "+kl", null, null, null, null, null, null, null, "-", null, null, null));
        table_map.put(11, Arrays.asList("*", null, null, "0", null, null, null, null, null, null, null, "3", null, null, null));
        table_map.put(12, Arrays.asList("1", null, null, "*", null, null, null, null, null, null, null, "=", null, null, null));
        table_map.put(13, Arrays.asList("=c", null, "-kl", "11", "=", "-", "8", "-kl", "3", null, null, "2", null, null, null));
        table_map.put(14, Arrays.asList("20", null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        select_chip.put(0, "8");
        select_chip.put(1, "=");
        select_chip.put(2, "blank");
        select_chip.put(3, "0");
        select_chip.put(4, "8");
        select_chip.put(5, "+/-");
        select_chip.put(6, "4");
        select_chip.put(7, "2");

        point.put(1, 15);
        point.put(2, 30);
        point.put(3, 90);
    }
    public static void getChip1(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "12");
        select_chip.put(1, "1");
        select_chip.put(2, "=");
        select_chip.put(3, "2");
        select_chip.put(4, "+");
        select_chip.put(5, "blank");
        select_chip.put(6, "4");
        select_chip.put(7, "blank");
    }

    public static void getChip2(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "-");
        select_chip.put(1, "=");
        select_chip.put(2, "blank");
        select_chip.put(3, "3");
        select_chip.put(4, "18");
        select_chip.put(5, "blank");
        select_chip.put(6, "/");
        select_chip.put(7, "12");
    }

    public static void getChip3(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "3");
        select_chip.put(1, "=");
        select_chip.put(2, "13");
        select_chip.put(3, "blank");
        select_chip.put(4, "1");
        select_chip.put(5, "2");
        select_chip.put(6, "+/-");
        select_chip.put(7, "9");
    }

    public static void getChip4(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "blank");
        select_chip.put(1, "=");
        select_chip.put(2, "4");
        select_chip.put(3, "2");
        select_chip.put(4, "0");
        select_chip.put(5, "+/-");
        select_chip.put(6, "+/-");
        select_chip.put(7, "10");
    }
}
