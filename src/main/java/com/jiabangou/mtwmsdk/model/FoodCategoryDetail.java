package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-10-11.
 */
public class FoodCategoryDetail implements Serializable {

    private String app_poi_code;

    private String name;

    private String sequence;

    private Long ctime;

    private Long utime;

    public String getApp_poi_code() {
        return app_poi_code;
    }

    public void setApp_poi_code(String app_poi_code) {
        this.app_poi_code = app_poi_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Long getUtime() {
        return utime;
    }

    public void setUtime(Long utime) {
        this.utime = utime;
    }

    @Override
    public String toString() {
        return "FoodCategoryDetail{" +
                "app_poi_code='" + app_poi_code + '\'' +
                ", name='" + name + '\'' +
                ", sequence='" + sequence + '\'' +
                ", ctime=" + ctime +
                ", utime=" + utime +
                '}';
    }
}
