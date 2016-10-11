package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;

/**
 * Created by freeway on 16/3/12.
 */
public class FoodCategory implements Serializable {
    private String app_poi_code; //	string	是	25381	APP方门店id
    private String category_name_origin; //	string	更新时必须，新建时无须填写	美团定制饭1	原始的菜品分类名称
    private String category_name; //	string	是	美团定制饭2	新建的菜品分类名称
    private String sequence; //	int	添加时必须	1	菜品排序。数字越小，排名越靠前

    public String getApp_poi_code() {
        return app_poi_code;
    }

    public void setApp_poi_code(String app_poi_code) {
        this.app_poi_code = app_poi_code;
    }

    public String getCategory_name_origin() {
        return category_name_origin;
    }

    public void setCategory_name_origin(String category_name_origin) {
        this.category_name_origin = category_name_origin;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "FoodCategory{" +
                "app_poi_code='" + app_poi_code + '\'' +
                ", category_name_origin='" + category_name_origin + '\'' +
                ", category_name='" + category_name + '\'' +
                ", sequence='" + sequence + '\'' +
                '}';
    }
}
