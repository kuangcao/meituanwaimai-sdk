package com.jiabangou.mtwmsdk.model;

/**
 * Created by wanglei on 16-9-30.
 */
public interface NotifyType {
    /**
     * 发起退款
     */
    String APPLY = "apply";
    /**
     * 确认退款
     */
    String AGREE = "agree";
    /**
     * 驳回退款
     */
    String REJECT = "reject";
    /**
     * 用户取消退款申请
     */
    String CANCEL_REFUND = "cancelRefund";
    /**
     * 取消退款申诉
     */
    String CANCEL_REFUND_COMPLAINT = "cancelRefundComplaint";
}
