package com.jiabangou.mtwmsdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.mtwmsdk.api.LogListener;
import com.jiabangou.mtwmsdk.api.MtWmConfigStorage;
import com.jiabangou.mtwmsdk.api.ShippingService;
import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.Shipping;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配送范围类API
 * Created by freeway on 16/3/12.
 */
public class ShippingServiceImpl extends BaseServiceImpl implements ShippingService {

    private static final String SHIPPING_SAVE = "/shipping/save";
    private static final String SHIPPING_LIST = "/shipping/list";
    private static final String SHIPPING_BATCHSAVE = "/shipping/batchsave";

    public ShippingServiceImpl(MtWmConfigStorage mtWmConfigStorage, CloseableHttpClient httpClient, HttpHost httpProxy,
                               LogListener listener, boolean isTest) {
        super(mtWmConfigStorage, httpClient, httpProxy, listener, isTest);
    }

    @Override
    public void save(String appPoiCode, Shipping shipping) throws MtWmErrorException {
        JSONObject jsonObject = (JSONObject)JSON.toJSON(shipping);
        JSONArray jsonAreaArray = jsonObject.getJSONArray("area");
        for(Object object : jsonAreaArray){
            JSONObject jsonObjectTemp = (JSONObject)JSON.toJSON(object);
            jsonObjectTemp.put("x", jsonObjectTemp.getString("x").replace(".", ""));
            jsonObjectTemp.put("y", jsonObjectTemp.getString("y").replace(".", ""));
        }
        doPost(SHIPPING_SAVE, jsonObject);
    }

    @Override
    public List<Shipping> getsByAppPoiCode(String appPoiCode) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        JSONArray jsonArray = doGet(SHIPPING_LIST, params).getJSONArray(DATA);
        List<Shipping> list = new ArrayList<Shipping>();
        for (Object obj : jsonArray) {
            JSONObject jsonObjectTemp = (JSONObject) obj;
            jsonObjectTemp.put("area", JSON.parseArray(jsonObjectTemp.getString("area")));
            JSONArray jsonAreaArray = jsonObjectTemp.getJSONArray("area");
            for(Object object : jsonAreaArray){
                JSONObject jsonAreaObjectTemp = (JSONObject)JSON.toJSON(object);
                String x = jsonAreaObjectTemp.getString("x");
                String y = jsonAreaObjectTemp.getString("y");
                jsonAreaObjectTemp.put("x", x.substring(0,2) + "." + x.substring(2, x.length()));
                jsonAreaObjectTemp.put("y", y.substring(0,2) + "." + y.substring(2, y.length()));
            }
            list.add(TypeUtils.castToJavaBean(jsonObjectTemp, Shipping.class));
        }
        return list;
    }

    @Override
    public void batchSave(String appPoiCode, List<Shipping> shippings) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        params.put("shipping_data", JSON.toJSON(shippings).toString());
        doPost(SHIPPING_BATCHSAVE, params);
    }

}
