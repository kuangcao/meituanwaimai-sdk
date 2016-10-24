package com.jiabangou.mtwmsdk.model;

import com.alibaba.fastjson.annotation.JSONType;

import java.io.Serializable;

/**
 * 经纬度
 * Created by konghang on 16/3/3.
 */
@JSONType
public class Region implements Serializable {

    private String x;  //latitude

    private String y; //longitude

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Region{" +
                "x='" + x + '\'' +
                ", y='" + y + '\'' +
                '}';
    }
}
