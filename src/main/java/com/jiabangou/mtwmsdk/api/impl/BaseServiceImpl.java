package com.jiabangou.mtwmsdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.mtwmsdk.api.LogListener;
import com.jiabangou.mtwmsdk.api.MtWmConfigStorage;
import com.jiabangou.mtwmsdk.exception.MtWmError;
import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.*;

public class BaseServiceImpl {

    public static final String API_URL = "http://waimaiopen.meituan.com/api/v1";
    public static final String TEST_API_URL = "http://test.waimaiopen.meituan.com/api/v1";
    public static final String UTF_8 = "UTF-8";
    public static final String DATA = "data";
    public static final String HTTP_METHOD_GET = "GET";
    public static final String HTTP_METHOD_POST = "POST";
    protected MtWmConfigStorage mtWmConfigStorage;
    protected HttpHost httpProxy;
    protected CloseableHttpClient httpClient;
    protected LogListener logListener;
    protected boolean isTest;

    public BaseServiceImpl(MtWmConfigStorage mtWmConfigStorage, CloseableHttpClient httpClient,
                           HttpHost httpProxy, LogListener logListener, boolean isTest) {
        this.mtWmConfigStorage = mtWmConfigStorage;
        this.httpClient = httpClient;
        this.httpProxy = httpProxy;
        this.logListener = logListener;
        this.isTest = isTest;
    }

    private void logging(String cmd, String method, boolean isSuccess, String request, String response) {
        if (this.logListener != null) {
            this.logListener.requestEvent(cmd, method, isSuccess, request, response);
        }
    }

    protected String getBaseApiUrl() {
        return isTest ? TEST_API_URL : API_URL;
    }

    protected String createApiSignature(String url, Map params, int timestamp) {
        Map<String, Object> signMap = new HashMap<String, Object>(params);
        List<String> list = new ArrayList<String>(signMap.keySet());
        Collections.sort(list);
        StringBuilder stringBuilder = new StringBuilder(url);
        stringBuilder.append("?");
        for (int i = 0; i < list.size(); i++) {
            Object value = signMap.get(list.get(i));
            if (value instanceof byte[]) {
                continue;
            }
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
            return getResponseJsonObject(HTTP_METHOD_GET, url, params);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected JSONObject doPost(String url) throws MtWmErrorException {
        return doPost(url, null);
    }

    protected JSONObject doPost(String url, Object params) throws MtWmErrorException {
        try {
            return getResponseJsonObject(HTTP_METHOD_POST, url, params);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private JSONObject getResponseJsonObject(String httpMethod, String url, Object params) throws IOException, MtWmErrorException {

        HttpUriRequest httpUriRequest = null;
        String fullUrl = getBaseApiUrl() + url;
        List<NameValuePair> sysNameValuePairs = getSysNameValuePairs(fullUrl, params);
        List<NameValuePair> nameValuePairs = getNameValuePairs(params);
        if (HTTP_METHOD_GET.equals(httpMethod)) {
            sysNameValuePairs.addAll(nameValuePairs);
            HttpGet httpGet = new HttpGet(fullUrl + "?" + URLEncodedUtils.format(sysNameValuePairs, UTF_8));
            setRequestConfig(httpGet);
            httpUriRequest = httpGet;
        } else if (HTTP_METHOD_POST.equals(httpMethod)) {
            HttpPost httpPost = new HttpPost(fullUrl + "?" + URLEncodedUtils.format(sysNameValuePairs, UTF_8));
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, UTF_8));
            setRequestConfig(httpPost);
            httpUriRequest = httpPost;
        }

        CloseableHttpResponse response = this.httpClient.execute(httpUriRequest);
        String resultContent = new BasicResponseHandler().handleResponse(response);
        JSONObject jsonObject = JSON.parseObject(resultContent);
        MtWmError error = MtWmError.fromJson(jsonObject);
        if (error != null) {
            logging(url, httpMethod, false, httpUriRequest.getURI() + "\nBody:" + JSON.toJSONString(params), resultContent);
            throw new MtWmErrorException(error.getErrorCode(), error.getErrorMsg());
        }
        logging(url, httpMethod, true, httpUriRequest.getURI() + "\nBody:" + JSON.toJSONString(params), resultContent);
        return jsonObject;
    }

    protected JSONObject doPost(String url, Object params, String imageName, byte[] fileData) throws MtWmErrorException {
        try {
            return getResponseJsonObject(HTTP_METHOD_POST, url, params, imageName, fileData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private JSONObject getResponseJsonObject(String httpMethod, String url, Object params, String imageName, byte[] fileData) throws IOException, MtWmErrorException {

        String fullUrl = getBaseApiUrl() + url;

        List<NameValuePair> sysNameValuePairs = getSysNameValuePairs(fullUrl, params);
        List<NameValuePair> nameValuePairs = getNameValuePairs(params);
        HttpPost httpPost = new HttpPost(fullUrl + "?" + URLEncodedUtils.format(sysNameValuePairs, UTF_8));

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        for (NameValuePair p : nameValuePairs) {
            builder.addTextBody(p.getName(), p.getValue(), ContentType.TEXT_PLAIN.withCharset(UTF_8));
        }

        builder.addPart("img_data", new ByteArrayBody(fileData, imageName));

        final HttpEntity entity = builder.build();
        httpPost.addHeader(entity.getContentType());
        httpPost.setEntity(entity);


        CloseableHttpResponse response = this.httpClient.execute(httpPost);
        String resultContent = new BasicResponseHandler().handleResponse(response);
        JSONObject jsonObject = JSON.parseObject(resultContent);
        MtWmError error = MtWmError.fromJson(jsonObject);
        if (error != null) {
            logging(url, httpMethod, false, httpPost.getURI() + "\nBody:" + JSON.toJSONString(params), resultContent);
            throw new MtWmErrorException(error.getErrorCode(), error.getErrorMsg());
        }
        logging(url, httpMethod, true, httpPost.getURI() + "\nBody:" + JSON.toJSONString(params), resultContent);
        return jsonObject;
    }

    private List<NameValuePair> getSysNameValuePairs(String url, Object params){
        Map<String, String> beanMap = params != null ? getParamsMap(params) : new HashMap<>();
        int timestamp =(int) (System.currentTimeMillis() / 1000);
        beanMap.put("app_id", mtWmConfigStorage.getAppId());
        beanMap.put("timestamp", String.valueOf(timestamp));
        beanMap.put("sig", createApiSignature(url, beanMap, timestamp));

        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("app_id", beanMap.get("app_id")));
        nameValuePairs.add(new BasicNameValuePair("timestamp", beanMap.get("timestamp")));
        nameValuePairs.add(new BasicNameValuePair("sig", beanMap.get("sig")));
        return nameValuePairs;
    }

    private List<NameValuePair> getNameValuePairs(Object params) {

        Map<String, String> beanMap = params != null ? getParamsMap(params) : new HashMap<>();

        List<NameValuePair> nameValuePairs = new ArrayList<>();
        for (Map.Entry entry : beanMap.entrySet()) {
            nameValuePairs.add(new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString()));
        }
        return nameValuePairs;
    }

    protected Map<String, String> getParamsMap(Object obj) {

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(obj);
        final Map<String, String> params = new HashMap<>();
        jsonObject.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .forEach(entry ->
                        params.put(entry.getKey(), TypeUtils.castToString(entry.getValue()))
                );

        return params;
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

    protected <T> T get(JSONObject jsonObject, String key, Class<T> clazz) {
        JSONObject obj = jsonObject.getJSONObject(key);
        return TypeUtils.castToJavaBean(obj, clazz);
    }

}
