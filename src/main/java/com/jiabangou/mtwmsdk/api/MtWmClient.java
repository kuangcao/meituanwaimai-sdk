package com.jiabangou.mtwmsdk.api;

import com.jiabangou.mtwmsdk.model.ResultMessage;

import java.util.Map;

public interface MtWmClient {

    void setConfigStorage(MtWmConfigStorage mtWmConfigStorage);

    void setLogListener(LogListener logListener);

    void setPushConsumer(PushConsumer pushConsumer);

    void setIsTest(Boolean isTest);

    /**
     * 用于接收获取到的json字符串
     *
     * @return
     */
    ResultMessage pushHandle(String url, Map<String, String> params, String pushAction);

    /**
     * 获取门店服务
     *
     * @return
     */
    ShopService getShopService();

    /**
     * 获取配送信息服务
     *
     * @return
     */
    ShippingService getShippingService();

    /**
     * 获取菜品服务
     *
     * @return
     */
    FoodService getFoodService();

    /**
     * 获取订单服务
     *
     * @return
     */
    OrderService getOrderService();

    /**
     * 获取图片服务
     *
     * @return
     */
    ImageService getImageService();

}
