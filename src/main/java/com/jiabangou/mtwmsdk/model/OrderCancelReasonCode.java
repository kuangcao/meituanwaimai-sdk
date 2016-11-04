package com.jiabangou.mtwmsdk.model;

/**
 * Created by wanglei on 16-9-30.
 */
public interface OrderCancelReasonCode {

    /**
     * 系统取消，超时未确认
     */
    int  OVERTIME = 1001;

    /**
     * 系统取消，在线支付订单30分钟未支付
     */
    int NOT_PAID = 1002;

    /**
     * 用户取消，在线支付中取消
     */
    int USER_CANCEL_IN_PAID = 1101;

    /**
     * 用户取消，商家确认前取消
     */
    int USER_CANCEL_BEFORE_CONFIRM = 1102;

    /**
     * 用户取消，用户退款取消
     */
    int USER_REFUND = 1103;

    /**
     * 客服取消，用户下错单
     */
    int USER_DOWN_WRONG_ORDER = 1201;

    /**
     * 客服取消，用户测试
     */
    int USER_TEST = 1202;

    /**
     * 客服取消，重复订单
     */
    int REPEAT_ORDER = 1203;

    /**
     * 客服取消，其他原因
     */
    int SERVICE_CANCEL_OTHRE_REASON = 1204;

    /**
     * 其他原因
     */
    int OTHRE_REASON = 1301;

    /**
     * APP方商家超时接单
     */
    int BUSINESS_NOT_RECEIVE_ORDER = 2001;

    /**
     * APP方非顾客原因修改订单
     */
    int MODIFY_ORDER = 2002;

    /**
     * APP方非顾客原因取消订单
     */
    int APP_CANCEL = 2003;

    /**
     * APP方配送延迟
     */
    int DELIVERY_DELAY = 2004;

    /**
     * APP方售后投诉
     */
    int COMPLAINTS = 2005;

    /**
     * APP方用户要求取消
     */
    int APP_USER_CANCEL = 2006;

    /**
     * APP方其他原因取消（未传code，默认为此原因）
     */
    int APP_OTHER_REASON = 2007;

}
