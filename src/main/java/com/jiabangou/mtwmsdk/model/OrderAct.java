package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-9-29.
 */
public class OrderAct implements Serializable {

    private long id;
    private int type;
    private String remark;
    private long start_time;
    private long end_time;
    private PoiPolicy poi_policy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getStart_time() {
        return start_time;
    }

    public void setStart_time(long start_time) {
        this.start_time = start_time;
    }

    public long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(long end_time) {
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
                "id=" + id +
                ", type=" + type +
                ", remark='" + remark + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", poi_policy=" + poi_policy +
                '}';
    }

    public class PoiPolicy implements Serializable {

        private double full_price;
        private String gift_name;
        private double gift_price;
        private double mt_charge;
        private double poi_charge;

        public double getFull_price() {
            return full_price;
        }

        public void setFull_price(double full_price) {
            this.full_price = full_price;
        }

        public String getGift_name() {
            return gift_name;
        }

        public void setGift_name(String gift_name) {
            this.gift_name = gift_name;
        }

        public double getGift_price() {
            return gift_price;
        }

        public void setGift_price(double gift_price) {
            this.gift_price = gift_price;
        }

        public double getMt_charge() {
            return mt_charge;
        }

        public void setMt_charge(double mt_charge) {
            this.mt_charge = mt_charge;
        }

        public double getPoi_charge() {
            return poi_charge;
        }

        public void setPoi_charge(double poi_charge) {
            this.poi_charge = poi_charge;
        }

        @Override
        public String toString() {
            return "PoiPolicy{" +
                    "full_price=" + full_price +
                    ", gift_name='" + gift_name + '\'' +
                    ", gift_price=" + gift_price +
                    ", mt_charge=" + mt_charge +
                    ", poi_charge=" + poi_charge +
                    '}';
        }
    }

}
