package com.example.a_math;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a_math.Options.SharePrefMap;
import com.example.a_math.Options.SharePrefStar;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        ImageView map1 = findViewById(R.id.Map1);
        TextView star_count = findViewById(R.id.star_count);

        SharePrefMap sharePref = new SharePrefMap(SelectActivity.this);
        SharePrefStar sharePrefStar = new SharePrefStar(SelectActivity.this);
        if (!sharePrefStar.loadStar().equals("")) {
            star_count.setText(sharePrefStar.loadStar().split(":")[0]);
        }

        // "10:1,1:10,2:50"
        // mapPlay = 3
        int mapPlay = sharePref.loadMap().split(",").length;

        String[] mapList = sharePref.loadMap().split(",");
        int map = 1;
        Resources res = getResources();
        int resourceId = res.getIdentifier("star_mapcl", "drawable", getPackageName() );
        @SuppressLint("UseCompatLoadingForDrawables") Drawable drawable = res.getDrawable( resourceId );

        for (String score: mapList) {
            if (score.contains(":")) {
                int currentStar = Integer.parseInt(score.split(":")[0]);

                ImageView star1 = (ImageView)findViewById(getResources().getIdentifier("star"+map+"_1", "id", getPackageName()));
                ImageView star2 = (ImageView)findViewById(getResources().getIdentifier("star"+map+"_2", "id", getPackageName()));
                ImageView star3 = (ImageView)findViewById(getResources().getIdentifier("star"+map+"_3", "id", getPackageName()));

                if (currentStar >= 1) {
                    star1.setImageDrawable(drawable);
                }
                if (currentStar >= 2) {
                    star2.setImageDrawable(drawable);
                }
                if (currentStar >= 3) {
                    star3.setImageDrawable(drawable);
                }

                map++;
            }
        }
        if (!sharePrefStar.loadStar().equals("")) {
            star_count.setText(sharePrefStar.loadStar().split(":")[0]);
        }

        map1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectActivity.this, GameActivity.class);
                i.putExtra("map" , 1);
                startActivity(i);
            }
        });
        ImageView map2 = findViewById(R.id.Map2);
        map2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sharePref.loadMap().equals("") && mapPlay+1 >= 2) {
                    Intent i = new Intent(SelectActivity.this, GameActivity.class);
                    i.putExtra("map" , 2);
                    startActivity(i);
                }
            }
        });
        ImageView map3 = findViewById(R.id.Map3);
        map3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sharePref.loadMap().equals("") && mapPlay+1 >= 3) {
                    Intent i = new Intent(SelectActivity.this, GameActivity.class);
                    i.putExtra("map", 3);
                    startActivity(i);
                }
            }
        });
        ImageView map4 = findViewById(R.id.Map4);
        map4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sharePref.loadMap().equals("") && mapPlay+1 >= 4) {
                    Intent i = new Intent(SelectActivity.this, GameActivity.class);
                    i.putExtra("map", 4);
                    startActivity(i);
                }
            }
        });
        ImageView map5 = findViewById(R.id.Map5);
        map5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sharePref.loadMap().equals("") && mapPlay+1 >= 5) {
                    Intent i = new Intent(SelectActivity.this, GameActivity.class);
                    i.putExtra("map", 5);
                    startActivity(i);
                }
            }
        });
        ImageView map6 = findViewById(R.id.Map6);
        map6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sharePref.loadMap().equals("") && mapPlay+1 >= 6) {
                    Intent i = new Intent(SelectActivity.this, GameActivity.class);
                    i.putExtra("map", 6);
                    startActivity(i);
                }
            }
        });
        ImageView map7 = findViewById(R.id.Map7);
        map7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sharePref.loadMap().equals("") && mapPlay+1 >= 7) {
                    Intent i = new Intent(SelectActivity.this, GameActivity.class);
                    i.putExtra("map", 7);
                    startActivity(i);
                }
            }
        });
        ImageView map8 = findViewById(R.id.Map8);
        map8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sharePref.loadMap().equals("") && mapPlay+1 >= 8) {
                    Intent i = new Intent(SelectActivity.this, GameActivity.class);
                    i.putExtra("map", 8);
                    startActivity(i);
                }
            }
        });
        ImageView map9 = findViewById(R.id.Map9);
        map9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sharePref.loadMap().equals("") && mapPlay+1 >= 9) {
                    Intent i = new Intent(SelectActivity.this, GameActivity.class);
                    i.putExtra("map", 9);
                    startActivity(i);
                }
            }
        });
        ImageView map10 = findViewById(R.id.Map10);
        map10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sharePref.loadMap().equals("") && mapPlay+1 >= 10) {
                    Intent i = new Intent(SelectActivity.this, GameActivity.class);
                    i.putExtra("map", 10);
                    startActivity(i);
                }
            }
        });
    }
}