package com.example.a_math.Options;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePrefName {

    private final SharedPreferences sharedPreferencesMap;

    public SharePrefName(Context context) {
        sharedPreferencesMap = context.getSharedPreferences("NAME",Context.MODE_PRIVATE);
    }

    public void setName(String allStar) {
        SharedPreferences.Editor editor = sharedPreferencesMap.edit();
        editor.putString("name", allStar);
        editor.apply();
    }

    public String loadName() {
        return sharedPreferencesMap.getString("name", "");
    }
}
