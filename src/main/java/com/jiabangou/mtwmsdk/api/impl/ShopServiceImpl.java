package com.jiabangou.mtwmsdk.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.jiabangou.mtwmsdk.api.MtWmConfigStorage;
import com.jiabangou.mtwmsdk.api.ShopService;
import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.Additional;
import com.jiabangou.mtwmsdk.model.Qualify;
import com.jiabangou.mtwmsdk.model.Shop;
import com.jiabangou.mtwmsdk.model.ShopTag;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ShopServiceImpl extends MtWmBaseService implements ShopService {

    private final static String POI_SAVE = "/poi/save";
    private final static String POI_GETIDS = "/poi/getids";
    private final static String POI_MGET = "/poi/mget";
    private final static String POI_OPEN = "/poi/open";
    private final static String POI_CLOSE = "/poi/close";
    private final static String POI_OFFLINE = "/poi/offline";
    private final static String POI_ONLINE = "/poi/online";
    private final static String POI_QUALIFY_SAVE = "/poi/qualify/save";
    private final static String POI_SENDTIME_SAVE = "/poi/sendtime/save";
    private final static String POI_ADDITIONAL_SAVE = "/poi/additional/save";
    private final static String POI_UPDATEPROMOTEINFO = "/poi/updatepromoteinfo";
    private final static String POITAG_LIST = "/poiTag/list";
    private final static String POI_SHIPPINGTIME_UPDATE = "/poi/shippingtime/update";

    public ShopServiceImpl(MtWmConfigStorage mtWmConfigStorage, CloseableHttpClient httpClient,
                           HttpHost httpProxy, boolean isTest) {
        super(mtWmConfigStorage, httpClient, httpProxy, isTest);
    }

    @Override
    public void save(Shop shop) throws MtWmErrorException {
        doPost(getBaseApiUrl() + POI_SAVE, shop);
    }

    @Override
    public List<Long> getIds() throws MtWmErrorException {
        JSONObject jsonObject = doGet(getBaseApiUrl() + POI_GETIDS);
        return getList(jsonObject, "data", Long.class);
    }

    @Override
    public List<Shop> gets(List<Long> appPoiCodes) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_codes", StringUtils.join(appPoiCodes, ","));
        JSONObject jsonObject = doGet(getBaseApiUrl() + POI_MGET, params);
        return getList(jsonObject, "data", Shop.class);
    }

    @Override
    public void open(String id) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", id);
        doPost(getBaseApiUrl() + POI_OPEN, params);
    }

    @Override
    public void close(String id) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", id);
        doPost(getBaseApiUrl() + POI_CLOSE, params);
    }

    @Override
    public void offline(String id, String reason) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", id);
        params.put("reason", reason);
        doPost(getBaseApiUrl() + POI_OFFLINE, params);
    }

    @Override
    public void online(String id) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", id);
        doPost(getBaseApiUrl() + POI_ONLINE, params);
    }

    @Override
    public void saveQualify(Qualify qualify) throws MtWmErrorException {
        doPost(getBaseApiUrl() + POI_QUALIFY_SAVE, qualify);
    }

    @Override
    public void saveSendtime(List<String> appPoiCodes, int sendTime) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_codes", StringUtils.join(appPoiCodes, ","));
        params.put("send_time", String.valueOf(sendTime));
        doPost(getBaseApiUrl() + POI_SENDTIME_SAVE, params);
    }

    @Override
    public void saveAdditional(Additional additional) throws MtWmErrorException {
        doPost(getBaseApiUrl() + POI_ADDITIONAL_SAVE, additional);
    }

    @Override
    public void updatePromote(String appPoiCode, String promotion) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        params.put("promotion_info", promotion);
        doPost(getBaseApiUrl() + POI_UPDATEPROMOTEINFO, params);
    }

    @Override
    public List<ShopTag> getShopTags() throws MtWmErrorException {
        JSONObject jsonObject = doGet(getBaseApiUrl() + POITAG_LIST);
        return getList(jsonObject, "data", ShopTag.class);
    }

    @Override
    public void updateShippingTime(String appPoiCode, String shippingTime) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        params.put("shipping_time", shippingTime);
        doPost(getBaseApiUrl() + POI_SHIPPINGTIME_UPDATE, params);
    }

}
