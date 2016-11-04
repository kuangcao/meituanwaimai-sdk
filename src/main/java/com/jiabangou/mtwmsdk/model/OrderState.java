package com.jiabangou.mtwmsdk.model;

/**
 * Created by wanglei on 16-11-4.
 */
public interface OrderState {

    /**
     * 用户已提交订单
     */
    int ORDER_SUBMITED = 1;

    /**
     * 可推送到APP方平台也可推送到商家
     */
    int ORDER_CAN_PUSH = 2;

    /**
     * 商家已收到
     */
    int BUSINESS_RECEIVED = 3;

    /**
     * 商家已确认
     */
    int BUSINESS_CONFIRMED = 4;

    /**
     * 已配送
     */
    int DELIVERING = 6;

    /**
     * 已完成
     */
    int COMPLETED = 8;

    /**
     * 已取消
     */
    int CANCELED = 9;
}
