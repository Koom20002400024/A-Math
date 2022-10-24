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
import android.widget.Toast;

import com.example.a_math.Options.SharePrefMap;
import com.example.a_math.Options.SharePrefName;
import com.example.a_math.Options.SharePrefStar;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        ImageView map1 = findViewById(R.id.Map1);
        TextView star_count = findViewById(R.id.star_count);

        SharePrefName sharePrefName = new SharePrefName(SelectActivity.this);

        TextView name = findViewById(R.id.name);
        name.setText(sharePrefName.loadName());

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
        int resourceStarId = res.getIdentifier("star_mapcl", "drawable", getPackageName() );
        @SuppressLint("UseCompatLoadingForDrawables") Drawable drawableStar = res.getDrawable(resourceStarId);

        int resourceId = res.getIdentifier("everplay", "drawable", getPackageName() );
        @SuppressLint("UseCompatLoadingForDrawables") Drawable drawable = res.getDrawable(resourceId);

        for (String score: mapList) {
            if (score.contains(":")) {
                int currentStar = Integer.parseInt(score.split(":")[0]);

                ImageView star1 = (ImageView)findViewById(getResources().getIdentifier("star"+map+"_1", "id", getPackageName()));
                ImageView star2 = (ImageView)findViewById(getResources().getIdentifier("star"+map+"_2", "id", getPackageName()));
                ImageView star3 = (ImageView)findViewById(getResources().getIdentifier("star"+map+"_3", "id", getPackageName()));

                ImageView play = (ImageView)findViewById(getResources().getIdentifier("Map"+map, "id", getPackageName()));
                play.setImageDrawable(drawable);

                if (currentStar >= 1) {
                    star1.setImageDrawable(drawableStar);
                }
                if (currentStar >= 2) {
                    star2.setImageDrawable(drawableStar);
                }
                if (currentStar >= 3) {
                    star3.setImageDrawable(drawableStar);
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
                } else {
                    Toast.makeText(SelectActivity.this, "Must pass the previous Map", Toast.LENGTH_LONG).show();
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
                } else {
                    Toast.makeText(SelectActivity.this, "Must pass the previous Map", Toast.LENGTH_LONG).show();
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
                } else {
                    Toast.makeText(SelectActivity.this, "Must pass the previous Map", Toast.LENGTH_LONG).show();
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
                } else {
                    Toast.makeText(SelectActivity.this, "Must pass the previous Map", Toast.LENGTH_LONG).show();
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
                } else {
                    Toast.makeText(SelectActivity.this, "Must pass the previous Map", Toast.LENGTH_LONG).show();
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
                } else {
                    Toast.makeText(SelectActivity.this, "Must pass the previous Map", Toast.LENGTH_LONG).show();
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
                } else {
                    Toast.makeText(SelectActivity.this, "Must pass the previous Map", Toast.LENGTH_LONG).show();
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
                } else {
                    Toast.makeText(SelectActivity.this, "Must pass the previous Map", Toast.LENGTH_LONG).show();
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
                } else {
                    Toast.makeText(SelectActivity.this, "Must pass the previous Map", Toast.LENGTH_LONG).show();
                }
            }
        });
        ImageView map11 = findViewById(R.id.Map11);
        map11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sharePref.loadMap().equals("") && mapPlay+1 >= 11) {
                    Intent i = new Intent(SelectActivity.this, GameActivity.class);
                    i.putExtra("map", 11);
                    startActivity(i);
                } else {
                    Toast.makeText(SelectActivity.this, "Must pass the previous Map", Toast.LENGTH_LONG).show();
                }
            }
        });
        ImageView map12 = findViewById(R.id.Map12);
        map12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sharePref.loadMap().equals("") && mapPlay+1 >= 12) {
                    Intent i = new Intent(SelectActivity.this, GameActivity.class);
                    i.putExtra("map", 12);
                    startActivity(i);
                } else {
                    Toast.makeText(SelectActivity.this, "Must pass the previous Map", Toast.LENGTH_LONG).show();
                }
            }
        });
        ImageView map13 = findViewById(R.id.Map13);
        map13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sharePref.loadMap().equals("") && mapPlay+1 >= 13) {
                    Intent i = new Intent(SelectActivity.this, GameActivity.class);
                    i.putExtra("map", 13);
                    startActivity(i);
                } else {
                    Toast.makeText(SelectActivity.this, "Must pass the previous Map", Toast.LENGTH_LONG).show();
                }
            }
        });
        ImageView map14 = findViewById(R.id.Map14);
        map14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sharePref.loadMap().equals("") && mapPlay+1 >= 14) {
                    Intent i = new Intent(SelectActivity.this, GameActivity.class);
                    i.putExtra("map", 14);
                    startActivity(i);
                } else {
                    Toast.makeText(SelectActivity.this, "Must pass the previous Map", Toast.LENGTH_LONG).show();
                }
            }
        });
        ImageView map15 = findViewById(R.id.Map15);
        map15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sharePref.loadMap().equals("") && mapPlay+1 >= 15) {
                    Intent i = new Intent(SelectActivity.this, GameActivity.class);
                    i.putExtra("map", 15);
                    startActivity(i);
                } else {
                    Toast.makeText(SelectActivity.this, "Must pass the previous Map", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}