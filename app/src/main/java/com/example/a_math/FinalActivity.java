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
import com.example.a_math.Options.SharePrefName;
import com.example.a_math.Options.SharePrefStar;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        SharePrefName sharePrefName = new SharePrefName(FinalActivity.this);

        TextView name = findViewById(R.id.name);
        name.setText(sharePrefName.loadName());

        int map = getIntent().getIntExtra("map",1);
        int starNew = getIntent().getIntExtra("starNew",0);

        ImageView next = findViewById(R.id.next);
        ImageView home = findViewById(R.id.home);

        ImageView star_final_1 = findViewById(R.id.star_final1);
        ImageView star_final_2 = findViewById(R.id.star_final2);
        ImageView star_final_3 = findViewById(R.id.star_final3);

        Resources res = getResources();
        int resourceId = res.getIdentifier("star_mapcl", "drawable", getPackageName() );
        @SuppressLint("UseCompatLoadingForDrawables") Drawable drawable = res.getDrawable( resourceId );
        if (starNew >= 1) {
            star_final_1.setImageDrawable(drawable);
        }
        if (starNew >= 2) {
            star_final_2.setImageDrawable(drawable);
        }
        if (starNew == 3) {
            star_final_3.setImageDrawable(drawable);
        }

        TextView star_count = findViewById(R.id.star_count);

        SharePrefStar sharePrefStar = new SharePrefStar(FinalActivity.this);
        star_count.setText(sharePrefStar.loadStar().split(":")[0]);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FinalActivity.this, GameActivity.class);
                i.putExtra("map" , map);
                startActivity(i);
                finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FinalActivity.this,HomeActivity.class));
                finish();
            }
        });
    }
}