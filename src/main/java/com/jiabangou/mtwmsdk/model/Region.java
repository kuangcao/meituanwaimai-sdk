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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Region region = (Region) o;

        if (x != null ? !x.equals(region.x) : region.x != null) return false;
        return y != null ? y.equals(region.y) : region.y == null;

    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Region{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
