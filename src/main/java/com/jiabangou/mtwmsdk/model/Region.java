package com.jiabangou.mtwmsdk.model;

import com.alibaba.fastjson.annotation.JSONType;

import java.io.Serializable;

/**
 * 经纬度
 * Created by konghang on 16/3/3.
 */
@JSONType
public class Region implements Serializable {

    private Double x;  //latitude

    private Double y; //longitude

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Region{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
