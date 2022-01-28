package com.example.a_math;

import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Calculate {

    static ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

    public static Double calculate(ArrayList<String> equation, int type_calculate) {
        if (type_calculate == -1) {
            Collections.reverse(equation);
        }
        if (!isNumeric(equation.get(0)) && !equation.get(0).equals("-")) { // ตัวแรกของสมการเป็น - หรือเป็นตัวเลขเท่านั้น
            return null;
        }
        String equationString = TextUtils.join(" ", equation);
        Double eq;
        Log.e("555", "Equation List: "+equation+", Equation String: "+equationString);
        try {
            Log.e("555", "Equation: "+equationString+", Result: "+engine.eval(equationString));
            eq = (Double) engine.eval(equationString);
        } catch (Exception e) {
            Log.e("555", "ScriptEngine error: " + e.getMessage());
            return null;
        }
        return eq;
    }

    public static Boolean check_eq(ArrayList<Double> list1, ArrayList<Double> list2){

        ArrayList<Double> list_result = new ArrayList<>();
        list_result.addAll(list1);
        list_result.addAll(list2);
        if (list_result.contains(null)) {
            return null;
        } else if (list1.size() == 0 || list2.size() == 0) {
            return false;
        }
        Set<Double> set = new HashSet<>(list_result);
        if (list_result.size()<= 1) {
            return false;
        }
        else if (set.size() != 1) {
            return false;
        }
        else{
            return true;
        }
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


}