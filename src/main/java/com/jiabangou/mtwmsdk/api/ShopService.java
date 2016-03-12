package com.jiabangou.mtwmsdk.api;

import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.Additional;
import com.jiabangou.mtwmsdk.model.Qualify;
import com.jiabangou.mtwmsdk.model.Shop;
import com.jiabangou.mtwmsdk.model.ShopTag;

import java.util.List;

public interface ShopService {

    /**
     * 
     * @param shop
     * @throws MtWmErrorException
     */
    void save(Shop shop) throws MtWmErrorException;

    List<Long> getIds() throws MtWmErrorException;

    List<Shop> gets(List<Long> appPoiCodes) throws MtWmErrorException;

    void open(String id) throws MtWmErrorException;

    void close(String id) throws MtWmErrorException;

    void offline(String id, String reason) throws MtWmErrorException;

    void online(String id) throws MtWmErrorException;

    void saveQualify(Qualify qualify) throws MtWmErrorException;

    void saveSendtime(List<String> appPoiCodes, int sendTime) throws MtWmErrorException;

    void saveAdditional(Additional additional) throws MtWmErrorException;

    void updatePromote(String appPoiCode, String promotion) throws MtWmErrorException;

    List<ShopTag> getShopTags() throws MtWmErrorException;

    void updateShippingTime(String appPoiCode, String shippingTime) throws MtWmErrorException;
}
