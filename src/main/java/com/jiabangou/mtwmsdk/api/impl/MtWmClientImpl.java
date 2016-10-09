package com.jiabangou.mtwmsdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.jiabangou.mtwmsdk.api.*;
import com.jiabangou.mtwmsdk.model.Order;
import com.jiabangou.mtwmsdk.model.ResultMessage;
import com.jiabangou.mtwmsdk.utils.MtWmUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;

import java.util.Map;

/**
 * Created by wanglei on 16-9-30.
 */
public class MtWmClientImpl implements MtWmClient {

    private MtWmConfigStorage configStorage;
    private LogListener logListener;
    private PushConsumer pushConsumer;

    private CloseableHttpClient httpClient;
    private HttpHost httpProxy;

    private FoodService foodService;
    private ShopService shopService;
    private OrderService orderService;
    private ShippingService shippingService;
    private ImageService imageService;

    private Boolean isTest = false;

    public void setConfigStorage(MtWmConfigStorage configStorage) {

        this.configStorage = configStorage;

        String http_proxy_host = configStorage.getHttp_proxy_host();
        int http_proxy_port = configStorage.getHttp_proxy_port();
        String http_proxy_username = configStorage.getHttp_proxy_username();
        String http_proxy_password = configStorage.getHttp_proxy_password();

        final HttpClientBuilder builder = HttpClients.custom();
        if (StringUtils.isNotBlank(http_proxy_host)) {
            // 使用代理服务器
            if (StringUtils.isNotBlank(http_proxy_username)) {
                // 需要用户认证的代理服务器
                CredentialsProvider credsProvider = new BasicCredentialsProvider();
                credsProvider.setCredentials(
                        new AuthScope(http_proxy_host, http_proxy_port),
                        new UsernamePasswordCredentials(http_proxy_username, http_proxy_password));
                builder
                        .setDefaultCredentialsProvider(credsProvider);
            }
            httpProxy = new HttpHost(http_proxy_host, http_proxy_port);
        }
        httpClient = builder.build();
    }

    @Override
    public void setLogListener(LogListener logListener) {
        this.logListener = logListener;
    }

    @Override
    public void setPushConsumer(PushConsumer pushConsumer) {
        this.pushConsumer = pushConsumer;
    }

    @Override
    public void setIsTest(Boolean isTest) {
        this.isTest = isTest;
    }

    @Override
    public ResultMessage pushHandle(String url, Map<String, String> params, String pushAction) {
        if (this.pushConsumer == null) {
            return new ResultMessage("pushConsumer does not implement");
        }
        String httpMethod = "";
        try {
            MtWmUtils.sigCheck(url, params, configStorage.getAppId(), configStorage.getSecret());
        } catch (Exception e) {
            logging(pushAction, httpMethod, false, JSON.toJSONString(params), e.getMessage());
            return new ResultMessage(e.getMessage());
        }
        if (PushConsumer.CREATE_ORDER.equals(pushAction)) {

            Order order = JSON.parseObject(JSON.toJSONString(params), Order.class);
            this.pushConsumer.createOrder(order);
            httpMethod = BaseServiceImpl.HTTP_METHOD_POST;

        } else if (PushConsumer.CONFIRMED_ORDER.equals(pushAction)) {

            Order order = JSON.parseObject(JSON.toJSONString(params), Order.class);
            this.pushConsumer.confirmedOrder(order);
            httpMethod = BaseServiceImpl.HTTP_METHOD_POST;

        } else if (PushConsumer.COMPLETED_ORDER.equals(pushAction)) {

            Order order = JSON.parseObject(JSON.toJSONString(params), Order.class);
            this.pushConsumer.completedOrder(order);
            httpMethod = BaseServiceImpl.HTTP_METHOD_POST;

        } else if (PushConsumer.CANCEL_ORDER.equals(pushAction)) {

            String orderId = params.get("order_id");
            String reasonCode = params.get("reason_code");
            String reason = params.get("reason");
            this.pushConsumer.cancelOrder(orderId, reasonCode, reason);
            httpMethod = BaseServiceImpl.HTTP_METHOD_GET;

        } else if (PushConsumer.REFUND_ORDER.equals(pushAction)) {

            String orderId = params.get("order_id");
            String notifyType = params.get("notify_type");
            String reason = params.get("reason");
            this.pushConsumer.refundOrder(orderId, notifyType, reason);
            httpMethod = BaseServiceImpl.HTTP_METHOD_GET;

        } else if (PushConsumer.LOGISTICS_STATUS.equals(pushAction)) {

            String orderId = params.get("order_id");
            Short statusCode = Short.valueOf(params.get("logistics_status"));
            String time = params.get("time");
            String dispatcherName = params.get("dispatcher_name");
            String dispatcherMobile = params.get("dispatcher_mobile");
            this.pushConsumer.deliveryStatus(orderId, statusCode, time, dispatcherName ,dispatcherMobile);
            httpMethod = BaseServiceImpl.HTTP_METHOD_POST;

        }
        logging(pushAction, httpMethod, true, JSON.toJSONString(params), JSON.toJSONString(ResultMessage.buildOk()));
        return ResultMessage.buildOk();
    }

    private void logging(String cmd, String method, boolean isSuccess, String request, String response) {
        if (logListener != null) {
            logListener.requestEvent(cmd, method, isSuccess, request, response);
        }
    }

    @Override
    public ShopService getShopService() {
        if (shopService == null) {
            shopService = new ShopServiceImplImpl(configStorage, httpClient, httpProxy, logListener, isTest);
        }
        return shopService;
    }

    @Override
    public ShippingService getShippingService() {
        if (shippingService == null) {
            shippingService = new ShippingServiceImpl(configStorage, httpClient, httpProxy, logListener, isTest);
        }
        return shippingService;
    }

    @Override
    public FoodService getDishService() {
        if (foodService == null) {
            foodService = new FoodServiceImpl(configStorage, httpClient, httpProxy, logListener, isTest);
        }
        return foodService;
    }

    @Override
    public OrderService getOrderService() {
        if (orderService == null) {
            orderService = new OrderServiceImpl(configStorage, httpClient, httpProxy, logListener, isTest);
        }
        return orderService;
    }

    @Override
    public ImageService getImageService() {
        if (imageService == null) {
            imageService = new ImageServiceImpl(configStorage, httpClient, httpProxy, logListener, isTest);
        }
        return imageService;
    }
}
