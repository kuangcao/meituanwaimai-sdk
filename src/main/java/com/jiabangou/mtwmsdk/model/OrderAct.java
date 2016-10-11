package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-9-29.
 */
public class OrderAct implements Serializable {

    private Long id;
    private Integer type;
    private String remark;
    private Long start_time;
    private Long end_time;
    private PoiPolicy poi_policy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getStart_time() {
        return start_time;
    }

    public void setStart_time(Long start_time) {
        this.start_time = start_time;
    }

    public Long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Long end_time) {
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

        private Double full_price;
        private String gift_name;
        private Double gift_price;
        private Double mt_charge;
        private Double poi_charge;

        public Double getFull_price() {
            return full_price;
        }

        public void setFull_price(Double full_price) {
            this.full_price = full_price;
        }

        public String getGift_name() {
            return gift_name;
        }

        public void setGift_name(String gift_name) {
            this.gift_name = gift_name;
        }

        public Double getGift_price() {
            return gift_price;
        }

        public void setGift_price(Double gift_price) {
            this.gift_price = gift_price;
        }

        public Double getMt_charge() {
            return mt_charge;
        }

        public void setMt_charge(Double mt_charge) {
            this.mt_charge = mt_charge;
        }

        public Double getPoi_charge() {
            return poi_charge;
        }

        public void setPoi_charge(Double poi_charge) {
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
