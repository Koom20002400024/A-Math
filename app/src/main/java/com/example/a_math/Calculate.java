package com.example.a_math;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Calculate {

    static MainActivity mainActivity = new MainActivity();

    public static HashMap<String,ArrayList<Integer>> find_eq(Activity activity){
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (mainActivity.getIV(j, i).equals("=")){
                    x.add(j);
                    y.add(i);
                }
            }
        }
        HashMap <String, ArrayList<Integer>> hashMap = new HashMap<>();
        hashMap.put("x",x);
        hashMap.put("y",y);
        return hashMap;
    }

    public static ArrayList<Integer> cal_c(int x, int y, String direct, String coordinate, int min, int max) {
        if (coordinate.equals("x")) {
            if (direct.equals("up")) {
                return loop_cal("y", x, y, min, -1);
            } else if (direct.equals("down")) {
                return loop_cal( "y", x, y, max, 1);
            }
        }
        else if (coordinate.equals("y")) {
            if (direct.equals("left")) {
                return loop_cal( "x", y, x, min, -1);
            }
            else if (direct.equals("right")) {
                return loop_cal("x", y, x, max, 1);
            }
        }
        return null;
    }

    public static ArrayList<Integer> loop_cal (String coordinate, int coo_n, int start, int end, int increment){
        ArrayList<Integer> save_result = new ArrayList<>();
        start += increment ;
        int sum = 0;
        boolean cal = false;
        String type = "";
        String result = "";
        while (start != end+increment) {
            if (coordinate.equals("x")){
//                result = activity.getIV(coo_n, start);
            }
            else if (coordinate.equals("y")) {
//                result = activity.getIV(start, coo_n);
            }

            if (result == null) {
                if (cal) {
                    save_result.add(sum);
                    break;
                }
            }
            else if (result.equals("=")) {
                save_result.add(sum);
                sum = 0;
            }
            else if (start == end) {
                save_result.add(sum + Integer.parseInt(result));
            }
            else if (isNumeric(result)) {
                sum = operator(type, sum, Integer.parseInt(result));
            }
            else{
                type = result;
            }
            cal = true;
            start += increment;
        }
        return save_result;
    }
    public static boolean isNumeric(String string) {
        int intValue;

//        System.out.println(String.format("Parsing string: "%s"", string));

        if(string == null || string.equals("")) {
//            System.out.println("String cannot be parsed, it is null or empty.");
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
//            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }

    public static int operator(String type, int sum, int result){
        if (type.equals("*")) {
            sum *= result;
        }
        else if (type.equals("/")) {
            sum /= result;
        }
        else if (type.equals("+") || type.equals("None")) {
            sum += result;
        }
        else if (type.equals("-")) {
            sum -= result;
        }

        return sum;
    }

    public static boolean check_eq(ArrayList<Integer> list1, ArrayList<Integer> list2){
        list1.addAll(list2);
        Set<Integer> set = new HashSet<>(list1);
        if (list1.size()<= 1) {
            return false;
        }
        else if (set.size() != 1) {
            return false;
        }
        else{
            return true;
        }
    }


}
