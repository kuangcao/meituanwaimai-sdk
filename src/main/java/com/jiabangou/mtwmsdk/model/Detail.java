package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-10-13.
 */
public class Detail implements Serializable {
    private String app_food_code; //菜品code
    private String food_name; //菜品名
    private String sku_id;
    private Integer quantity; //菜品数量
    private Double price; //菜品价格 （此字段默认为活动折扣后价格，可在开发者中心订阅是否替换为原价）
    private Integer box_num; //餐盒数量
    private Double box_price; //餐盒单价
    private String unit; //菜品单位
    private Float food_discount; //0.8 (菜品折扣，只是美团商家、APP方配送的门店才会设置，默认为1。折扣值不参与总价计算。开放平台1.0.3 新增)
    private String food_property; //"中辣,微甜" (菜品属性，多个属性用英文逗号隔开，该信息默认不推送，如有需求可在开发者中心订阅)

    public String getApp_food_code() {
        return app_food_code;
    }

    public void setApp_food_code(String app_food_code) {
        this.app_food_code = app_food_code;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getSku_id() {
        return sku_id;
    }

    public void setSku_id(String sku_id) {
        this.sku_id = sku_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getBox_num() {
        return box_num;
    }

    public void setBox_num(Integer box_num) {
        this.box_num = box_num;
    }

    public Double getBox_price() {
        return box_price;
    }

    public void setBox_price(Double box_price) {
        this.box_price = box_price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Float getFood_discount() {
        return food_discount;
    }

    public void setFood_discount(Float food_discount) {
        this.food_discount = food_discount;
    }

    public String getFood_property() {
        return food_property;
    }

    public void setFood_property(String food_property) {
        this.food_property = food_property;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "app_food_code='" + app_food_code + '\'' +
                ", food_name='" + food_name + '\'' +
                ", sku_id='" + sku_id + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", box_num=" + box_num +
                ", box_price=" + box_price +
                ", unit='" + unit + '\'' +
                ", food_discount=" + food_discount +
                ", food_property='" + food_property + '\'' +
                '}';
    }
}
