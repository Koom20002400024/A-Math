package com.example.a_math.Models;

public class PointGame {

    String value;
    int point;
    String index;
    String type;

    public PointGame(String value, int point, String index, String type) {
        this.value = value;
        this.point = point;
        this.index = index;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
