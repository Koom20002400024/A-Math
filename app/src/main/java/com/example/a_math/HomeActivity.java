package com.example.a_math;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a_math.Options.SharePrefMap;
import com.example.a_math.Options.SharePrefStar;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button start = findViewById(R.id.startbtn);
        TextView star_count = findViewById(R.id.star_count_home);

        SharePrefStar sharePrefStar = new SharePrefStar(HomeActivity.this);
        SharePrefMap sharePref = new SharePrefMap(HomeActivity.this);

//        sharePref.setMap("");
//        sharePrefStar.setStar("");
        if (!sharePrefStar.loadStar().equals("")) {
            star_count.setText(sharePrefStar.loadStar().split(":")[0]);
        }

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,SelectActivity.class));
            }
        });

    }
}