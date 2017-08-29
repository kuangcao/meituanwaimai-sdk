package com.jiabangou.mtwmsdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.mtwmsdk.api.FoodService;
import com.jiabangou.mtwmsdk.api.LogListener;
import com.jiabangou.mtwmsdk.api.MtWmConfigStorage;
import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.Food;
import com.jiabangou.mtwmsdk.model.FoodCategory;
import com.jiabangou.mtwmsdk.model.FoodCategoryDetail;
import com.jiabangou.mtwmsdk.model.FoodSkuStock;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.ArrayList;
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
    private static final String FOOD_INITDATA = "/food/initdata";
    private static final String FOOD_DELETE = "/food/delete";
    private static final String FOOD_LIST = "/food/list";
    private static final String FOOD_UPDATE_STOCK = "/food/sku/stock";
    private static final String FOOD_SKU_SELLSTATUS = "food/sku/sellStatus";

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

    public List<FoodCategoryDetail> list(String appPoiCode) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        return getList(doGet(FOODCAT_LIST, params), DATA, FoodCategoryDetail.class);
    }

    public void save(Food food) throws MtWmErrorException {
        doPost(FOOD_SAVE, food);
    }

    @Override
    public void initdata(Food food) throws MtWmErrorException {
        doPost(FOOD_INITDATA, food);
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
        JSONArray jsonArray = jsonObject.getJSONArray(DATA);
        List<Food> list = new ArrayList<Food>();
        for (Object obj : jsonArray) {
            JSONObject jsonObjectTemp = (JSONObject) obj;
            if(jsonObjectTemp.getString("skus") != null && !jsonObjectTemp.getString("skus").equals("")){
                jsonObjectTemp.put("skus", JSON.parseArray(jsonObjectTemp.getString("skus")));
            }
            list.add(TypeUtils.castToJavaBean(jsonObjectTemp, Food.class));
        }
        return list;
    }

    @Override
    public void updateSkuStock(String appPoiCode, List<FoodSkuStock> foodSkuStocks) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        params.put("food_data", JSONArray.toJSONString(foodSkuStocks));
        doPost(FOOD_UPDATE_STOCK, params);
    }

    @Override
    public void skuSellStatus(String appPoiCode, List<FoodSkuStock> foodSkuStocks, int sellStatus) throws MtWmErrorException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("app_poi_code", appPoiCode);
        params.put("food_data", JSONArray.toJSONString(foodSkuStocks));
        params.put("sell_status",sellStatus);
        doPost(FOOD_SKU_SELLSTATUS, params);
    }

}
