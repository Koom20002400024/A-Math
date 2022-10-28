package com.example.a_math.Game.Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Map10 {
    public Map10(HashMap<Integer, List<String>> table_map, HashMap<Integer, String> select_chip, HashMap<Integer, Integer> point){
        table_map.put(0, Arrays.asList(null, null, null, null, null, null, null, "3", null, null, null, null, null, null, null));
        table_map.put(1, Arrays.asList(null, null, null, null, null, null, null, "5", null, null, null, null, null, null, null));
        table_map.put(2, Arrays.asList(null, null, null, null, null, null, null, "-", null, null, null, null, null, null, null));
        table_map.put(3, Arrays.asList(null, null, null, null, null, null, null, "16", null, null, null, null, null, null, null));
        table_map.put(4, Arrays.asList(null, null, null, null, null, null, "12", "=", "12", null, null, null, null, null, null));
        table_map.put(5, Arrays.asList(null, null, null, null, null, null, null, "2", null, null, null, null, null, null, null));
        table_map.put(6, Arrays.asList(null, null, null, null, null, null, null, "+", null, null,  "1", null, null, null, null));
        table_map.put(7, Arrays.asList("19",  "*",  "2",  "-",  "2",  "0",  "=", "17",  "+",  "1",  "=", "3",  "6",  "-",  "18"));
        table_map.put(8, Arrays.asList(null, null, null, null, null, null, null, "+", null, null,  "1", null, null, null, null));
        table_map.put(9, Arrays.asList(null, null, null, null, null, null, null, "0", null, null, null, null, null, null, null));
        table_map.put(10, Arrays.asList(null, null, null, null, null, null, null, "*", null, null, null, null, null, null, null));
        table_map.put(11, Arrays.asList(null, null, null, null, null, null, null, "1", null, null, null, null, null, null, null));
        table_map.put(12, Arrays.asList(null, null, null, null, null, null, null, "8", null, null, null, null, null, null, null));
        table_map.put(13, Arrays.asList(null, null, null, null, null, null, null, "/", null, null, null, null, null, null, null));
        table_map.put(14, Arrays.asList(null, null, null, null, null, null, null, "5", null, null, null, null, null, null, null));

        select_chip.put(0, "*//");
        select_chip.put(1, "=");
        select_chip.put(2, "1");
        select_chip.put(3, "3");
        select_chip.put(4, "2");
        select_chip.put(5, "0");
        select_chip.put(6, "+/-");
        select_chip.put(7, "15");

        point.put(1, 15);
        point.put(2, 30);
        point.put(3, 90);
    }
    public static void getChip1(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "13");
        select_chip.put(1, "blank");
        select_chip.put(2, "=");
        select_chip.put(3, "blank");
        select_chip.put(4, "+/-");
        select_chip.put(5, "4");
        select_chip.put(6, "+/-");
        select_chip.put(7, "3");
    }

    public static void getChip2(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "4");
        select_chip.put(1, "=");
        select_chip.put(2, "blank");
        select_chip.put(3, "16");
        select_chip.put(4, "9");
        select_chip.put(5, "+/-");
        select_chip.put(6, "*//");
        select_chip.put(7, "9");
    }

    public static void getChip3(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "-");
        select_chip.put(1, "=");
        select_chip.put(2, "*");
        select_chip.put(3, "blank");
        select_chip.put(4, "1");
        select_chip.put(5, "1");
        select_chip.put(6, "+/-");
        select_chip.put(7, "11");
    }

    public static void getChip4(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "2");
        select_chip.put(1, "=");
        select_chip.put(2, "5");
        select_chip.put(3, "3");
        select_chip.put(4, "1");
        select_chip.put(5, "-");
        select_chip.put(6, "+/-");
        select_chip.put(7, "blank");
    }
}
