package com.jiabangou.mtwmsdk.model;

/**
 * Created by wanglei on 16-11-4.
 */
public interface DeliveryMode {


    /**
     * 商家自配
     */
    String BUSINESS_SELF = "0000";

    /**
     * 趣活
     */
    String QU_HUO = "0002";

    /**
     * 达达
     */
    String DA_DA = "0016";

    /**
     * E代送
     */
    String E_DAI_SONG = "0033";

    /**
     * 美团专送-加盟
     */
    String MEITUAN_LEAGUE = "1001";

    /**
     * 美团专送-自建
     */
    String MEITUAN_SELF = "1002";

    /**
     * 美团配送-众包
     */
    String MEITUAN_CROWDSOURCING = "1003";

    /**
     * 美团专送-城市代理
     */
    String MEITUAN_CITY_AGENT = "1004";

    /**
     * 角马
     */
    String JIAO_MA = "2001";

    /**
     * 快送
     */
    String FAST_DELIVERY = "2002";

}
