package com.example.a_math;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        ImageView map1 = findViewById(R.id.Map1);
        map1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectActivity.this,MainActivity.class);
                i.putExtra("map" , 1);
                startActivity(i);
            }
        });
        ImageView map2 = findViewById(R.id.Map2);
        map2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectActivity.this,MainActivity.class);
                i.putExtra("map" , 2);
                startActivity(i);
            }
        });
        ImageView map3 = findViewById(R.id.Map3);
        map3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectActivity.this,MainActivity.class);
                i.putExtra("map" , 3);
                startActivity(i);
            }
        });
        ImageView map4 = findViewById(R.id.Map4);
        map4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectActivity.this,MainActivity.class);
                i.putExtra("map" , 4);
                startActivity(i);
            }
        });
        ImageView map5 = findViewById(R.id.Map5);
        map5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectActivity.this,MainActivity.class);
                i.putExtra("map" , 5);
                startActivity(i);
            }
        });
        ImageView map6 = findViewById(R.id.Map6);
        map6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectActivity.this,MainActivity.class);
                i.putExtra("map" , 6);
                startActivity(i);
            }
        });
        ImageView map7 = findViewById(R.id.Map7);
        map7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectActivity.this,MainActivity.class);
                i.putExtra("map" , 7);
                startActivity(i);
            }
        });
        ImageView map8 = findViewById(R.id.Map8);
        map8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectActivity.this,MainActivity.class);
                i.putExtra("map" , 8);
                startActivity(i);
            }
        });
        ImageView map9 = findViewById(R.id.Map9);
        map9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectActivity.this,MainActivity.class);
                i.putExtra("map" , 9);
                startActivity(i);
            }
        });
        ImageView map10 = findViewById(R.id.Map10);
        map10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SelectActivity.this,MainActivity.class);
                i.putExtra("map" , 10);
                startActivity(i);
            }
        });
    }
}