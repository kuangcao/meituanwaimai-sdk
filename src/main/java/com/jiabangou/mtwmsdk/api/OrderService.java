package com.jiabangou.mtwmsdk.api;

import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.*;

/**
 * Created by wanglei on 16-9-29.
 */
public interface OrderService {

    void received(String orderId) throws MtWmErrorException;

    void confirm(String orderId) throws MtWmErrorException;

    void cancel(String orderId, int reasonCode, String reason) throws MtWmErrorException;

    void agreeRefund(String orderId, String reason) throws MtWmErrorException;

    void disagreeRefund(String orderId, String reason) throws MtWmErrorException;

    OrderSubsidy subsidy(String orderId) throws MtWmErrorException;

    int viewStatus(String orderId) throws MtWmErrorException;

    OrderAct getActDetailByActId(String actDetailId) throws MtWmErrorException;

    OrderDetail getOrderDetail(String orderId, Short isMtLogistics) throws MtWmErrorException;

    void logisticsPush(String orderId) throws MtWmErrorException;

    void logisticsCancel(String orderId) throws MtWmErrorException;

    LogisticsStatus getLogisticsStatus(String orderId) throws MtWmErrorException;

    String getOrderDaySeq(String appPoiCode) throws MtWmErrorException;

    String getOrderIdByDaySeq(String appPoiCode, String dateTime, String daySeq) throws MtWmErrorException;

    Comment getOrderComment(String orderId) throws MtWmErrorException;

    void replyOrderComment(String orderId, String commentId, String content) throws MtWmErrorException;

    void delivering(String orderId, String courierName, String courierPhone) throws MtWmErrorException;

    void arrived(String orderId) throws MtWmErrorException;

}
