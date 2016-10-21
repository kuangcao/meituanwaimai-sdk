package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * 门店配送范围
 * Created by freeway on 16/3/12.
 */
public class Shipping implements Serializable {

    //	string	是	123	APP方提供的配送范围id，如一个门店没有配送范围ID，且每个门店只有一个配送范围，可以填1
    private String app_shipping_code;
    //	string	是	1	配置范围类型，（1表示多个配送范围由多个多边形组成）只支持多边形
    private String type;
    //	string;	是	[{"x":39941199,"y":116385384},{"x":39926983,"y":116361694},{"x":39921586,"y":116398430}]	配送范围type 为 1 时: [{"x":39941199,"y":116385384},{ "x":39926983,"y":116361694},{"x ":39921586,"y":116398430}] type 为 2 时: {"r":1000,"x":40029380,"y":1164 18390}，需要对其urlEncode，x代表纬度，y代表经度（美团使用的是高德坐标系，也就是火星坐标系，如果是百度坐标系需要转换，配送范围坐标需要乘以一百万)
    private List<Region> area;
    //	Double	是	8	该配送区域的起送价
    private Double min_price;
    //	Double	否	5	该配送区域的配送费(建议填写这个字段设定配送费,如果此字段为空,则以门店保存的配送费为准)
    private Double shipping_fee;

    public String getApp_shipping_code() {
        return app_shipping_code;
    }

    public void setApp_shipping_code(String app_shipping_code) {
        this.app_shipping_code = app_shipping_code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Region> getArea() {
        return area;
    }

    public void setArea(List<Region> area) {
        this.area = area;
    }

    public Double getMin_price() {
        return min_price;
    }

    public void setMin_price(Double min_price) {
        this.min_price = min_price;
    }

    public Double getShipping_fee() {
        return shipping_fee;
    }

    public void setShipping_fee(Double shipping_fee) {
        this.shipping_fee = shipping_fee;
    }

    @Override
    public String toString() {
        return "Shipping{" +
                "app_shipping_code='" + app_shipping_code + '\'' +
                ", type='" + type + '\'' +
                ", area=" + area +
                ", min_price=" + min_price +
                ", shipping_fee=" + shipping_fee +
                '}';
    }
}
