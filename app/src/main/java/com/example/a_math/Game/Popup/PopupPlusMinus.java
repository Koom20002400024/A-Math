package com.example.a_math.Game.Popup;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import static com.example.a_math.Game.UI.Interface.setChip;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.annotation.RequiresApi;

import com.example.a_math.R;

public class PopupPlusMinus {

    public static void onButtonShowPopupPlusMinusClick(Activity activity, View view, ImageView iv_select) {

        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View popupView = inflater.inflate(R.layout.popup_plus_minus, null);


        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        popupWindow.setAnimationStyle(R.style.popup_window_animation);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        ImageView iv_plus = popupView.findViewById(R.id.select_plus);

        iv_plus.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "+kl");
                popupWindow.dismiss();
            }
        });

        ImageView iv_minus = popupView.findViewById(R.id.select_minus);

        iv_minus.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                setChip(activity, iv_select, "-kl");
                popupWindow.dismiss();
            }
        });
    }

}
