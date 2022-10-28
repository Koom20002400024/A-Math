package com.example.a_math.Game.Engine;

import static com.example.a_math.Game.Engine.Validate.find_and_count;
import static com.example.a_math.Game.UI.Chip.getIVTag;
import static com.example.a_math.Game.UI.Chip.getValueIV;

import android.app.Activity;
import android.widget.ImageView;

import com.example.a_math.Game.Map.TablePoint;
import com.example.a_math.Models.PointGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Point {

    static List<String> list_op_point = new ArrayList<>();
    static List<String> list_op_state_point = new ArrayList<>();

    static int getPointGame(String value) {
        if (value == null) {
            return 1;
        } else if (value.equals("0")) {
        return 1;
        } else if (value.equals("1")) {
        return 1;
        } else if (value.equals("2")) {
        return 1;
        } else if (value.equals("3")) {
        return 1;
        } else if (value.equals("4")) {
        return 2;
        } else if (value.equals("5")) {
        return 2;
        } else if (value.equals("6")) {
        return 2;
        } else if (value.equals("7")) {
        return 2;
        } else if (value.equals("8")) {
        return 2;
        } else if (value.equals("9")) {
        return 2;
        } else if (value.equals("10")) {
        return 3;
        } else if (value.equals("11")) {
        return 4;
        } else if (value.equals("12")) {
        return 3;
        } else if (value.equals("13")) {
        return 6;
        } else if (value.equals("14")) {
        return 4;
        } else if (value.equals("15")) {
        return 4;
        } else if (value.equals("16")) {
        return 4;
        } else if (value.equals("17")) {
        return 6;
        } else if (value.equals("18")) {
        return 4;
        } else if (value.equals("19")) {
        return 7;
        } else if (value.equals("20")) {
        return 5;
        } else if (value.equals("=")) {
        return 1;
        } else if (value.equals("+")) {
        return 2;
        } else if (value.equals("-")) {
        return 2;
        } else if (value.equals("+/-")) {
        return 1;
        } else if (value.equals("*//")) {
        return 1;
        } else if (value.equals("*")) {
        return 2;
        } else if (value.equals("/")) {
        return 2;
        } else if (value.equals("blank")) {
        return 0;
        }else if (value.contains("kl")) {
        return 1;
        } else if (value.equals("y") || value.equals("o")) {
        return 2;
        } else if (value.equals("r") || value.equals("b") || value.equals("s")) {
        return 3;
        } else if (value.equals("null")) {
        return 1;
        } else {
        return 0;
        }
    }

    private static int travel(Activity activity, HashMap<String, Integer> idMap, int x, int y) {
        int point = 0;
        list_op_point.add(x + "_" + y);
        List<PointGame> current = direction(activity, idMap, x, y, "current", 0, 14);

        if (symmetric_coordinate(activity, idMap, x, y, "up&down") && !travel_direct(activity, idMap, x, y, "up&down", 0, 14))
        {
//            "UP&DOWN"
            List<PointGame> up = direction(activity, idMap, x, y, "up", 0, 14);
            List<PointGame> down = direction(activity, idMap, x, y, "down", 0, 14);
            up.addAll(current);
            up.addAll(down);
            point += calculate(up);
        }

        if (symmetric_coordinate(activity, idMap, x, y, "left&right") && !travel_direct(activity, idMap, x, y, "left&right", 0, 14))
        {
//            "LEFT&RIGHT"
            List<PointGame> left = direction(activity, idMap, x, y, "left", 0, 14);
            List<PointGame> right = direction(activity, idMap, x, y, "right", 0, 14);
            left.addAll(current);
            left.addAll(right);
            point += calculate(left);
        }

        return point;
    }

    private static boolean travel_direct(Activity activity, HashMap<String, Integer> idMap, int x, int y, String type, int min, int max) {
        if (type.equals("up&down") && (engine_travel(activity, idMap, "up", x, y, min, -1) || engine_travel(activity, idMap, "down", x, y, max, 1))) {
            return true;
        } else if (type.equals("left&right") && (engine_travel(activity, idMap, "left", y, x, min, -1) || engine_travel(activity, idMap, "right", y, x, max, 1))) {
            return true;
        }
        return false;
    }

    private static boolean engine_travel(Activity activity, HashMap<String, Integer> idMap, String direct, int con, int start, int end, int increment) {
        start += increment;
        String value = null;
        String cur_index = null;
        while (start != end + increment) {
            if (direct.equals("up") || direct.equals("down")) { //ขยับแกน y
                value = getValueIV(activity, idMap, con, start);
                cur_index = con+"_"+start;
            }
            else if (direct.equals("left") || direct.equals("right")) { //ขยับแกน x
                value = getValueIV(activity, idMap, start, con);
                cur_index = start+"_"+con;
            }
            if (value == null) {
                break;
            }
            if (value.equals("=")) {
                if (list_op_point.contains(cur_index)) {
                    return true;
                }
                break;
            }
            start +=increment;
        }

        return false;
    }

    private static boolean symmetric_coordinate(Activity activity, HashMap<String, Integer> idMap, int x, int y, String type) {
        if (type.equals("up&down") && !((y - 1 < 0 || getValueIV(activity, idMap, x, y-1) == null)
        && (y + 1 > 14 || getValueIV(activity, idMap, x, y+1) == null))) {
            return true;
        }
        if (type.equals("left&right") && !((x - 1 < 0 || getValueIV(activity, idMap, x-1, y) == null)
        && (x + 1 > 14 || getValueIV(activity, idMap, x+1, y) == null))){
            return true;
        }
        return false;
    }

    private static boolean around_coordinate(Activity activity, HashMap<String, Integer> idMap, int x, int y){
        return (x - 1 < 0 || getValueIV(activity, idMap, x-1, y) == null ) && (x+1 > 14 || getValueIV(activity, idMap, x+1, y) == null) || (y-1 < 0 || getValueIV(activity, idMap, x, y-1) == null) && (y+1 > 14 || getValueIV(activity, idMap, x, y+1) == null);
    }

    static List<PointGame> direction(Activity activity, HashMap<String, Integer> idMap, int x, int y, String direct, int min, int max){
        if (direct.equals("current")) {
            return engine(activity, idMap, direct, x, y, max + 1, 0); }
        else if (direct.equals("up")) {
            return engine(activity, idMap, direct, x, y, min, -1);
        }
        else if (direct.equals("down")){
            return engine(activity, idMap,direct, x, y, max, 1);
        }
        if (direct.equals("left")){
            return engine(activity, idMap,direct, y, x, min, -1);
        }
        else if (direct.equals("right")){
            return engine(activity, idMap,direct, y, x, max, 1);
        }
        return null;
    }

    static List<PointGame> engine(Activity activity, HashMap<String, Integer> idMap, String direct, int con, int start, int end, int increment){
        List<PointGame> save_result = new ArrayList<>();
        start += increment;
        PointGame result = null;
        String value = null;
        String cur_index = null;
        boolean around = false;
        while (start != end + increment){
            if (direct.equals("up") || direct.equals("down") || direct.equals("current")) {
                around = around_coordinate(activity, idMap, con, start);
                value = getValueIV(activity, idMap, con, start);
                cur_index = con+"_"+start;
                ImageView iv = activity.findViewById(idMap.get("x" + con + "y" + start));
                result = new PointGame(
                        value,
                        getPointGame(value),
                        "x"+con+"y"+start,
                        (Boolean) getIVTag(iv, "locked") ? null : TablePoint.TablePoint(con, start)
                );
            }
            else if (direct.equals("left") || direct.equals("right")) {
                around = around_coordinate(activity, idMap, start, con);
                value = getValueIV(activity, idMap, start, con);
                cur_index = start+"_"+con;
                ImageView iv = activity.findViewById(idMap.get("x" + start + "y" + con));
                result = new PointGame(
                        value,
                        getPointGame(value),
                        "x"+start+"y"+con,
                        (Boolean) getIVTag(iv, "locked") ? null : TablePoint.TablePoint(start, con)
                );
            }

            if (direct.equals("current")) {
                save_result.add(result);
                break;
            }

            if (value == null) {
                break;
            }

            if (value.equals("=") && !around && !list_op_point.contains(cur_index)) {
                list_op_point.add(cur_index);
            }

            save_result.add(result);
            start += increment;
        }
        if (increment == -1){
            Collections.reverse(save_result);
        }
        return save_result;
    }

    private static int calculate(List<PointGame> list) {
        int result = 0;
        int extra = 1;

        for (PointGame item : list) {
            int point = item.getPoint();
            String index = item.getIndex();
            String type = item.getType();

            System.out.println(item.getValue()+" "+point+" "+index+" "+type);

            if (!list_op_state_point.contains(index) && !Arrays.asList("y", "r").contains(type)) {
                result += point * getPointGame(type);
                if (Arrays.asList("o", "b", "s").contains(type)) {
                    list_op_state_point.add(index);
                }
            } else {
                result += point;
            }

            if (!list_op_state_point.contains(index) && Arrays.asList("y", "r").contains(type)) {
                extra *= getPointGame(type);
                list_op_state_point.add(index);
            }
        }

        return result * extra;
    }

    static int startPoint(Activity activity, HashMap<String, Integer> idMap, HashMap<String, Object> dict) {
        int point = 0;
        list_op_point = new ArrayList<>();
        list_op_state_point = new ArrayList<>();

        List<Integer> x_list = (List<Integer>) dict.get("x");
        List<Integer> y_list = (List<Integer>) dict.get("y");
        List<String> o_list = (List<String>) dict.get("operation");
        int count = (int) dict.get("count");
        for (int i = 0; i < count; i++) {
            int x = x_list.get(i);
            int y = y_list.get(i);
            String o = o_list.get(i);
            String index = x + "_" + y;
            if (o.equals("=") && !list_op_point.contains(index)) {
                point += travel(activity, idMap, x, y);
            }
        }

        return point;
    }
}
