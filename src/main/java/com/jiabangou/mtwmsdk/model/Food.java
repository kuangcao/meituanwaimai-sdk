package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * 菜品数据对象
 * Created by freeway on 16/3/12.
 */
public class Food implements Serializable {

    private String app_poi_code; //	string	是	25381	App方门店ID
    private String app_food_code; //	string	是	abc	APP方菜品id，最大长度128，不同门店可以重复，同一门店内不能重复
    private String name; //	string	添加时必须	美团定制版	菜品名称
    private String description; //	string	非必须	这是一个菜品	菜品描述
    private Double price; //	float	添加时必须	10.5	菜品价格 不能为负数
    private Integer min_order_count; //	int	添加时必须	1	最小购买量，最小为1
    private String unit;//	string	添加时必须	份	单位
    private Float box_num;//	float	添加时必须	1.0	打包盒数量
    private Double box_price;//	float	添加时必须	1.0	餐盒价格 不能为负数
    private String category_name;//	string	添加时必须	面食	菜品分类名
    private Integer is_sold_out; //	int	添加时必须	1	1：卖光，0：未卖光
    /**
     * string	可选	2B86BE5A5C237 86232DE37A471 7E0D93
     * (由第一步获得的图片ID)	菜品图片ID（注意：①此处的图片ID由步骤1上传图片获得 ②更新菜品图片时必须更新图片URL），只支持jpg格式，图片需要小于1600*1200
     * sequence	int	可选	1	当前分类下的排序序号
     */
    private String picture;

    private Integer sequence;

    private List<Sku> skus;

    public String getApp_poi_code() {
        return app_poi_code;
    }

    public void setApp_poi_code(String app_poi_code) {
        this.app_poi_code = app_poi_code;
    }

    public String getApp_food_code() {
        return app_food_code;
    }

    public void setApp_food_code(String app_food_code) {
        this.app_food_code = app_food_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getMin_order_count() {
        return min_order_count;
    }

    public void setMin_order_count(Integer min_order_count) {
        this.min_order_count = min_order_count;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Float getBox_num() {
        return box_num;
    }

    public void setBox_num(Float box_num) {
        this.box_num = box_num;
    }

    public Double getBox_price() {
        return box_price;
    }

    public void setBox_price(Double box_price) {
        this.box_price = box_price;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Integer getIs_sold_out() {
        return is_sold_out;
    }

    public void setIs_sold_out(Integer is_sold_out) {
        this.is_sold_out = is_sold_out;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    @Override
    public String toString() {
        return "Food{" +
                "app_poi_code='" + app_poi_code + '\'' +
                ", app_food_code='" + app_food_code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", min_order_count=" + min_order_count +
                ", unit='" + unit + '\'' +
                ", box_num=" + box_num +
                ", box_price=" + box_price +
                ", category_name='" + category_name + '\'' +
                ", is_sold_out=" + is_sold_out +
                ", picture='" + picture + '\'' +
                ", sequence=" + sequence +
                ", skus=" + skus +
                '}';
    }
}
