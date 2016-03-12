package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;

public class Additional implements Serializable {
    private String app_poi_code;//	string	是	25381	APP方门店id
    private String app_poi_email;//	string	否	yinchao@sina.com	门店email
    private String app_brand_code;//	string	否	kfc	第三方品牌code值（对接的三方需要提前将该值告诉美团开发人员）
    private String app_org_id; //	string	否	11213	门店的法人企业（门店的财务结算等均由与之关联的结算企业信息决定，对接的三方需要提前将该值告诉美团对接商务）

    public String getApp_poi_code() {
        return app_poi_code;
    }

    public void setApp_poi_code(String app_poi_code) {
        this.app_poi_code = app_poi_code;
    }

    public String getApp_poi_email() {
        return app_poi_email;
    }

    public void setApp_poi_email(String app_poi_email) {
        this.app_poi_email = app_poi_email;
    }

    public String getApp_brand_code() {
        return app_brand_code;
    }

    public void setApp_brand_code(String app_brand_code) {
        this.app_brand_code = app_brand_code;
    }

    public String getApp_org_id() {
        return app_org_id;
    }

    public void setApp_org_id(String app_org_id) {
        this.app_org_id = app_org_id;
    }

    @Override
    public String toString() {
        return "Additional{" +
                "app_poi_code='" + app_poi_code + '\'' +
                ", app_poi_email='" + app_poi_email + '\'' +
                ", app_brand_code='" + app_brand_code + '\'' +
                ", app_org_id='" + app_org_id + '\'' +
                '}';
    }
}
