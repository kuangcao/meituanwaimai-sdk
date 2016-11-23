package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanglei on 16-11-23.
 */
public class FoodSkuStock implements Serializable {
    String app_food_code;
    private List<Sku> skus;

    public String getApp_food_code() {
        return app_food_code;
    }

    public void setApp_food_code(String app_food_code) {
        this.app_food_code = app_food_code;
    }

    public List<Sku> getSkus() {
        return skus;
    }

    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    @Override
    public String toString() {
        return "FoodSkuStock{" +
                "app_food_code='" + app_food_code + '\'' +
                ", skus=" + skus +
                '}';
    }
}
