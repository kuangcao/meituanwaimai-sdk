package com.jiabangou.mtwmsdk.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.jiabangou.mtwmsdk.api.LogListener;
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
import java.util.List;
import java.util.Map;

public class ShopServiceImplImpl extends BaseServiceImpl implements ShopService {

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

    public ShopServiceImplImpl(MtWmConfigStorage mtWmConfigStorage, CloseableHttpClient httpClient,
                               HttpHost httpProxy, LogListener listener, boolean isTest) {
        super(mtWmConfigStorage, httpClient, httpProxy, listener, isTest);
    }

    @Override
    public void save(Shop shop) throws MtWmErrorException {
        doPost(POI_SAVE, shop);
    }

    @Override
    public List<String> getIds() throws MtWmErrorException {
        JSONObject jsonObject = doGet(POI_GETIDS);
        return getList(jsonObject, "data", String.class);
    }

    @Override
    public List<Shop> gets(List<Long> appPoiCodes) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_codes", StringUtils.join(appPoiCodes, ","));
        JSONObject jsonObject = doGet(POI_MGET, params);
        return getList(jsonObject, "data", Shop.class);
    }

    @Override
    public void open(String id) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", id);
        doPost(POI_OPEN, params);
    }

    @Override
    public void close(String id) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", id);
        doPost(POI_CLOSE, params);
    }

    @Override
    public void offline(String id, String reason) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", id);
        params.put("reason", reason);
        doPost(POI_OFFLINE, params);
    }

    @Override
    public void online(String id) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", id);
        doPost(POI_ONLINE, params);
    }

    @Override
    public void saveQualify(Qualify qualify) throws MtWmErrorException {
        doPost(POI_QUALIFY_SAVE, qualify);
    }

    @Override
    public void saveSendtime(List<String> appPoiCodes, int sendTime) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_codes", StringUtils.join(appPoiCodes, ","));
        params.put("send_time", String.valueOf(sendTime));
        doPost(POI_SENDTIME_SAVE, params);
    }

    @Override
    public void saveAdditional(Additional additional) throws MtWmErrorException {
        doPost(POI_ADDITIONAL_SAVE, additional);
    }

    @Override
    public void updatePromote(String appPoiCode, String promotion) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        params.put("promotion_info", promotion);
        doPost(POI_UPDATEPROMOTEINFO, params);
    }

    @Override
    public List<ShopTag> getShopTags() throws MtWmErrorException {
        JSONObject jsonObject = doGet(POITAG_LIST);
        return getList(jsonObject, "data", ShopTag.class);
    }

    @Override
    public void updateShippingTime(String appPoiCode, String shippingTime) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        params.put("shipping_time", shippingTime);
        doPost(POI_SHIPPINGTIME_UPDATE, params);
    }

}
