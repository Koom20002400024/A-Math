package com.example.a_math.Game.UI;

import static com.example.a_math.Game.UI.Chip.saveIVTag;
import static com.example.a_math.Game.isNumeric.isNumeric;

import android.app.Activity;
import android.os.Build;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;

import com.example.a_math.R;

public class Interface {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void setStatus_onTouch(Activity activity, ImageView iv, String value) {
        if (value.equals("r")) {
            iv.setImageDrawable(activity.getDrawable(R.drawable.tripple_eq_ch));
        } else if (value.equals("y")) {
            iv.setImageDrawable(activity.getDrawable(R.drawable.doubble_eq_ch));
        } else if (value.equals("o")) {
            iv.setImageDrawable(activity.getDrawable(R.drawable.doubble_p_ch));
        } else if (value.equals("b")) {
            iv.setImageDrawable(activity.getDrawable(R.drawable.tripple_p_ch));
        } else if (value.equals("s")) {
            iv.setImageDrawable(activity.getDrawable(R.drawable.star_ch));
        } else {
            iv.setImageDrawable(activity.getDrawable(R.drawable.board_ch));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void setStatus(Activity activity, ImageView iv, String value) {
        if (value.equals("r")) {
            iv.setImageDrawable(activity.getDrawable(R.drawable.tripple_eq));
        } else if (value.equals("y")) {
            iv.setImageDrawable(activity.getDrawable(R.drawable.doubble_eq));
        } else if (value.equals("o")) {
            iv.setImageDrawable(activity.getDrawable(R.drawable.doubble_p));
        } else if (value.equals("b")) {
            iv.setImageDrawable(activity.getDrawable(R.drawable.tripple_p));
        } else if (value.equals("s")) {
            iv.setImageDrawable(activity.getDrawable(R.drawable.star));
        } else {
            iv.setImageDrawable(activity.getDrawable(R.drawable.board));
        }
        saveIVTag(iv, "type", value);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void setChip(Activity activity, ImageView iv, String value) {
        if (isNumeric(value)) {
            int id = activity.getResources().getIdentifier("a" + value, "drawable", activity.getPackageName());
            iv.setImageResource(id);
        } else if (value.contains("c")) {
            if (value.equals("+c")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.plusbl));
            } else if (value.equals("-c")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.deletebl));
            }else if (value.equals("*c")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.multiplybl));
            }else if (value.equals("/c")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.dividebl));
            }else if (value.equals("=c")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.equalbl));
            } else {
                int id = activity.getResources().getIdentifier("a" + value.replace("c", "") + "bl", "drawable", activity.getPackageName());
                iv.setImageResource(id);
            }
        } else {
            if (value.equals("+")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.plus));
            } else if (value.equals("-")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.delete));
            } else if (value.equals("*")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.multiply));
            } else if (value.equals("/")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.divide));
            } else if (value.equals("=")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.equal));
            } else if (value.equals("+/-")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.plus_delete));
            } else if (value.equals("*//")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.multiply_divide));
            } else if (value.equals("+kl")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.plus_delete_cldel));
            }else if (value.equals("-kl")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.plus_delete_clpl));
            }else if (value.equals("*kl")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.multiply_divide_cldivide));
            }else if (value.equals("/kl")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.multiply_divide_clmul));
            }else if (value.equals("blank")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.blank));
            }else {
                iv.setImageDrawable(activity.getDrawable(R.drawable.board));
            }
        }
        saveIVTag(iv, "value", value);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void setChip_onTouch(Activity activity, ImageView iv, String value) {
        if (isNumeric(value)) {
            int id = activity.getResources().getIdentifier("a" + value + "_ch", "drawable", activity.getPackageName());
            iv.setImageResource(id);
        } else {
            if (value.equals("+")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.plus_ch));
            } else if (value.equals("-")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.delete_ch));
            } else if (value.equals("*")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.multiply_ch));
            } else if (value.equals("/")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.divide_ch));
            } else if (value.equals("=")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.equal_ch));
            } else if (value.equals("+/-")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.plus_delete_ch));
            } else if (value.equals("*//")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.multiply_divide_ch));
            } else if (value.equals("blank")) {
                iv.setImageDrawable(activity.getDrawable(R.drawable.blank_ch));
            } else {
                iv.setImageDrawable(activity.getDrawable(R.drawable.board_ch));
            }
        }
    }

}
