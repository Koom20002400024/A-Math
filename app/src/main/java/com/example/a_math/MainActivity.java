package com.example.a_math;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int x_num = 15;
    int y_num = 15;

    int select_num = 8;

    // r = tripple_eq
    // y = doubble_eq
    // o = doubble_p
    // b = tripple_p
    // s = star
    String[] row_1 = new String[]{"r_0", "o_3", "r_7", "o_11", "r_14"};
    String[] row_2 = new String[]{"y_1", "b_5", "b_9", "y_13"};
    String[] row_3 = new String[]{"y_2", "o_6", "o_8", "y_12"};
    String[] row_4 = new String[]{"o_0", "y_3", "o_7", "y_11", "o_14"};
    String[] row_5 = new String[]{"b_4", "b_10"};
    String[] row_6 = new String[]{"b_1", "b_5", "b_9", "b_13"};
    String[] row_7 = new String[]{"o_2", "o_6", "o_8", "o_12"};
    String[] row_8 = new String[]{"r_0", "o_3", "s_7", "o_11", "r_14"};
    String[] row_9 = new String[]{"o_2", "o_6", "o_8", "o_12"};
    String[] row_10 = new String[]{"b_1", "b_5", "b_9", "b_13"};
    String[] row_11 = new String[]{"b_4", "b_10"};
    String[] row_12 = new String[]{"o_0", "y_3", "o_7", "y_11", "o_14"};
    String[] row_13 = new String[]{"y_2", "o_6", "o_8", "y_12"};
    String[] row_14 = new String[]{"y_1", "b_5", "b_9", "y_13"};
    String[] row_15 = new String[]{"r_0", "o_3", "r_7", "o_11", "r_14"};

    String[] types = new String[]{"0", "1", "2", "3", "4","5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "+" ,"+/-", "*", "/" ,"*//", "=" ,"blank"};


    HashMap<String, Integer> idMap = new HashMap<String, Integer>();

    int save_select = -1;

    String save_state = "";

    boolean selected = false;


    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout table = findViewById(R.id.table);
        ConstraintLayout select = findViewById(R.id.select);
        ConstraintLayout selectAfter = findViewById(R.id.selectAfter);
        ConstraintLayout buttonCal = findViewById(R.id.buttonCal);
        @SuppressLint("CutPasteId") View view = findViewById(R.id.table);
        @SuppressLint("CutPasteId") View view_select = findViewById(R.id.select);
        @SuppressLint("CutPasteId") View view_button = findViewById(R.id.buttonCal);

        int density = (int) getResources().getDisplayMetrics().density;

        int paddingDp = 15;
        int paddingPieceDp = 3;
        int paddingPx = paddingDp * density;
        int paddingPiecePx = paddingPieceDp * density;

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels - paddingPx * 2;
        int piece = (width - (paddingPiecePx * (x_num - 1))) / x_num;
        int height = (piece * y_num) + paddingPx + (paddingPiecePx * y_num);

        ConstraintLayout.LayoutParams layout1Params = new ConstraintLayout.LayoutParams(metrics.widthPixels, height);
        table.setLayoutParams(layout1Params);

        ConstraintLayout.LayoutParams layout2Params = new ConstraintLayout.LayoutParams(piece * 12, piece * 2);
        select.setBackground(getDrawable(R.drawable.black));
        select.setX((metrics.widthPixels - (piece * 12)) / 2F);
        select.setY(height + (50 * density));
        select.setLayoutParams(layout2Params);

        ConstraintLayout.LayoutParams layout3Params = new ConstraintLayout.LayoutParams((piece * 12) + (20 * density), (5 * density));
        selectAfter.setBackgroundColor(Color.BLACK);
        selectAfter.setX((metrics.widthPixels - ((piece * 12) + (20 * density))) / 2F);
        selectAfter.setY(height + (50 * density) + (piece * 2));
        selectAfter.setLayoutParams(layout3Params);

        Button cal = new Button(this);

        String idName = "cal";
        int generated_R_id = getRandomId();
        idMap.put(idName, generated_R_id);

        cal.setId(idMap.get(idName));
        cal.setText("SUBMIT");
        ConstraintLayout.LayoutParams layout4Params = new ConstraintLayout.LayoutParams((150 * density) ,(75 * density));
        cal.setX((metrics.widthPixels - (150 * density)) / 2F);
        cal.setY(height + (50 * density) + (piece * 2) + 70);
        cal.setLayoutParams(layout4Params);
//        buttonCal.addView(cal);
        addContentView(cal,layout4Params);

        int paddingSelectDp = 10;
        int paddingSelectPieceDp = 5;
        int paddingSelectPx = paddingSelectDp * density;
        int paddingSelectPiecePx = paddingSelectPieceDp * density;

        int width_select = (piece * 12) - paddingSelectPx * 2;
        int piece_select = (width_select - (paddingSelectPiecePx * (select_num - 1))) / select_num;


        for (int i = 0; i < select_num; i++) {

            ImageView iv = new ImageView(this);


            idName = "select" + i;
            generated_R_id = getRandomId();
            idMap.put(idName, generated_R_id);

            iv.setId(idMap.get(idName));

            if (i == 0) {
                iv.setImageDrawable(getDrawable(R.drawable.plus_delete));
                iv.setTag("+/-");
            } else if (i == 1) {
                iv.setImageDrawable(getDrawable(R.drawable.plus));
                iv.setTag("+");
            } else if (i == 2) {
                iv.setImageDrawable(getDrawable(R.drawable.delete));
                iv.setTag("-");
            } else if (i == 3) {
                iv.setImageDrawable(getDrawable(R.drawable.a1));
                iv.setTag("1");
            } else if (i == 4) {
                iv.setImageDrawable(getDrawable(R.drawable.a19));
                iv.setTag("19");
            } else if (i == 5) {
                iv.setImageDrawable(getDrawable(R.drawable.delete));
                iv.setTag("-");
            } else if (i == 6) {
                iv.setImageDrawable(getDrawable(R.drawable.a18));
                iv.setTag("18");
            } else if (i == 7) {
                iv.setImageDrawable(getDrawable(R.drawable.equal));
                iv.setTag("=");
            }


            LinearLayout.LayoutParams layoutIvParams = new LinearLayout.LayoutParams(piece_select, piece_select);
            iv.setLayoutParams(layoutIvParams);
            iv.setX((i * piece_select) + paddingSelectPx + (i * paddingSelectPiecePx));
            iv.setY(10 * density);

            select.addView(iv);
        }

        for (int i = 0; i < y_num; i++) {
            for (int j = 0; j < x_num; j++) {

                ImageView iv = new ImageView(this);

                idName = "x" + j + "y" + i;
                generated_R_id = getRandomId();
                idMap.put(idName, generated_R_id);

                iv.setId(idMap.get(idName));
                iv.setImageDrawable(getDrawable(R.drawable.board)); //default
                iv.setTag("");
                back_status(j,i,iv);


                LinearLayout.LayoutParams layoutIvParams = new LinearLayout.LayoutParams(piece, piece);
                iv.setLayoutParams(layoutIvParams);
                iv.setX((j * piece) + paddingPx + (j * paddingPiecePx));
                iv.setY((i * piece) + paddingPx + (i * paddingPiecePx));

                table.addView(iv);
            }
        }

        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();

                    int x_table = (int) (x - paddingPx) / (piece + paddingPiecePx);
                    int y_table = (int) (y - paddingPx) / (piece + paddingPiecePx);

                    ImageView iv = findViewById(idMap.get("x" + x_table + "y" + y_table));
                    if (!check_status(iv.getTag().toString()) && !iv.getTag().toString().equals("")) {
                        ImageView old_iv;
                        for (int i = 0; i < select_num; i++) {
                            old_iv = findViewById(idMap.get("select" + i));
                            if (old_iv.getTag().toString().split("_").length >= 2 && old_iv.getTag().toString().split("_")[1].equals(iv.getTag())) {
                                old_iv.setAlpha(1F);
                                old_iv.setTag(iv.getTag());
                                setStatus_old(iv.getTag().toString(), iv);
                                back_status(y_table, x_table, iv);
                                return true;
                            }


                        }

                    }
                    if (save_state.equals("")) {
                        save_state = x_table + "_" + y_table;
                        setStatus_ontuch(iv);
                        selected = true;
                    } else {
                        ImageView old_iv = findViewById(idMap.get("x" + save_state.split("_")[0] + "y" + save_state.split("_")[1]));
                        setStatus_old(old_iv.getTag().toString(),old_iv);
                        save_state = "";
                        selected = false;
                    }

                }

                return true;
            }
        });

        view_select.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    float x = motionEvent.getX();

                    Integer x_select = (int) (x - paddingSelectPx) / (piece_select + paddingSelectPiecePx);
                    if (x_select == null){
                        return false;
                    }
                    ImageView iv = findViewById(idMap.get("select" + x_select)); // ปัจจุบัน
                    if (iv.getTag().toString().split("_")[0].equals("use")) {
                        return false;
                    }

                    if (save_select == -1) {
                        save_select = x_select;
                        if(!selected) {
                            setChip_ontuch(iv, iv.getTag().toString());
                        }
                    } else {
                        ImageView iv_select = findViewById(idMap.get("select" + save_select)); // ก่อน
                        String value = (String) iv.getTag();
                        set_ship(iv, (String) iv_select.getTag()); // แก้ตัวปัจจุบัน


                        set_ship(iv_select, value); // แก้ตัวก่อน
//                        tv_select.setTextColor(Color.BLACK);
                        save_select = -1;
                    }
                    if (selected && !save_state.equals("")) {
                        ImageView old_iv = findViewById(idMap.get("x" + save_state.split("_")[0] + "y" + save_state.split("_")[1]));
                        set_ship(old_iv, (String) iv.getTag());
                        save_state = "";
                        iv.setAlpha(0.5F);
                        selected = false;
                        iv.setTag("use_" + iv.getTag());
                        save_select = -1;
                    }

                }

                return true;
            }
        });
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, ArrayList<Integer>> eq_list = find_eq();
                ArrayList<Boolean> list_eq = new ArrayList<Boolean>();
                ArrayList<Integer> x = eq_list.get("x");
                ArrayList<Integer> y = eq_list.get("y");
                for (int i = 0; i < x.size(); i++) {
                    Log.e("555", "X: "+ x.get(i)+ " | Y: "+ y.get(i));
                    ArrayList<Double> up = cal_c(x.get(i),y.get(i),"up","x",0,14);
                    ArrayList<Double> down = cal_c(x.get(i),y.get(i),"down","x",0,14);
                    Boolean up_down = Calculate.check_eq(up,down);
                    ArrayList<Double> left = cal_c(x.get(i),y.get(i),"left","y",0,14);
                    ArrayList<Double> right = cal_c(x.get(i),y.get(i),"right","y",0,14);
                    Boolean left_right = Calculate.check_eq(left, right);
                    Log.e("555", "UP&DOWN: "+ up.toString()+ "&"+ down.toString()+" -> "+up_down);
                    Log.e("555", "LEFT&RIGHT: "+ left.toString()+ "&"+ right.toString()+" -> "+left_right);
                    if (up_down == null || left_right == null){
                        list_eq.add(null);
                    }
                    else if (up_down || left_right){
                        list_eq.add(true);
                    }
                    else{
                        list_eq.add(false);
                    }
                }

                if (list_eq.size() == 0) {
                    Toast.makeText(MainActivity.this,"Can't find equation",Toast.LENGTH_SHORT).show();
                }
                else if (list_eq.contains(null)) {
                    Toast.makeText(MainActivity.this,"Pattern equation not correct",Toast.LENGTH_SHORT).show();
                }
                else if (Collections.frequency(list_eq,true)== list_eq.size()){
                    Toast.makeText(MainActivity.this,"Pass",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Not pass",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private int getRandomId() {

        boolean notInGeneralResourses = false;
        boolean foundInIdMap = false;

        String packageName = MainActivity.this.getPackageName();
        Random rnd = new Random();
        String name = "";

        //Repaet loop in case random number already exists
        while (true) {

            // Step 1 - generate a random id
            int generated_id = rnd.nextInt(999999);

            // Step 2 - Check R.id
            try {
                name = MainActivity.this.getResources().getResourceName(generated_id);
            } catch (Exception e) {
                name = null;
            }

            notInGeneralResourses = name == null || !name.startsWith(packageName);

            // Step 3 - Check in id HashMap
            if (notInGeneralResourses) {
                List<Integer> valueList = new ArrayList<Integer>(idMap.values());

                foundInIdMap = false;
                for (Integer value : valueList) {
                    if (generated_id == value) {
                        foundInIdMap = true;
                        break;
                    }
                }
            }

            // Step 4 - Return ID, or loop again.
            if (!foundInIdMap) {
                return generated_id;
            }
        }
    }

    // r = tripple_eq
    // y = doubble_eq
    // o = doubble_p
    // b = tripple_p
    // s = star
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setStatus(int key, ImageView iv, String[] row) {
        for (String e : row) {
            if (Integer.parseInt(e.split("_")[1]) == key) {
                if (e.split("_")[0].equals("r")) {
                    iv.setImageDrawable(getDrawable(R.drawable.tripple_eq));
                    iv.setTag("r");
                } else if (e.split("_")[0].equals("y")) {
                    iv.setImageDrawable(getDrawable(R.drawable.doubble_eq));
                    iv.setTag("y");
                } else if (e.split("_")[0].equals("o")) {
                    iv.setImageDrawable(getDrawable(R.drawable.doubble_p));
                    iv.setTag("o");
                } else if (e.split("_")[0].equals("b")) {
                    iv.setImageDrawable(getDrawable(R.drawable.tripple_p));
                    iv.setTag("b");
                } else if (e.split("_")[0].equals("s")) {
                    iv.setImageDrawable(getDrawable(R.drawable.star));
                    iv.setTag("s");
                }
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setStatus_ontuch(ImageView iv) {
        if (iv.getTag().equals("r")) {
            iv.setImageDrawable(getDrawable(R.drawable.tripple_eq_ch));
        } else if (iv.getTag().equals("y")) {
            iv.setImageDrawable(getDrawable(R.drawable.doubble_eq_ch));
        } else if (iv.getTag().equals("o")) {
            iv.setImageDrawable(getDrawable(R.drawable.doubble_p_ch));
        } else if (iv.getTag().equals("b")) {
            iv.setImageDrawable(getDrawable(R.drawable.tripple_p_ch));
        } else if (iv.getTag().equals("s")) {
            iv.setImageDrawable(getDrawable(R.drawable.star_ch));
        } else {
            iv.setImageDrawable(getDrawable(R.drawable.board_ch));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setStatus_old(String value, ImageView iv) {
        if (value.equals("r")) {
            iv.setImageDrawable(getDrawable(R.drawable.tripple_eq));
            iv.setTag("r");
        } else if (value.equals("y")) {
            iv.setImageDrawable(getDrawable(R.drawable.doubble_eq));
            iv.setTag("y");
        } else if (value.equals("o")) {
            iv.setImageDrawable(getDrawable(R.drawable.doubble_p));
            iv.setTag("o");
        } else if (value.equals("b")) {
            iv.setImageDrawable(getDrawable(R.drawable.tripple_p));
            iv.setTag("b");
        } else if (value.equals("s")) {
            iv.setImageDrawable(getDrawable(R.drawable.star));
            iv.setTag("s");
        } else {
            iv.setImageDrawable(getDrawable(R.drawable.board));
            iv.setTag("");
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void set_ship(ImageView iv, String value) {
        iv.setTag(value);
        if (value.equals("0")) {
            iv.setImageDrawable(getDrawable(R.drawable.a0));
        } else if (value.equals("1")) {
            iv.setImageDrawable(getDrawable(R.drawable.a1));
        } else if (value.equals("2")) {
            iv.setImageDrawable(getDrawable(R.drawable.a2));
        } else if (value.equals("3")) {
            iv.setImageDrawable(getDrawable(R.drawable.a3));
        } else if (value.equals("4")) {
            iv.setImageDrawable(getDrawable(R.drawable.a4));
        } else if (value.equals("5")) {
            iv.setImageDrawable(getDrawable(R.drawable.a5));
        } else if (value.equals("6")) {
            iv.setImageDrawable(getDrawable(R.drawable.a6));
        } else if (value.equals("7")) {
            iv.setImageDrawable(getDrawable(R.drawable.a7));
        } else if (value.equals("8")) {
            iv.setImageDrawable(getDrawable(R.drawable.a8));
        } else if (value.equals("9")) {
            iv.setImageDrawable(getDrawable(R.drawable.a9));
        } else if (value.equals("10")) {
            iv.setImageDrawable(getDrawable(R.drawable.a10));
        } else if (value.equals("11")) {
            iv.setImageDrawable(getDrawable(R.drawable.a11));
        } else if (value.equals("12")) {
            iv.setImageDrawable(getDrawable(R.drawable.a12));
        } else if (value.equals("13")) {
            iv.setImageDrawable(getDrawable(R.drawable.a13));
        } else if (value.equals("14")) {
            iv.setImageDrawable(getDrawable(R.drawable.a14));
        } else if (value.equals("15")) {
            iv.setImageDrawable(getDrawable(R.drawable.a15));
        } else if (value.equals("16")) {
            iv.setImageDrawable(getDrawable(R.drawable.a16));
        } else if (value.equals("17")) {
            iv.setImageDrawable(getDrawable(R.drawable.a17));
        } else if (value.equals("18")) {
            iv.setImageDrawable(getDrawable(R.drawable.a18));
        } else if (value.equals("19")) {
            iv.setImageDrawable(getDrawable(R.drawable.a19));
        } else if (value.equals("20")) {
            iv.setImageDrawable(getDrawable(R.drawable.a20));
        } else if (value.equals("+")) {
            iv.setImageDrawable(getDrawable(R.drawable.plus));
        } else if (value.equals("-")) {
            iv.setImageDrawable(getDrawable(R.drawable.delete));
        } else if (value.equals("*")) {
            iv.setImageDrawable(getDrawable(R.drawable.multiply));
        } else if (value.equals("/")) {
            iv.setImageDrawable(getDrawable(R.drawable.divide));
        } else if (value.equals("=")) {
            iv.setImageDrawable(getDrawable(R.drawable.equal));
        } else if (value.equals("+/-")) {
            iv.setImageDrawable(getDrawable(R.drawable.plus_delete));
        } else if (value.equals("*//")) {
            iv.setImageDrawable(getDrawable(R.drawable.multiply_divide));
        } else if (value.equals("blank")) {
            iv.setImageDrawable(getDrawable(R.drawable.blank));
        } else {
            iv.setImageDrawable(getDrawable(R.drawable.board));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public boolean check_status(String value) {
        String[] hp = new String[]{"r", "y", "b", "o", "s"};
        for (String e : hp) {
            if (e.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void setChip_ontuch(ImageView iv, String value) {
        if (iv.getTag().equals("0")) {
            iv.setImageDrawable(getDrawable(R.drawable.a0_ch));
        } else if (value.equals("1")) {
            iv.setImageDrawable(getDrawable(R.drawable.a1_ch));
        } else if (value.equals("2")) {
            iv.setImageDrawable(getDrawable(R.drawable.a2_ch));
        } else if (value.equals("3")) {
            iv.setImageDrawable(getDrawable(R.drawable.a3_ch));
        } else if (value.equals("4")) {
            iv.setImageDrawable(getDrawable(R.drawable.a4_ch));
        } else if (value.equals("5")) {
            iv.setImageDrawable(getDrawable(R.drawable.a5_ch));
        } else if (value.equals("6")) {
            iv.setImageDrawable(getDrawable(R.drawable.a6_ch));
        } else if (value.equals("7")) {
            iv.setImageDrawable(getDrawable(R.drawable.a7_ch));
        } else if (value.equals("8")) {
            iv.setImageDrawable(getDrawable(R.drawable.a8_ch));
        } else if (value.equals("9")) {
            iv.setImageDrawable(getDrawable(R.drawable.a9_ch));
        } else if (value.equals("10")) {
            iv.setImageDrawable(getDrawable(R.drawable.a10_ch));
        } else if (value.equals("11")) {
            iv.setImageDrawable(getDrawable(R.drawable.a11_ch));
        } else if (value.equals("12")) {
            iv.setImageDrawable(getDrawable(R.drawable.a12_ch));
        } else if (value.equals("13")) {
            iv.setImageDrawable(getDrawable(R.drawable.a13_ch));
        } else if (value.equals("14")) {
            iv.setImageDrawable(getDrawable(R.drawable.a14_ch));
        } else if (value.equals("15")) {
            iv.setImageDrawable(getDrawable(R.drawable.a15_ch));
        } else if (value.equals("16")) {
            iv.setImageDrawable(getDrawable(R.drawable.a16_ch));
        } else if (value.equals("17")) {
            iv.setImageDrawable(getDrawable(R.drawable.a17_ch));
        } else if (value.equals("18")) {
            iv.setImageDrawable(getDrawable(R.drawable.a18_ch));
        } else if (value.equals("19")) {
            iv.setImageDrawable(getDrawable(R.drawable.a19_ch));
        } else if (value.equals("20")) {
            iv.setImageDrawable(getDrawable(R.drawable.a20_ch));
        } else if (value.equals("+")) {
            iv.setImageDrawable(getDrawable(R.drawable.plus_ch));
        } else if (value.equals("-")) {
            iv.setImageDrawable(getDrawable(R.drawable.delete_ch));
        } else if (value.equals("*")) {
            iv.setImageDrawable(getDrawable(R.drawable.multiply_ch));
        } else if (value.equals("/")) {
            iv.setImageDrawable(getDrawable(R.drawable.divide_ch));
        } else if (value.equals("+/-")) {
            iv.setImageDrawable(getDrawable(R.drawable.plus_delete_ch));
        } else if (value.equals("*//")) {
            iv.setImageDrawable(getDrawable(R.drawable.multiply_divide_ch));
        }else if (value.equals("=")) {
            iv.setImageDrawable(getDrawable(R.drawable.equal_ch));
        } else if (value.equals("blank")) {
            iv.setImageDrawable(getDrawable(R.drawable.blank_ch));
        } else {
            iv.setImageDrawable(getDrawable(R.drawable.board_ch));
        }
        iv.setTag(value);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void back_status(int x, int y, ImageView iv) {
        switch (y) {
            case 0: {
                setStatus(x, iv, row_1);
                break;
            }
            case 1: {
                setStatus(x, iv, row_2);
                break;
            }
            case 2: {
                setStatus(x, iv, row_3);
                break;
            }
            case 3: {
                setStatus(x, iv, row_4);
                break;
            }
            case 4: {
                setStatus(x, iv, row_5);
                break;
            }
            case 5: {
                setStatus(x, iv, row_6);
                break;
            }
            case 6: {
                setStatus(x, iv, row_7);
                break;
            }
            case 7: {
                setStatus(x, iv, row_8);
                break;
            }
            case 8: {
                setStatus(x, iv, row_9);
                break;
            }
            case 9: {
                setStatus(x, iv, row_10);
                break;
            }
            case 10: {
                setStatus(x, iv, row_11);
                break;
            }
            case 11: {
                setStatus(x, iv, row_12);
                break;
            }
            case 12: {
                setStatus(x, iv, row_13);
                break;
            }
            case 13: {
                setStatus(x, iv, row_14);
                break;
            }
            case 14: {
                setStatus(x, iv, row_15);
                break;
            }
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void random_ship(ImageView iv){
        Random random = new Random();
        String type_index = types[random.nextInt(types.length)];
        set_ship(iv,type_index);

    }

    public String getIV(int x, int y) {
        return findViewById(idMap.get("x"+x+"y"+y)).getTag().toString();
    }

    public HashMap<String,ArrayList<Integer>> find_eq(){
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (getIV(j, i).equals("=")){
                    x.add(j);
                    y.add(i);
                }
            }
        }
        HashMap <String, ArrayList<Integer>> hashMap = new HashMap<>();
        hashMap.put("x",x);
        hashMap.put("y",y);
        return hashMap;
    }

    public ArrayList<Double> cal_c(int x, int y, String direct, String coordinate, int min, int max) {
        if (coordinate.equals("x")) {
            if (direct.equals("up")) {
                return loop_cal("y", x, y, min, -1);
            } else if (direct.equals("down")) {
                return loop_cal( "y", x, y, max, 1);
            }
        }
        else if (coordinate.equals("y")) {
            if (direct.equals("left")) {
                return loop_cal( "x", y, x, min, -1);
            }
            else if (direct.equals("right")) {
                return loop_cal("x", y, x, max, 1);
            }
        }
        return null;
    }

    public ArrayList<Double> loop_cal (String coordinate, int coo_n, int start, int end, int increment) {
        ArrayList<Double> save_result = new ArrayList<>();
        ArrayList<String> save_eq = new ArrayList<>();
        start += increment ;
        String result = "";
        while (start != end+increment) {

            if (coordinate.equals("x")){
                result = getIV(start, coo_n);
            }
            else if (coordinate.equals("y")) {
                result = getIV(coo_n, start);
            }

            if (result.equals("") || result.equals("r") || result.equals("y") || result.equals("o") || result.equals("b") || result.equals("s")) {
                if (save_eq.size() > 0) {
                    save_result.add(Calculate.calculate(save_eq, increment));
                }
                break;
            }
            else if (result.equals("=")) { // เริ่มการคำนวนต่อ ถ้าเจอ =
                save_result.add(Calculate.calculate(save_eq, increment));
                save_eq = new ArrayList<>();
            }
            else if (start == end) { // ค่าอยูตำแหน่ง่ขอบตาราง *ต้องเป็นตัวเลข
                save_eq.add(result);
                save_result.add(Calculate.calculate(save_eq, increment));
            } else {
                if (!Calculate.isNumeric(result)) {  // ต้องเป็นตัวอักษร + - * /
                    // มีแค่ - เท่านั้นที่สามารถติดกับ = ได้ || สมการต้องมี ตัวดำเนินการติดกันเพียงแค่ 1
                    if ((save_eq.size() == 0 && !result.equals("-")) || (save_eq.size() > 0 && !Calculate.isNumeric(save_eq.get(save_eq.size()-1)))) {
                        save_result.add(null);
                        break;
                    }
                }
                save_eq.add(result);
            }
            start += increment;
        }
        return save_result;
    }



}