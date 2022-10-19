package com.example.a_math.Options;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePrefScore {

    private SharedPreferences sharedPreferencesScore;

    public SharePrefScore(Context context) {
        sharedPreferencesScore = context.getSharedPreferences("SCORE",Context.MODE_PRIVATE);
    }

    public void setScore(long time) {
        SharedPreferences.Editor editor = sharedPreferencesScore.edit();
        editor.putLong("score", time);
        editor.apply();
    }

    public long loadScore() { return sharedPreferencesScore.getLong("score", 0); }
}
