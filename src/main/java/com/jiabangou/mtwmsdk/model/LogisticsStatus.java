package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-9-29.
 */
public class LogisticsStatus implements Serializable {
    
    private long order_id; //25217, 订单ID

    private int logistics_status; //20, 配送订单状态code，详情请参考12.5.1节

    private String logistics_name; //private String 自建private String , 配送方名称

    private long send_time; //143254562350, 配送单下单时间

    private long confirm_time; //143254561110 , 配送单确认时间

    private long cancel_time; //143254562340, 配送单取消时间

    private long fetch_time; //143254562340, 骑手取单时间

    private long completed_time; //143254562340, 订单完成时间

    private String dispatcher_name; //143254562340, 骑手姓名

    private String dispatcher_mobile; //143254562340, 骑手电话

    private double poi_shipping_fee; //2, 商家承担运费

    private String shipping_tips; //private String 运费波动为xx元private String , 商家承担运费的具体说明

    private double tip_amount; //3.0, 商家给定的小费金额

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public int getLogistics_status() {
        return logistics_status;
    }

    public void setLogistics_status(int logistics_status) {
        this.logistics_status = logistics_status;
    }

    public String getLogistics_name() {
        return logistics_name;
    }

    public void setLogistics_name(String logistics_name) {
        this.logistics_name = logistics_name;
    }

    public long getSend_time() {
        return send_time;
    }

    public void setSend_time(long send_time) {
        this.send_time = send_time;
    }

    public long getConfirm_time() {
        return confirm_time;
    }

    public void setConfirm_time(long confirm_time) {
        this.confirm_time = confirm_time;
    }

    public long getCancel_time() {
        return cancel_time;
    }

    public void setCancel_time(long cancel_time) {
        this.cancel_time = cancel_time;
    }

    public long getFetch_time() {
        return fetch_time;
    }

    public void setFetch_time(long fetch_time) {
        this.fetch_time = fetch_time;
    }

    public long getCompleted_time() {
        return completed_time;
    }

    public void setCompleted_time(long completed_time) {
        this.completed_time = completed_time;
    }

    public String getDispatcher_name() {
        return dispatcher_name;
    }

    public void setDispatcher_name(String dispatcher_name) {
        this.dispatcher_name = dispatcher_name;
    }

    public String getDispatcher_mobile() {
        return dispatcher_mobile;
    }

    public void setDispatcher_mobile(String dispatcher_mobile) {
        this.dispatcher_mobile = dispatcher_mobile;
    }

    public double getPoi_shipping_fee() {
        return poi_shipping_fee;
    }

    public void setPoi_shipping_fee(double poi_shipping_fee) {
        this.poi_shipping_fee = poi_shipping_fee;
    }

    public String getShipping_tips() {
        return shipping_tips;
    }

    public void setShipping_tips(String shipping_tips) {
        this.shipping_tips = shipping_tips;
    }

    public double getTip_amount() {
        return tip_amount;
    }

    public void setTip_amount(double tip_amount) {
        this.tip_amount = tip_amount;
    }

    @Override
    public String toString() {
        return "LogisticsStatus{" +
                "order_id=" + order_id +
                ", logistics_status=" + logistics_status +
                ", logistics_name='" + logistics_name + '\'' +
                ", send_time=" + send_time +
                ", confirm_time=" + confirm_time +
                ", cancel_time=" + cancel_time +
                ", fetch_time=" + fetch_time +
                ", completed_time=" + completed_time +
                ", dispatcher_name='" + dispatcher_name + '\'' +
                ", dispatcher_mobile='" + dispatcher_mobile + '\'' +
                ", poi_shipping_fee=" + poi_shipping_fee +
                ", shipping_tips='" + shipping_tips + '\'' +
                ", tip_amount=" + tip_amount +
                '}';
    }
}
