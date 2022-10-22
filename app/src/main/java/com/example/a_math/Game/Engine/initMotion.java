package com.example.a_math.Game.Engine;

import static com.example.a_math.Game.Engine.Point.startPoint;
import static com.example.a_math.Game.Engine.Validate.find_and_count;
import static com.example.a_math.Game.Engine.Validate.start;
import static com.example.a_math.Game.Engine.initObj.createSelect;
import static com.example.a_math.Game.Engine.initObj.paddingPiecePx;
import static com.example.a_math.Game.Engine.initObj.paddingSelectPiecePx;
import static com.example.a_math.Game.Engine.initObj.paddingSelectPx;
import static com.example.a_math.Game.Engine.initObj.paddingStrokePx;
import static com.example.a_math.Game.Engine.initObj.piece;
import static com.example.a_math.Game.Engine.initObj.piece_select;
import static com.example.a_math.Game.Setting.getNum;
import static com.example.a_math.Game.Setting.getSelectNum;
import static com.example.a_math.Game.UI.Chip.getIVTag;
import static com.example.a_math.Game.UI.Chip.saveIVTag;
import static com.example.a_math.Game.UI.Interface.setChip;
import static com.example.a_math.Game.UI.Interface.setChip_onTouch;
import static com.example.a_math.Game.UI.Interface.setStatus;
import static com.example.a_math.Game.UI.Interface.setStatus_onTouch;
import static com.example.a_math.Game.UI.Table.getStatus;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;

