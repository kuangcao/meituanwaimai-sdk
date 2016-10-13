package com.jiabangou.mtwmsdk.model;

import java.io.Serializable;

/**
 * Created by wanglei on 16-10-13.
 */
public class ActOrderCharge implements Serializable {

    private String comment; //private String 美团配送减3.0元private String  (备注),
    private String feeTypeDesc; //private String 活动款private String  (明细费用类型描述),
    private Long feeTypeId; //10019 (明细费用类型Id),
    private Integer moneyCent; //300 (明细金额（分）)

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getFeeTypeDesc() {
        return feeTypeDesc;
    }

    public void setFeeTypeDesc(String feeTypeDesc) {
        this.feeTypeDesc = feeTypeDesc;
    }

    public Long getFeeTypeId() {
        return feeTypeId;
    }

    public void setFeeTypeId(Long feeTypeId) {
        this.feeTypeId = feeTypeId;
    }

    public Integer getMoneyCent() {
        return moneyCent;
    }

    public void setMoneyCent(Integer moneyCent) {
        this.moneyCent = moneyCent;
    }

    @Override
    public String toString() {
        return "ActOrderCharge{" +
                "comment='" + comment + '\'' +
                ", feeTypeDesc='" + feeTypeDesc + '\'' +
                ", feeTypeId=" + feeTypeId +
                ", moneyCent=" + moneyCent +
                '}';
    }
}
