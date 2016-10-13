package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wanglei on 16-10-13.
 */
public class PoiReceiveDetail implements Serializable {

    private List<ActOrderCharge> actOrderChargeByMt; //美团承担明细
    private List<ActOrderCharge> actOrderChargeByPoi; //商家承担明细
    private Integer foodShareFeeChargeByPoi; //390 (菜品分成 (分)),
    private Integer logisticsFee; //300 (配送费 (分)),
    private Integer onlinePayment; //2000 (在线支付款 (分)),
    private Integer wmPoiReceiveCent; //1610 (商家应收款（分）)

    public List<ActOrderCharge> getActOrderChargeByMt() {
        return actOrderChargeByMt;
    }

    public void setActOrderChargeByMt(List<ActOrderCharge> actOrderChargeByMt) {
        this.actOrderChargeByMt = actOrderChargeByMt;
    }

    public List<ActOrderCharge> getActOrderChargeByPoi() {
        return actOrderChargeByPoi;
    }

    public void setActOrderChargeByPoi(List<ActOrderCharge> actOrderChargeByPoi) {
        this.actOrderChargeByPoi = actOrderChargeByPoi;
    }

    public Integer getFoodShareFeeChargeByPoi() {
        return foodShareFeeChargeByPoi;
    }

    public void setFoodShareFeeChargeByPoi(Integer foodShareFeeChargeByPoi) {
        this.foodShareFeeChargeByPoi = foodShareFeeChargeByPoi;
    }

    public Integer getLogisticsFee() {
        return logisticsFee;
    }

    public void setLogisticsFee(Integer logisticsFee) {
        this.logisticsFee = logisticsFee;
    }

    public Integer getOnlinePayment() {
        return onlinePayment;
    }

    public void setOnlinePayment(Integer onlinePayment) {
        this.onlinePayment = onlinePayment;
    }

    public Integer getWmPoiReceiveCent() {
        return wmPoiReceiveCent;
    }

    public void setWmPoiReceiveCent(Integer wmPoiReceiveCent) {
        this.wmPoiReceiveCent = wmPoiReceiveCent;
    }

    @Override
    public String toString() {
        return "PoiReceiveDetail{" +
                "actOrderChargeByMt=" + actOrderChargeByMt +
                ", actOrderChargeByPoi=" + actOrderChargeByPoi +
                ", foodShareFeeChargeByPoi=" + foodShareFeeChargeByPoi +
                ", logisticsFee=" + logisticsFee +
                ", onlinePayment=" + onlinePayment +
                ", wmPoiReceiveCent=" + wmPoiReceiveCent +
                '}';
    }

}
