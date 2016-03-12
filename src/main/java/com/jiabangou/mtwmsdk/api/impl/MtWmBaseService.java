package com.jiabangou.mtwmsdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.mtwmsdk.api.MtWmConfigStorage;
import com.jiabangou.mtwmsdk.exception.MtWmError;
import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.ArrayStack;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.*;

public class MtWmBaseService {

    public static final String API_URL = "http://waimaiopen.meituan.com/api/v1";
    public static final String TEST_API_URL = "http://test.waimaiopen.meituan.com/api/v1";
    public static final String UTF_8 = "UTF-8";

    protected MtWmConfigStorage mtWmConfigStorage;
    protected HttpHost httpProxy;
    protected CloseableHttpClient httpClient;
    protected boolean isTest;

    public MtWmBaseService(MtWmConfigStorage mtWmConfigStorage, CloseableHttpClient httpClient,
                           HttpHost httpProxy, boolean isTest) {
        this.mtWmConfigStorage = mtWmConfigStorage;
        this.httpClient = httpClient;
        this.httpProxy = httpProxy;
        this.isTest = isTest;
    }

    protected String getBaseApiUrl() {
        return isTest? TEST_API_URL:API_URL;
    }

    protected String createApiSignature(String url, Map params, int timestamp) {
        Map<String, Object> signMap = new HashMap<String, Object>(params);
        List<String> list = new ArrayList<String>(signMap.keySet());
        Collections.sort(list);
        StringBuilder stringBuilder = new StringBuilder(url);
        stringBuilder.append("?");
        for (int i = 0; i < list.size(); i++) {
            Object value = signMap.get(list.get(i));
            if (value != null) {
                stringBuilder.append(list.get(i)).append("=").append(value.toString());
                if (i < list.size() - 1) {
                    stringBuilder.append("&");
                }
            }
        }
        stringBuilder.append(mtWmConfigStorage.getSecret());
        return DigestUtils.md5Hex(stringBuilder.toString());
    }

    protected JSONObject doGet(String url) throws MtWmErrorException {
        return doGet(url, null);
    }

    protected JSONObject doGet(String url, Object params) throws MtWmErrorException {
        try {
            List<NameValuePair> nameValuePairs = getNameValuePairs(url, params);

            HttpGet httpGet = new HttpGet(url + "?" + URLEncodedUtils.format(nameValuePairs, UTF_8));
            setRequestConfig(httpGet);

            return getResponseJsonObject(httpGet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected JSONObject doPost(String url) throws MtWmErrorException {
        return doPost(url, null);
    }

    protected JSONObject doPost(String url, Object params) throws MtWmErrorException {
        try {
            List<NameValuePair> nameValuePairs = getNameValuePairs(url, params);

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, UTF_8));

            setRequestConfig(httpPost);
            return getResponseJsonObject(httpPost);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private JSONObject getResponseJsonObject(HttpUriRequest httpUriRequest) throws IOException, MtWmErrorException {
        CloseableHttpResponse response = this.httpClient.execute(httpUriRequest);
        String resultContent = new BasicResponseHandler().handleResponse(response);
        JSONObject jsonObject = JSON.parseObject(resultContent);
        MtWmError error = MtWmError.fromJson(jsonObject);
        if (error != null) {
            throw new MtWmErrorException(error.getErrorCode(), error.getErrorMsg());
        }
        return jsonObject;
    }

    private List<NameValuePair> getNameValuePairs(String url, Object params) {
        BeanMap beanMap = params != null ? new BeanMap(params) : new BeanMap();
        int timestamp = (int)System.currentTimeMillis() / 1000;
        beanMap.put("app_id", mtWmConfigStorage.getAppId());
        beanMap.put("timestamp", timestamp);
        beanMap.put("sig", createApiSignature(url, beanMap, timestamp));

        List<NameValuePair> nameValuePairs = new ArrayList<>();
        for (Map.Entry entry : beanMap.entrySet()) {
            nameValuePairs.add(new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString()));
        }
        return nameValuePairs;
    }

    private void setRequestConfig(HttpRequestBase httpRequestBase) {
        if (httpProxy != null) {
            httpRequestBase.setConfig(RequestConfig.custom().setProxy(httpProxy).build());
        }
    }

    protected <T> List<T> getList(JSONObject jsonObject, String key, Class<T> clazz) {
        JSONArray jsonArray = jsonObject.getJSONArray(key);
        List<T> list = new ArrayList<T>();
        for (Object obj : jsonArray) {
            list.add(TypeUtils.castToJavaBean(obj, clazz));
        }
        return list;
    }

}
