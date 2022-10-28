package com.example.a_math.Game.Popup;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import static com.example.a_math.Game.UI.Interface.setChip;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.annotation.RequiresApi;

import com.example.a_math.R;

public class PopupBlank {

    public static void onButtonShowPopupBlankClick(Activity activity, View view, ImageView iv_select) {

        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View popupView = inflater.inflate(R.layout.popup_blank, null);


        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        popupWindow.setAnimationStyle(R.style.popup_window_animation);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        ImageView iv0 = popupView.findViewById(R.id.select_0);

        iv0.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "0c");
                popupWindow.dismiss();
            }
        });
        ImageView iv1 = popupView.findViewById(R.id.select_1);

        iv1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "1c");
                popupWindow.dismiss();
            }
        });
        ImageView iv2 = popupView.findViewById(R.id.select_2);

        iv2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "2c");
                popupWindow.dismiss();
            }
        });
        ImageView iv3 = popupView.findViewById(R.id.select_3);

        iv3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "3c");
                popupWindow.dismiss();
            }
        });
        ImageView iv4 = popupView.findViewById(R.id.select_4);

        iv4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "4c");
                popupWindow.dismiss();
            }
        });
        ImageView iv5 = popupView.findViewById(R.id.select_5);

        iv5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "5c");
                popupWindow.dismiss();
            }
        });
        ImageView iv6 = popupView.findViewById(R.id.select_6);

        iv6.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "6c");
                popupWindow.dismiss();
            }
        });
        ImageView iv7 = popupView.findViewById(R.id.select_7);

        iv7.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "7c");
                popupWindow.dismiss();
            }
        });
        ImageView iv8 = popupView.findViewById(R.id.select_8);

        iv8.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "8c");
                popupWindow.dismiss();
            }
        });
        ImageView iv9 = popupView.findViewById(R.id.select_9);

        iv9.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "9c");
                popupWindow.dismiss();
            }
        });
        ImageView iv10 = popupView.findViewById(R.id.select_10);

        iv10.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "10c");
                popupWindow.dismiss();
            }
        });
        ImageView iv11 = popupView.findViewById(R.id.select_11);

        iv11.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "11c");
                popupWindow.dismiss();
            }
        });
        ImageView iv12 = popupView.findViewById(R.id.select_12);

        iv12.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "12c");
                popupWindow.dismiss();
            }
        });
        ImageView iv13 = popupView.findViewById(R.id.select_13);

        iv13.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "13c");
                popupWindow.dismiss();
            }
        });
        ImageView iv14 = popupView.findViewById(R.id.select_14);

        iv14.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "14c");
                popupWindow.dismiss();
            }
        });
        ImageView iv15 = popupView.findViewById(R.id.select_15);

        iv15.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "15c");
                popupWindow.dismiss();
            }
        });
        ImageView iv16 = popupView.findViewById(R.id.select_16);

        iv16.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "16c");
                popupWindow.dismiss();
            }
        });
        ImageView iv17 = popupView.findViewById(R.id.select_17);

        iv17.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "17c");
                popupWindow.dismiss();
            }
        });
        ImageView iv18 = popupView.findViewById(R.id.select_18);

        iv18.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "18c");
                popupWindow.dismiss();
            }
        });
        ImageView iv19 = popupView.findViewById(R.id.select_19);

        iv19.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "19c");
                popupWindow.dismiss();
            }
        });
        ImageView iv20 = popupView.findViewById(R.id.select_20);

        iv20.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "20c");
                popupWindow.dismiss();
            }
        });
        ImageView iv_pl = popupView.findViewById(R.id.select_plus);

        iv_pl.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "+c");
                popupWindow.dismiss();
            }
        });
        ImageView iv_del = popupView.findViewById(R.id.select_minus);

        iv_del.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "-c");
                popupWindow.dismiss();
            }
        });
        ImageView iv_multi = popupView.findViewById(R.id.select_multi);

        iv_multi.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "*c");
                popupWindow.dismiss();
            }
        });
        ImageView iv_divide = popupView.findViewById(R.id.select_divide);

        iv_divide.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "/c");
                popupWindow.dismiss();
            }
        });
        ImageView iv_equal = popupView.findViewById(R.id.select_equal);

        iv_equal.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "=c");
                popupWindow.dismiss();
            }
        });

    }

}
