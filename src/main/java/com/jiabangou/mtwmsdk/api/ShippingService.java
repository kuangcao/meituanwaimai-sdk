package com.jiabangou.mtwmsdk.api;

import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.Shipping;

import java.util.List;

/**
 * 配送范围类API
 * Created by freeway on 16/3/12.
 */
public interface ShippingService {

    /**
     * 创建／更新门店配送范围
     *
     * @param shipping
     * @throws MtWmErrorException
     */
    void save(String appPoiCode, Shipping shipping) throws MtWmErrorException;

    /**
     * 获取门店配送范围
     *
     * @param appPoiCode APP方门店id
     * @return
     * @throws MtWmErrorException
     */
    List<Shipping> getsByAppPoiCode(String appPoiCode) throws MtWmErrorException;

    /**
     * 批量创建/更新配送范围
     * http://developer.waimai.meituan.com/doc/show#3.3
     *
     * @param appPoiCode APP方门店id
     * @param shippings
     * @throws MtWmErrorException
     */
    void batchSave(String appPoiCode, List<Shipping> shippings) throws MtWmErrorException;

}
