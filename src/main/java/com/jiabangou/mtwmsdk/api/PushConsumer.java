package com.jiabangou.mtwmsdk.api;

import com.jiabangou.mtwmsdk.model.OrderDetail;

/**
 * 推送处理接口, 需要业务自己实现推送后的处理
 * Created by freeway on 16/7/19.
 */
public interface PushConsumer {

    String CREATE_ORDER = "create_order";
    String CONFIRMED_ORDER = "confirmed_order";
    String COMPLETED_ORDER = "completed_order";
    String CANCEL_ORDER = "cancel_order";
    String REFUND_ORDER = "refund_order";
    String LOGISTICS_STATUS = "logistics_status";


    void createOrder(OrderDetail orderDetail);

    void confirmedOrder(OrderDetail orderDetail);

    void completedOrder(OrderDetail orderDetail);

    void cancelOrder(String orderId, String reasonCode, String reason);

    void refundOrder(String orderId, String notifyType, String reason);

    void deliveryStatus(String orderId, Short statusCode, String time, String dispatcherName, String dispatcherMobile);
}
