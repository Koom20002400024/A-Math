package com.example.a_math;

import static com.example.a_math.Game.Engine.Game.start;

import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.a_math.Options.SharePrefStar;

import java.util.HashMap;

public class GameActivity extends AppCompatActivity {

    static HashMap<String, Integer> idMap = new HashMap<>();

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView home_in_game = findViewById(R.id.home_in_game);

        int map = getIntent().getIntExtra("map",1);
        start(GameActivity.this, map);

        home_in_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameActivity.this,HomeActivity.class));
                finish();
            }
        });
    }
}