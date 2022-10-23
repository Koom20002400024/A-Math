package com.example.a_math.Game.Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Map1 {

    public Map1(HashMap<Integer, List<String>> table_map, HashMap<Integer, String> select_chip, HashMap<Integer, Integer> point) {
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

        select_chip.put(0, "2");
        select_chip.put(1, "=");
        select_chip.put(2, "3");
        select_chip.put(3, "-");
        select_chip.put(4, "2");
        select_chip.put(5, "4");
        select_chip.put(6, "+");
        select_chip.put(7, "1");

        point.put(1, 3);
        point.put(2, 4);
        point.put(3, 6);
    }

    public static void getChip1(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "12");
        select_chip.put(1, "1");
        select_chip.put(2, "=");
        select_chip.put(3, "2");
        select_chip.put(4, "/");
        select_chip.put(5, "4");
        select_chip.put(6, "*");
        select_chip.put(7, "4");
    }

    public static void getChip2(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "-");
        select_chip.put(1, "=");
        select_chip.put(2, "12");
        select_chip.put(3, "16");
        select_chip.put(4, "18");
        select_chip.put(5, "-");
        select_chip.put(6, "/");
        select_chip.put(7, "3");
    }

    public static void getChip3(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "20");
        select_chip.put(1, "=");
        select_chip.put(2, "13");
        select_chip.put(3, "-");
        select_chip.put(4, "1");
        select_chip.put(5, "6");
        select_chip.put(6, "+");
        select_chip.put(7, "9");
    }

    public static void getChip4(HashMap<Integer, String> select_chip) {
        select_chip.put(0, "19");
        select_chip.put(1, "=");
        select_chip.put(2, "17");
        select_chip.put(3, "9");
        select_chip.put(4, "1");
        select_chip.put(5, "-");
        select_chip.put(6, "+");
        select_chip.put(7, "1");
    }
}
