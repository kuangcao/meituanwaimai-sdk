package com.jiabangou.mtwmsdk.api.impl;

import com.jiabangou.mtwmsdk.api.ImageService;
import com.jiabangou.mtwmsdk.api.LogListener;
import com.jiabangou.mtwmsdk.api.MtWmConfigStorage;
import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanglei on 16-9-30.
 */
public class ImageServiceImpl extends BaseServiceImpl implements ImageService {

    private static final String IMAGE_UPLOAD = "/image/upload";

    public ImageServiceImpl(MtWmConfigStorage mtWmConfigStorage, CloseableHttpClient httpClient, HttpHost httpProxy,
                            LogListener listener, boolean isTest) {
        super(mtWmConfigStorage, httpClient, httpProxy, listener, isTest);
    }

    @Override
    public String uploadImage(String appPoiCode, String imgName, Byte[] imgData) throws MtWmErrorException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("app_poi_code", appPoiCode);
        params.put("img_data", imgData);
        params.put("img_name", imgName);
        return doPost(IMAGE_UPLOAD, params).getString(DATA);
    }

    @Override
    public String uploadImage(String appPoiCode, String imgName, String imgUrl) throws MtWmErrorException {
        byte[] imageData = getImageData(imgUrl);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("app_poi_code", appPoiCode);
        params.put("img_name", imgName);
        return doPost(IMAGE_UPLOAD, params, imgName, imageData).getString(DATA);
    }

    public byte[] getImageData(String destUrl) {

        byte[] content = null;
        try {
            BufferedInputStream bis = null;
            ByteArrayOutputStream out = null;
            HttpURLConnection httpUrl = null;
            byte[] buf = new byte[2046];
            try {
                URL url = new URL(destUrl);
                httpUrl = (HttpURLConnection) url.openConnection();
                httpUrl.connect();
                bis = new BufferedInputStream(httpUrl.getInputStream());

                int len;
                out = new ByteArrayOutputStream();
                while ((len = bis.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                content = out.toByteArray();
            } finally {
                if (bis != null){
                    bis.close();
                }
                if (out != null){
                    out.close();
                }
                if (httpUrl != null){
                    httpUrl.disconnect();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}
