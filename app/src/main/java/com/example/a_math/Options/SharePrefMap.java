package com.example.a_math.Options;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.a_math.Models.Mapper;

import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;

public class SharePrefMap {

    private final SharedPreferences sharedPreferencesMap;

    public SharePrefMap(Context context) {
        sharedPreferencesMap = context.getSharedPreferences("MAP",Context.MODE_PRIVATE);
    }

    public void setMap(String mapper) {
        SharedPreferences.Editor editor = sharedPreferencesMap.edit();
        editor.putString("mapData", mapper);
        editor.apply();
    }

    public String loadMap() {
        return sharedPreferencesMap.getString("mapData", "");
    }
}
