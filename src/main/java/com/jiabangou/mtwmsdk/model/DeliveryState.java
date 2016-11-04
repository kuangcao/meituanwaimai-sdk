package com.jiabangou.mtwmsdk.model;

/**
 * Created by wanglei on 16-11-4.
 */
public interface DeliveryState {

    /**
     * 配送单发往配送
     */
    int DELIVERY_ORDER_SEND = 0;

    /**
     * 配送单已确认
     */
    int DELIVERY_ORDER_CONFIRM = 10;

    /**
     * 配送单已取消
     */
    int DELIVERY_ORDER_CANCEL = 100;

    /**
     * 骑手已取餐
     */
    int RIDER_TAKED_MEAL = 20;

    /**
     * 骑手已送达
     */
    int RIDER_ARRIVED = 40;

}
