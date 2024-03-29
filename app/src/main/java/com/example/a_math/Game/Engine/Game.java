package com.example.a_math.Game.Engine;

import static com.example.a_math.Game.Engine.Point.startPoint;
import static com.example.a_math.Game.Engine.Validate.find_and_count;
import static com.example.a_math.Game.Engine.initMotion.initMotionObj;
import static com.example.a_math.Game.Engine.initObj.initAllObj;

import android.app.Activity;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

public class Game {

    static HashMap<String, Integer> idMap = new HashMap<>();

    @RequiresApi(api = Build.VERSION_CODES.R)
    public static void start(Activity activity, int map) {

        HashMap<Integer, List<String>> table_map = new HashMap<>();
        HashMap<Integer, String> select_chip = new HashMap<>();
        HashMap<Integer, Integer> point = new HashMap<>();

        int initNewChip = 4;

        try {
            Class<?> cls = Class.forName("com.example.a_math.Game.Map.Map"+map);
            Constructor<?> constructor = cls.getConstructor(HashMap.class, HashMap.class, HashMap.class);

            constructor.newInstance(table_map, select_chip, point);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        initAllObj(activity, idMap, table_map, select_chip);
        HashMap<String, Object> dict = (HashMap<String, Object>) find_and_count(activity, idMap);
        int pointOrigin = startPoint(activity, idMap, dict);
        System.out.println("Old: "+dict);
        initMotionObj(activity, idMap, map, pointOrigin, point, initNewChip, dict);
    }
}
