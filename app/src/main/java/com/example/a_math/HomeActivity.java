package com.example.a_math;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a_math.Options.SharePrefMap;
import com.example.a_math.Options.SharePrefName;
import com.example.a_math.Options.SharePrefStar;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageView start = findViewById(R.id.startbtn);
        TextView star_count = findViewById(R.id.star_count_home);

        SharePrefStar sharePrefStar = new SharePrefStar(HomeActivity.this);
        SharePrefMap sharePref = new SharePrefMap(HomeActivity.this);
        SharePrefName sharePrefName = new SharePrefName(HomeActivity.this);

//        sharePrefName.setName("");
        if (sharePrefName.loadName().equals("")) {
            showDialogName(sharePrefName);
        } else {
            TextView name = findViewById(R.id.name);
            name.setText(sharePrefName.loadName());
        }

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

    private void showDialogName(SharePrefName sharePrefName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Input Name");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String m_Text = input.getText().toString();
                if (!m_Text.equals("")) {
                    sharePrefName.setName(m_Text);

                    TextView name = findViewById(R.id.name);
                    name.setText(m_Text);
                }
            }
        });
        builder.show();
    }
}