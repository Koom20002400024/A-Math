package com.example.a_math.Game.Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Map4 {
    public Map4(HashMap<Integer, List<String>> table_map, HashMap<Integer, String> select_chip, HashMap<Integer, Integer> point){
        table_map.put(0, Arrays.asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        table_map.put(1, Arrays.asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        table_map.put(2, Arrays.asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        table_map.put(3, Arrays.asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        table_map.put(4, Arrays.asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        table_map.put(5, Arrays.asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        table_map.put(6, Arrays.asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        table_map.put(7, Arrays.asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        table_map.put(8, Arrays.asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        table_map.put(9, Arrays.asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        table_map.put(10, Arrays.asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        table_map.put(11, Arrays.asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        table_map.put(12, Arrays.asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        table_map.put(13, Arrays.asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        table_map.put(14, Arrays.asList(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));


        select_chip.put(0, "0");
        select_chip.put(1, "=");
        select_chip.put(2, "15");
        select_chip.put(3, "0");
        select_chip.put(4, "5");
        select_chip.put(5, "1");
        select_chip.put(6, "*//");
        select_chip.put(7, "1");

        point.put(1, 15);
        point.put(2, 30);
        point.put(3, 60);
    }
    public static void getChip1(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "12");
        select_chip.put(1, "/");
        select_chip.put(2, "=");
        select_chip.put(3, "4");
        select_chip.put(4, "-");
        select_chip.put(5, "8");
        select_chip.put(6, "-");
        select_chip.put(7, "4");
    }

    public static void getChip2(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "15");
        select_chip.put(1, "=");
        select_chip.put(2, "+");
        select_chip.put(3, "0");
        select_chip.put(4, "5");
        select_chip.put(5, "1");
        select_chip.put(6, "/");
        select_chip.put(7, "1");
    }

    public static void getChip3(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "2");
        select_chip.put(1, "=");
        select_chip.put(2, "3");
        select_chip.put(3, "blank");
        select_chip.put(4, "1");
        select_chip.put(5, "4");
        select_chip.put(6, "*//");
        select_chip.put(7, "0");

    }

    public static void getChip4(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "2");
        select_chip.put(1, "=");
        select_chip.put(2, "11");
        select_chip.put(3, "-");
        select_chip.put(4, "1");
        select_chip.put(5, "-");
        select_chip.put(6, "+/-");
        select_chip.put(7, "blank");
    }
}
