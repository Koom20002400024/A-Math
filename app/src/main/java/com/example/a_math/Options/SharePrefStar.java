package com.example.a_math.Options;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePrefStar {

    private final SharedPreferences sharedPreferencesMap;

    public SharePrefStar(Context context) {
        sharedPreferencesMap = context.getSharedPreferences("STAR",Context.MODE_PRIVATE);
    }

    public void setStar(String allStar) {
        SharedPreferences.Editor editor = sharedPreferencesMap.edit();
        editor.putString("allStar", allStar);
        editor.apply();
    }

    public String loadStar() {
        return sharedPreferencesMap.getString("allStar", "");
    }
}