import com.example.a_math.FinalActivity;
import com.example.a_math.GameActivity;
import com.example.a_math.Options.SharePrefMap;
import com.example.a_math.Options.SharePrefStar;
import com.example.a_math.R;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class initMotion {

    static int save_select = -1;
    static String save_state = "";
    static boolean selected = false;
    static int newChip = 0;

    @RequiresApi(api = Build.VERSION_CODES.R)
    public static void initMotionObj(Activity activity, HashMap<String, Integer> idMap, int map, int pointOrigin, HashMap<Integer, Integer> point, int initNewChip, HashMap<String, Object> dict) {
        View view = activity.findViewById(R.id.table);
        View view_select = activity.findViewById(R.id.select);

        tableOnTouch(activity, view, idMap);
        selectOnTouch(activity, view_select, idMap);

        newChip = initNewChip;
        submitOnTouch(activity, activity.findViewById(idMap.get("submit")), idMap, map, pointOrigin, point, dict);
        newChipOnTouch(activity, activity.findViewById(idMap.get("new_chip")), idMap, map);
    }

    @RequiresApi(api = Build.VERSION_CODES.R)
    private static void tableOnTouch(Activity activity, View obj, HashMap<String, Integer> idMap) {
        obj.setOnTouchListener((view,motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();

                int x_table = (int) (x - paddingStrokePx) / (piece + paddingPiecePx);
                int y_table = (int) (y - paddingStrokePx) / (piece + paddingPiecePx);

                ImageView iv = activity.findViewById(idMap.get("x" + x_table + "y" + y_table));

                if ((Boolean) getIVTag(iv, "locked")) {
                    return false;
                }

                if (getIVTag(iv, "index") != null) {
                    ImageView iv_select = activity.findViewById(idMap.get("select" + getIVTag(iv, "index")));
                    setStatus(activity, iv, (String) getIVTag(iv, "type"));
                    saveIVTag(iv_select, "used", false);
                    saveIVTag(iv, "value", null);
                    saveIVTag(iv, "index", null);
                    iv_select.setAlpha(1F);
                    return true;
                }

                if (save_state.equals("")) {
                    save_state = x_table + "_" + y_table;
                    setStatus_onTouch(activity, iv, getStatus(y_table, x_table));
                    selected = true;
                    if (save_select != -1) {
                        ImageView iv_select = activity.findViewById(idMap.get("select" + save_select));
                        setChip(activity, iv_select, (String) getIVTag(iv_select, "value"));
                        save_select = -1;
                    }
                } else {
                    int xIndex = Integer.parseInt(save_state.split("_")[0]);
                    int yIndex = Integer.parseInt(save_state.split("_")[1]);
                    ImageView old_iv = activity.findViewById(idMap.get("x" + xIndex + "y" + yIndex));
                    setStatus(activity, old_iv, getStatus(yIndex, xIndex));
                    save_state = "";
                    selected = false;
                }
            } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                view.performClick();
            }
            return true;
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private static void selectOnTouch(Activity activity, View obj, HashMap<String, Integer> idMap) {
        obj.setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                float x = motionEvent.getX();

                int x_select = (int) (x - paddingSelectPx) / (piece_select + paddingSelectPiecePx);

                if (x_select < 0 || x_select >= getSelectNum()){
                    return false;
                }

                ImageView iv = activity.findViewById(idMap.get("select" + x_select)); // ปัจจุบัน
                if ((Boolean) getIVTag(iv, "used")) {
                    return false;
                }

                if (save_select == -1) {
                    save_select = x_select;
                    if(!selected) {
                        setChip_onTouch(activity, iv, (String) getIVTag(iv, "value"));
                    }
                } else {
                    ImageView iv_select = activity.findViewById(idMap.get("select" + save_select)); // ก่อน
                    String value = (String) getIVTag(iv, "value");
                    setChip(activity, iv, (String) getIVTag(iv_select, "value")); // แก้ตัวปัจจุบัน
                    setChip(activity, iv_select, value); // แก้ตัวก่อน
                    save_select = -1;
                }
                if (selected && !save_state.equals("")) {
                    ImageView old_iv = activity.findViewById(idMap.get("x" + save_state.split("_")[0] + "y" + save_state.split("_")[1]));
                    setChip(activity, old_iv, (String) getIVTag(iv, "value"));
                    saveIVTag(iv, "used", true);
                    saveIVTag(old_iv, "index", save_select);
                    save_state = "";
                    iv.setAlpha(0.5F);
                    selected = false;
                    save_select = -1;
                }
            } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                view.performClick();
            }
            return true;
        });
    }

    private static String join(List<?> list, String delimit) {
        int len = list.size();
        if (len == 0)
            return "";
        StringBuilder sb = new StringBuilder(list.get(0).toString());
        for (int i = 1; i < len; i++) {
            sb.append(delimit);
            sb.append(list.get(i).toString());
        }
        return sb.toString();
    }

    private static void submitOnTouch(Activity activity, Button btn, HashMap<String, Integer> idMap, int map, int pointOrigin, HashMap<Integer, Integer> point, HashMap<String, Object> dictOld) {
//        btn.setOnClickListener(view -> onButtonShowPopupWindowClick(activity, btn));
        btn.setOnClickListener(view -> {
            boolean passed = start(activity, idMap);
            SharePrefMap sharePref = new SharePrefMap(activity);
            SharePrefStar sharePrefStar = new SharePrefStar(activity);
            String mapper = sharePref.loadMap();
            String allStar = sharePrefStar.loadStar();

            if (passed) {
                HashMap<String, Object> dictNew = (HashMap<String, Object>) find_and_count(activity, idMap);
                System.out.println("New: " + dictNew);
                if (true) {
                    int eqCountNew = 0, eqCountOld = 0;
                    for (String item : (List<String>) dictNew.get("operation")) {
                        if (item.equals("=")) {
                            eqCountNew++;
                        }
                    }
                    for (String item : (List<String>) dictOld.get("operation")) {
                        if (item.equals("=")) {
                            eqCountOld++;
                        }
                    }
                    int diffEq = eqCountNew - eqCountOld;
                    dictOld.put("count", dictNew.get("count"));
                    dictOld.put("operation", dictNew.get("operation"));
                    List<Integer> xList = ((List<Integer>) dictOld.get("x")).subList(0, eqCountOld);
                    List<Integer> yList = ((List<Integer>) dictOld.get("y")).subList(0, eqCountOld);
                    int maxX = 0, maxY = 0;
                    for (int i = 0; i < eqCountOld; i++) {
                        int currX = ((List<Integer>) dictOld.get("x")).get(i);
                        int currY = ((List<Integer>) dictOld.get("y")).get(i);
                        if (currX > maxX) {
                            maxX = currX;
                        }
                        if (currY > maxY) {
                            maxY = currY;
                        }
                    }
                    for (int i = 0; i < diffEq; i++) {
                        int x = ((List<Integer>) dictNew.get("x")).get(i);
                        int y = ((List<Integer>) dictNew.get("y")).get(i);
//                        xList.add(eqCountOld+i, x);
//                        yList.add(eqCountOld+i, y);
                        System.out.println("X: "+x+" MaxX: "+maxX+" Y: "+y+" MaxY: "+maxY);
                        if (x > maxX || y > maxY) {
                            xList.add(x);
                            yList.add(y);
//                            eqCountOld++;
                        }
                    }
                    List<Integer> xTail = ((List<Integer>) dictNew.get("x")).subList(eqCountNew-1, ((int) dictNew.get("count")));
                    List<Integer> yTail = ((List<Integer>) dictNew.get("y")).subList(eqCountNew-1, ((int) dictNew.get("count")));
                    xList.addAll(xTail);
                    yList.addAll(yTail);
                    dictOld.put("x", xList);
                    dictOld.put("y", yList);

                    System.out.println("Edit: " + dictOld);
                }

                int currentPoint = startPoint(activity, idMap, dictOld);
                int pointGame = Math.abs(currentPoint - pointOrigin);

                List<String> mapList = new ArrayList<>(Arrays.asList(mapper.split(",")));
                List<String> starSumList = new ArrayList<>(Arrays.asList(allStar.split(":")));

                int star1 = point.get(1); //30
                int star2 = point.get(2); //50
                int star3 = point.get(3); //100

                int starNew;

                ImageView iv_select1 = activity.findViewById(idMap.get("select0"));
                ImageView iv_select2 = activity.findViewById(idMap.get("select1"));
                ImageView iv_select3 = activity.findViewById(idMap.get("select2"));
                ImageView iv_select4 = activity.findViewById(idMap.get("select3"));
                ImageView iv_select5 = activity.findViewById(idMap.get("select4"));
                ImageView iv_select6 = activity.findViewById(idMap.get("select5"));
                ImageView iv_select7 = activity.findViewById(idMap.get("select6"));
                ImageView iv_select8 = activity.findViewById(idMap.get("select7"));

                int countSelect = 0;
                if ((Boolean) getIVTag(iv_select1, "used")) {
                    countSelect++;
                }
                if ((Boolean) getIVTag(iv_select2, "used")) {
                    countSelect++;
                }
                if ((Boolean) getIVTag(iv_select3, "used")) {
                    countSelect++;
                }
                if ((Boolean) getIVTag(iv_select4, "used")) {
                    countSelect++;
                }
                if ((Boolean) getIVTag(iv_select5, "used")) {
                    countSelect++;
                }
                if ((Boolean) getIVTag(iv_select6, "used")) {
                    countSelect++;
                }
                if ((Boolean) getIVTag(iv_select7, "used")) {
                    countSelect++;
                }
                if ((Boolean) getIVTag(iv_select8, "used")) {
                    countSelect++;
                }

                if (countSelect == 8) {
                    pointGame += 40;
                }
                System.out.println("Origin Point "+pointOrigin+", Game Point "+currentPoint+", Final Point:"+pointGame);

                if (pointGame < star1) {
                    starNew = 0;
                } else if (pointGame < star2) {
                    starNew = 1;
                } else if (pointGame < star3) {
                    starNew = 2;
                } else {
                    starNew = 3;
                }

                // "5:2,3"
                // "5:2,1"
                try {
                    String[] findMap = mapList.get(map-1).split(":");
                    int allSumStar = Integer.parseInt(starSumList.get(0));
                    int findStar = Integer.parseInt(starSumList.get(1).split(",")[map-1]);
                    int oldPoint = Integer.parseInt(findMap[1]);

                    if (findStar < starNew) {
                        allSumStar = allSumStar - findStar + starNew;
                        List<String> starList = new ArrayList<>(Arrays.asList(starSumList.get(1).split(",")));
                        starList.set(map-1, starNew+"");
                        sharePrefStar.setStar(allSumStar+":"+join(starList, ","));
                    }

                    if (oldPoint < pointGame) {
                        String scoreMap = starNew + ":" + pointGame;
                        mapList.set(map - 1, scoreMap);
                        mapper = join(mapList, ",");
                    }
                } catch (Exception ex) {
                    String scoreMap = starNew + ":" + pointGame;
                    if (map == 1) {
                        mapList.set(0, scoreMap);
                        sharePrefStar.setStar(starNew+":"+starNew);
                    } else {
                        mapList.add(scoreMap);

                        int allSumStar = Integer.parseInt(starSumList.get(0));
                        allSumStar = allSumStar + starNew;
                        List<String> starList = new ArrayList<>(Arrays.asList(starSumList.get(1).split(",")));
                        starList.add(starNew+"");
                        sharePrefStar.setStar(allSumStar+":"+join(starList, ","));
                    }
                    mapper = join(mapList, ",");
                }

                sharePref.setMap(mapper);
                Log.i("SCORE", mapper);

                Intent i = new Intent(activity, FinalActivity.class);
                i.putExtra("map" , map+1);
                i.putExtra("starNew" , starNew);
                activity.startActivity(i);
                activity.finish();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private static void newChipOnTouch(Activity activity, Button btn, HashMap<String, Integer> idMap, int map) {
        btn.setOnClickListener(view -> {
            SharePrefStar sharePrefStar = new SharePrefStar(activity);

            String allStar = sharePrefStar.loadStar(); // "" ,"5:2,3"
            if (newChip > 0 && !allStar.equals("")) {
                int allSumStar = Integer.parseInt(allStar.split(":")[0]);
                if (allSumStar > 0) {
//                    sharePrefStar.setStar(allSumStar-1+":"+allStar.split(":")[1]);

                    System.out.println(newChip);
                    HashMap<Integer, String> select_chip = new HashMap<>();
                    try {
                        Class<?> cls = Class.forName("com.example.a_math.Game.Map.Map"+map);
                        Method method = cls.getDeclaredMethod("getChip"+newChip, HashMap.class);

                        method.invoke(new HashMap<>(), select_chip);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    ImageView iv_select1 = activity.findViewById(idMap.get("select0"));
                    ImageView iv_select2 = activity.findViewById(idMap.get("select1"));
                    ImageView iv_select3 = activity.findViewById(idMap.get("select2"));
                    ImageView iv_select4 = activity.findViewById(idMap.get("select3"));
                    ImageView iv_select5 = activity.findViewById(idMap.get("select4"));
                    ImageView iv_select6 = activity.findViewById(idMap.get("select5"));
                    ImageView iv_select7 = activity.findViewById(idMap.get("select6"));
                    ImageView iv_select8 = activity.findViewById(idMap.get("select7"));

                    setChip(activity, iv_select1, select_chip.get(0));
                    setChip(activity, iv_select2, select_chip.get(1));
                    setChip(activity, iv_select3, select_chip.get(2));
                    setChip(activity, iv_select4, select_chip.get(3));
                    setChip(activity, iv_select5, select_chip.get(4));
                    setChip(activity, iv_select6, select_chip.get(5));
                    setChip(activity, iv_select7, select_chip.get(6));
                    setChip(activity, iv_select8, select_chip.get(7));

                    for (int i = 0; i < getNum(); i++) {
                        for (int j = 0; j < getNum(); j++) {
                            ImageView iv = activity.findViewById(idMap.get("x" + j + "y" + i));

                            if (!(Boolean) getIVTag(iv, "locked")) {
                                saveIVTag(iv, "value", null);
                                setStatus(activity, iv, (String) getIVTag(iv, "type"));
                            }
                        }
                    }

                    saveIVTag(iv_select1, "used", false);
                    saveIVTag(iv_select2, "used", false);
                    saveIVTag(iv_select3, "used", false);
                    saveIVTag(iv_select4, "used", false);
                    saveIVTag(iv_select5, "used", false);
                    saveIVTag(iv_select6, "used", false);
                    saveIVTag(iv_select7, "used", false);
                    saveIVTag(iv_select8, "used", false);

                    iv_select1.setAlpha(1F);
                    iv_select2.setAlpha(1F);
                    iv_select3.setAlpha(1F);
                    iv_select4.setAlpha(1F);
                    iv_select5.setAlpha(1F);
                    iv_select6.setAlpha(1F);
                    iv_select7.setAlpha(1F);
                    iv_select8.setAlpha(1F);

                    save_state = "";
                    selected = false;
                    save_select = -1;

                    newChip--;
                }
            }
        });
    }
}
