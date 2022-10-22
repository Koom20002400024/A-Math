package com.example.a_math.Game.Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TablePoint {

    public static String TablePoint(int x, int y) {
        HashMap<Integer, List<String>> table_map = new HashMap<>();
        table_map.put(0, Arrays.asList("r", null, null,  "o", null, null, null,  "r", null, null, null,  "o", null, null,  "r"));
        table_map.put(1, Arrays.asList(null,  "y", null, null, null,  "b", null, null, null,  "b", null, null, null,  "y", null));
        table_map.put(2, Arrays.asList(null, null,  "y", null, null, null,  "o", null,  "o", null, null, null,  "y", null, null));
        table_map.put(3, Arrays.asList("o", null, null,  "y", null, null, null,  "o", null, null, null,  "y", null, null,  "o"));
        table_map.put(4, Arrays.asList(null, null, null, null,  "b", null, null, null, null, null,  "b", null, null, null, null));
        table_map.put(5, Arrays.asList(null,  "b", null, null, null,  "b", null, null, null,  "b", null, null, null,  "b", null));
        table_map.put(6, Arrays.asList(null, null,  "o", null, null, null,  "o", null,  "o", null, null, null,  "o", null, null));
        table_map.put(7, Arrays.asList("r", null, null,  "o", null, null, null, "s" , null, null, null,  "o", null, null,  "r"));
        table_map.put(8, Arrays.asList(null, null,  "o", null, null, null,  "o", null,  "o", null, null, null,  "o", null, null));
        table_map.put(9, Arrays.asList(null,  "b", null, null, null,  "b", null, null, null,  "b", null, null, null,  "b", null));
        table_map.put(10, Arrays.asList(null, null, null, null,  "b", null, null, null, null, null,  "b", null, null, null, null));
        table_map.put(11, Arrays.asList("o", null, null,  "y", null, null, null,  "o", null, null, null,  "y", null, null,  "o"));
        table_map.put(12, Arrays.asList(null, null,  "y", null, null, null,  "o", null,  "o", null, null, null,  "y", null, null));
        table_map.put(13, Arrays.asList(null,  "y", null, null, null,  "b", null, null, null,  "b", null, null, null,  "y", null));
        table_map.put(14, Arrays.asList("r", null, null,  "o", null, null, null,  "r", null, null, null,  "o", null, null,  "r"));

        return table_map.get(y).get(x);
    }
}
