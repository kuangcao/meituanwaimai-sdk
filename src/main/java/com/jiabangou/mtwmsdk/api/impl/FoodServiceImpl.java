package com.jiabangou.mtwmsdk.api.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiabangou.mtwmsdk.api.FoodService;
import com.jiabangou.mtwmsdk.api.LogListener;
import com.jiabangou.mtwmsdk.api.MtWmConfigStorage;
import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.Food;
import com.jiabangou.mtwmsdk.model.FoodCategory;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜品类API
 * Created by freeway on 16/3/12.
 */
public class FoodServiceImpl extends BaseServiceImpl implements FoodService {

    private static final String FOODCAT_UPDATE = "/foodCat/update";
    private static final String FOODCAT_DELETE = "/foodCat/delete";
    private static final String FOODCAT_LIST = "/foodCat/list";
    private static final String FOOD_SAVE = "/food/save";
    private static final String FOOD_DELETE = "/food/delete";
    private static final String FOOD_LIST = "/food/list";

    public FoodServiceImpl(MtWmConfigStorage mtWmConfigStorage, CloseableHttpClient httpClient, HttpHost httpProxy,
                           LogListener listener,  boolean isTest) {
        super(mtWmConfigStorage, httpClient, httpProxy, listener, isTest);
    }

    public void updateCategory(FoodCategory foodCategory) throws MtWmErrorException {
        doPost(FOODCAT_UPDATE, foodCategory);
    }

    public void deleteCategory(String appPoiCode, String categoryName) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        params.put("category_name", categoryName);
        doPost(FOODCAT_DELETE, params);
    }

    public List<FoodCategory> list(String appPoiCode) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        return getList(doGet(FOODCAT_LIST, params), DATA, FoodCategory.class);
    }

    public void save(Food food) throws MtWmErrorException {
        doPost(FOOD_SAVE, food);
    }

    public void batchSave(String appPoiCode, List<Food> foods) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        params.put("food_data", JSONArray.toJSONString(foods));
        doPost(FOOD_DELETE, params);
    }

    public void delete(String appPoiCode, String appFoodCode) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        params.put("app_food_code", appFoodCode);
        doPost(FOOD_DELETE, params);
    }

    public List<Food> gets(String appPoiCode) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        JSONObject jsonObject = doPost(FOOD_LIST, params);
        return getList(jsonObject, DATA, Food.class);
    }

}
