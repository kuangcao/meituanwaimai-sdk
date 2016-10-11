package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;

public class Qualify implements Serializable {

    private String app_poi_code; //	string	是	12233	APP方门店id
    private Integer type; //	int	是	1	资质证照的类型（1：营业执照；2：餐饮服务许可证；3：健康证；4：法人身份证）
    private String qualification_url; //	string	是	http://p1.meituan.net/crm/__37375183__1582979.jpg	资质图片地址（门店资质只能上传一张，必须为jpg格式，图片大小不能超过10M，分辨率需要在1024*768以上，1600*1200以下，推荐1600*1200，否则审核会不通过）
    private String valid_date;//	string	否	2015-01-01	资质证照的有效期截止日，必须符合yyyy-MM-dd的格式
    private String address;//	string	否	天安门	经营地址
    private String number; //	string	否	11019123	证照编号

    public String getApp_poi_code() {
        return app_poi_code;
    }

    public void setApp_poi_code(String app_poi_code) {
        this.app_poi_code = app_poi_code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getQualification_url() {
        return qualification_url;
    }

    public void setQualification_url(String qualification_url) {
        this.qualification_url = qualification_url;
    }

    public String getValid_date() {
        return valid_date;
    }

    public void setValid_date(String valid_date) {
        this.valid_date = valid_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Qualify{" +
                "app_poi_code='" + app_poi_code + '\'' +
                ", type=" + type +
                ", qualification_url='" + qualification_url + '\'' +
                ", valid_date='" + valid_date + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
