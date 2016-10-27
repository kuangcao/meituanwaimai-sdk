package com.jiabangou.mtwmsdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.mtwmsdk.api.LogListener;
import com.jiabangou.mtwmsdk.api.MtWmConfigStorage;
import com.jiabangou.mtwmsdk.api.OrderService;
import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.*;
import org.apache.http.HttpHost;
import org.apache.http.impl.client.CloseableHttpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanglei on 16-9-29.
 */
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {

    private static final String ORDER_POI_RECEIVED = "/order/poi_received";
    private static final String ORDER_CONFIRM = "/order/confirm";
    private static final String ORDER_CANCEL = "/order/cancel";
    private static final String ORDER_REFUND_AGREE = "/order/refund/agree";
    private static final String ORDER_REFUND_REJECT = "/order/refund/reject";
    private static final String ORDER_SUBSIDY = "/order/subsidy";
    private static final String ORDER_VIEW_STATUS = "/order/viewstatus";
    private static final String ORDER_GET_ACT_DETAIL_BY_AC_ID = "/order/getActDetailByAcId";
    private static final String ORDER_GET_ORDER_DETAIL = "/order/getOrderDetail";
    private static final String ORDER_LOGISTICS_PUSH = "/order/logistics/push";
    private static final String ORDER_LOGISTICS_CANCEL = "/order/logistics/cancel";
    private static final String ORDER_LOGISTICS_STATUS = "/order/logistics/status";
    private static final String ORDER_GET_ORDER_DAY_SEQ = "/order/getOrderDaySeq";
    private static final String ORDER_GET_ORDER_ID_BY_DAY_SEQ = "/order/getOrderIdByDaySeq";
    private static final String ORDER_COMMENT_ORDER = "/order/comment/order";
    private static final String ORDER_COMMENT_ADD_REPLY = "/order/comment/add_reply";
    private static final String ORDER_DELIVERING = "/order/delivering";
    private static final String ORDER_ARRIVED = "/order/arrived";

    public OrderServiceImpl(MtWmConfigStorage mtWmConfigStorage, CloseableHttpClient httpClient, HttpHost httpProxy,
                            LogListener listener, boolean isTest) {
        super(mtWmConfigStorage, httpClient, httpProxy, listener, isTest);
    }

    @Override
    public void received(String orderId) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("order_id", orderId);
        doGet(ORDER_POI_RECEIVED, params);
    }

    @Override
    public void confirm(String orderId) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("order_id", orderId);
        doGet(ORDER_CONFIRM, params);
    }

    @Override
    public void cancel(String orderId, int reasonCode, String reason) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("order_id", orderId);
        params.put("reason_code", String.valueOf(reasonCode));
        params.put("reason", reason);
        doGet(ORDER_CANCEL, params);
    }

    @Override
    public void agreeRefund(String orderId, String reason) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("order_id", orderId);
        params.put("reason", reason);
        doGet(ORDER_REFUND_AGREE, params);
    }

    @Override
    public void disagreeRefund(String orderId, String reason) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("order_id", orderId);
        params.put("reason", reason);
        doGet(ORDER_REFUND_REJECT, params);
    }

    @Override
    public OrderSubsidy subsidy(String orderId) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("order_id", orderId);
        JSONObject jsonObject = doGet(ORDER_SUBSIDY, params).getJSONObject(DATA);
        if(jsonObject.getString("extras") != null && !jsonObject.getString("extras").equals("")){
            jsonObject.put("extras", JSON.parseArray(jsonObject.getString("extras").replace("{}", "")));
        }
        return TypeUtils.castToJavaBean(jsonObject, OrderSubsidy.class);
    }

    @Override
    public int viewStatus(String orderId) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("order_id", orderId);
        return doGet(ORDER_VIEW_STATUS, params).getJSONObject(DATA).getIntValue("status");
    }

    @Override
    public OrderAct getActDetailByActId(String actDetailId) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("act_detail_id", actDetailId);
        JSONObject jsonObject = doGet(ORDER_GET_ACT_DETAIL_BY_AC_ID, params);
        return get(jsonObject, DATA, OrderAct.class);
    }

    @Override
    public OrderDetail getOrderDetail(String orderId, Short isMtLogistics) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("order_id", orderId);
        params.put("is_mt_logistics", String.valueOf(isMtLogistics));
        JSONObject jsonObject = doGet(ORDER_GET_ORDER_DETAIL, params).getJSONObject(DATA);
        if(jsonObject.getString("detail") != null && !jsonObject.getString("detail").equals("")){
            jsonObject.put("detail", JSON.parseArray(jsonObject.getString("detail")));
        }
        if(jsonObject.getString("extras") != null && !jsonObject.getString("extras").equals("")){
            jsonObject.put("extras", JSON.parseArray(jsonObject.getString("extras").replace("{}", "")));
        }
        return TypeUtils.castToJavaBean(jsonObject, OrderDetail.class);
    }

    @Override
    public void logisticsPush(String orderId) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("order_id", orderId);
        doGet(ORDER_LOGISTICS_PUSH, params);
    }

    @Override
    public void logisticsCancel(String orderId) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("order_id", orderId);
        doGet(ORDER_LOGISTICS_CANCEL, params);
    }

    @Override
    public LogisticsStatus getLogisticsStatus(String orderId) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("order_id", orderId);
        JSONObject jsonObject = doGet(ORDER_LOGISTICS_STATUS, params);
        return get(jsonObject, DATA, LogisticsStatus.class);
    }

    @Override
    public String getOrderDaySeq(String appPoiCode) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        return doGet(ORDER_GET_ORDER_DAY_SEQ, params).getJSONObject(DATA).getString("day_seq");
    }

    @Override
    public String getOrderIdByDaySeq(String appPoiCode, String dateTime, String daySeq) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("app_poi_code", appPoiCode);
        params.put("date_time", dateTime);
        params.put("day_seq", daySeq);
        return doGet(ORDER_GET_ORDER_ID_BY_DAY_SEQ, params).getJSONObject(DATA).getString("order_id");
    }

    @Override
    public Comment getOrderComment(String orderId) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("order_id", orderId);
        JSONObject jsonObject = doGet(ORDER_COMMENT_ORDER, params);
        return get(jsonObject, DATA, Comment.class);
    }

    @Override
    public void replyOrderComment(String orderId, String commentId, String content) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("order_id", orderId);
        params.put("comment_id", commentId);
        params.put("reply", content);
        doPost(ORDER_COMMENT_ADD_REPLY, params);
    }

    @Override
    public void delivering(String orderId, String courierName, String courierPhone) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("order_id", orderId);
        params.put("courier_name", courierName);
        params.put("courier_phone", courierPhone);
        doGet(ORDER_DELIVERING, params);
    }

    @Override
    public void arrived(String orderId) throws MtWmErrorException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("order_id", orderId);
        doGet(ORDER_ARRIVED, params);
    }
}
