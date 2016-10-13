package com.jiabangou.mtwmsdk.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
 * Created by freeway on 16/7/19.
 */
public class MtWmUtils {

    public static void sigCheck(String url, Map<String, String> params, String appId, String secret) {
        SigPart sigPart = getSigPart(url, params);
        if (sigPart.getSig() == null) {
            throw new RuntimeException("sig is required");
        }
        Map<String, String> signParams = sigPart.getSignRelationParams();
        if (!signParams.containsKey("timestamp")) {
            throw new RuntimeException("timestamp is required");
        }
        if (!signParams.containsKey("app_id")) {
            throw new RuntimeException("app_id is required");
        }
        if (!appId.equals(signParams.get("app_id"))) {
            throw new RuntimeException("app_id is incorrect");
        }

        List<String> sortParams = new ArrayList<>();
        for(Map.Entry entry: signParams.entrySet()){
            try {
                String sortParam = entry.getKey() + "=" + URLDecoder.decode(String.valueOf(entry.getValue()), "utf-8");
                sortParams.add(sortParam);
            } catch (UnsupportedEncodingException e){
                throw new RuntimeException("data decode incorrect");
            }
        }

        String signature = DigestUtils.md5Hex(sigPart.getUrl() + "?" + StringUtils.join(sortParams, "&") + secret);

        if (!signature.equals(sigPart.getSig())) {
            throw new RuntimeException("sig is incorrect");
        }
    }

    private static SigPart getSigPart(String url, Map<String, String> params) {
        if (!url.contains("?")) {
            Map<String, String> signParams = new HashMap<>();
            signParams.putAll(params);
            String sig = signParams.remove("sig");
            SigPart sigPart = new SigPart();
            sigPart.setSig(sig);
            sigPart.setSignRelationParams(signParams);
            sigPart.setUrl(url);
            return sigPart;
        }
        String noQueryUrl = url.substring(0, url.indexOf("?"));
        String queryString = url.substring(url.indexOf("?") + 1, url.length());
        Map<String, String> signParams = new HashMap<>();
        String sig = null;
        List<String> queryParts = Arrays.asList(StringUtils.split(queryString, "&"));
        for (String queryPart : queryParts) {
            String[] kv = queryPart.split("=");
            if ("sig".equals(kv[0])) {
                sig = kv[1];
            } else {
                signParams.put(kv[0], kv[1]);
            }
        }
        signParams.putAll(params);
        SigPart sigPart = new SigPart();
        sigPart.setSig(sig);
        sigPart.setSignRelationParams(signParams);
        sigPart.setUrl(noQueryUrl);
        return sigPart;
    }


    public static class SigPart implements Serializable {
        Map<String, String> signRelationParams;
        String sig;
        String url;

        public Map<String, String> getSignRelationParams() {
            return signRelationParams;
        }

        public void setSignRelationParams(Map<String, String> signRelationParams) {
            this.signRelationParams = signRelationParams;
        }

        public String getSig() {
            return sig;
        }

        public void setSig(String sig) {
            this.sig = sig;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "SigPart{" +
                    "signRelationParams=" + signRelationParams +
                    ", sig='" + sig + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

}
