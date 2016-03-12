package com.jiabangou.mtwmsdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiabangou.mtwmsdk.api.MtWmConfigStorage;
import com.jiabangou.mtwmsdk.api.ShippingService;
import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.Shipping;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;

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


    public ShippingServiceImpl(MtWmConfigStorage mtWmConfigStorage, CloseableHttpClient httpClient, HttpHost httpProxy, boolean isTest) {
        super(mtWmConfigStorage, httpClient, httpProxy, isTest);
    }

    @Override
    public void save(String appPoiCode, Shipping shipping) throws MtWmErrorException {
        JSONObject jsonObject = (JSONObject)JSON.toJSON(shipping);
        jsonObject.put("app_poi_code", appPoiCode);
        doPost(getBaseApiUrl() + SHIPPING_SAVE, jsonObject);
    }

    @Override
    public List<Shipping> getsByAppPoiCode(String appPoiCode) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        List<Shipping> shippings = getList(doGet(getBaseApiUrl() + SHIPPING_LIST, params), DATA, Shipping.class);
        return shippings;
    }

    @Override
    public void batchSave(String appPoiCode, List<Shipping> shippings) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        params.put("shipping_data", JSON.toJSON(shippings).toString());
        doPost(getBaseApiUrl() + SHIPPING_BATCHSAVE, params);
    }

}
