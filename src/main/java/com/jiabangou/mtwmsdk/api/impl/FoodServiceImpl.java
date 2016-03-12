package com.jiabangou.mtwmsdk.api.impl;

import com.jiabangou.mtwmsdk.api.FoodService;
import com.jiabangou.mtwmsdk.api.MtWmConfigStorage;
import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.Food;
import com.jiabangou.mtwmsdk.model.FoodCategory;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * 菜品类API
 * Created by freeway on 16/3/12.
 */
public class FoodServiceImpl extends BaseServiceImpl implements FoodService {

    private static final String FOODCAT_UPDATE = "/foodCat/update";
    private static final String FOODCAT_DELETE = "/foodCat/delete";
    private static final String FOODCAT_LIST = "/foodCat/list";
    private static final String FOOD_SAVE = "/food/save";



    public FoodServiceImpl(MtWmConfigStorage mtWmConfigStorage, CloseableHttpClient httpClient, HttpHost httpProxy, boolean isTest) {
        super(mtWmConfigStorage, httpClient, httpProxy, isTest);
    }

    public void updateCategory(FoodCategory foodCategory) throws MtWmErrorException {
        doPost(getBaseApiUrl() + FOODCAT_UPDATE, foodCategory);
    }

    public void deleteCategory(String appPoiCode, String categoryName) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        params.put("category_name", categoryName);
        doPost(getBaseApiUrl() + FOODCAT_DELETE, params);
    }

    public List<FoodCategory> list(String appPoiCode) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        return getList(doGet(getBaseApiUrl() + FOODCAT_LIST, params), DATA, FoodCategory.class);
    }

    public void save(Food food) throws MtWmErrorException {
        doPost(getBaseApiUrl() + FOOD_SAVE, food);
    }

    public

}
