package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-9-29.
 */
public class OrderAct implements Serializable {

    private String id;
    private String type;
    private String remark;
    private String start_time;
    private String end_time;
    private PoiPolicy poi_policy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public PoiPolicy getPoi_policy() {
        return poi_policy;
    }

    public void setPoi_policy(PoiPolicy poi_policy) {
        this.poi_policy = poi_policy;
    }

    @Override
    public String toString() {
        return "OrderAct{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", poi_policy=" + poi_policy +
                '}';
    }

    public class PoiPolicy implements Serializable {

        private String full_price;
        private String gift_name;
        private String gift_price;
        private String mt_charge;
        private String poi_charge;

        public String getFull_price() {
            return full_price;
        }

        public void setFull_price(String full_price) {
            this.full_price = full_price;
        }

        public String getGift_name() {
            return gift_name;
        }

        public void setGift_name(String gift_name) {
            this.gift_name = gift_name;
        }

        public String getGift_price() {
            return gift_price;
        }

        public void setGift_price(String gift_price) {
            this.gift_price = gift_price;
        }

        public String getMt_charge() {
            return mt_charge;
        }

        public void setMt_charge(String mt_charge) {
            this.mt_charge = mt_charge;
        }

        public String getPoi_charge() {
            return poi_charge;
        }

        public void setPoi_charge(String poi_charge) {
            this.poi_charge = poi_charge;
        }

        @Override
        public String toString() {
            return "poiPolicy{" +
                    "full_price='" + full_price + '\'' +
                    ", gift_name='" + gift_name + '\'' +
                    ", gift_price='" + gift_price + '\'' +
                    ", mt_charge='" + mt_charge + '\'' +
                    ", poi_charge='" + poi_charge + '\'' +
                    '}';
        }
    }

}
