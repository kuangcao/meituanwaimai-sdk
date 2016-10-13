package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-10-13.
 */
public class Extra implements Serializable {
    private Long act_detail_id; //10,(活动id)
    private Double reduce_fee; //2.5, (活动优惠金额，是美团承担活动费用和商户承担活动费用的总和)
    private Double mt_charge; //1.5, (优惠金额中美团承担的部分，可在开发者中心订阅，不订阅则不会推送)
    private Double poi_charge; //1.5, (优惠金额中商家承担的部分，可在开发者中心订阅，不订阅则不会推送)
    private String remark; //private String 满10元减2.5元private String ,（优惠说明）
    private Integer type; //1,活动类型）private String
    private Float avg_send_time; //5.5(餐厅平均送餐时间，单位为分钟)
    private Double rider_fee; // (骑手应付款，只对美团配送线上支付线下结算的商家有效，可在开发者中心订阅，不订阅则不会推送)

    public Long getAct_detail_id() {
        return act_detail_id;
    }

    public void setAct_detail_id(Long act_detail_id) {
        this.act_detail_id = act_detail_id;
    }

    public Double getReduce_fee() {
        return reduce_fee;
    }

    public void setReduce_fee(Double reduce_fee) {
        this.reduce_fee = reduce_fee;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Float getAvg_send_time() {
        return avg_send_time;
    }

    public void setAvg_send_time(Float avg_send_time) {
        this.avg_send_time = avg_send_time;
    }

    public Double getRider_fee() {
        return rider_fee;
    }

    public void setRider_fee(Double rider_fee) {
        this.rider_fee = rider_fee;
    }

    @Override
    public String toString() {
        return "Extra{" +
                "act_detail_id=" + act_detail_id +
                ", reduce_fee=" + reduce_fee +
                ", mt_charge=" + mt_charge +
                ", poi_charge=" + poi_charge +
                ", remark='" + remark + '\'' +
                ", type=" + type +
                ", avg_send_time=" + avg_send_time +
                ", rider_fee=" + rider_fee +
                '}';
    }
}
