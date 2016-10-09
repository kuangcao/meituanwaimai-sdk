package com.jiabangou.mtwmsdk.api;

import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.Additional;
import com.jiabangou.mtwmsdk.model.Qualify;
import com.jiabangou.mtwmsdk.model.Shop;
import com.jiabangou.mtwmsdk.model.ShopTag;

import java.util.List;

/**
 * 门店类api接口
 */
public interface ShopService {

    /**
     * 创建或更新门店信息，包括基本信息，营业状态，上下线状态等
     *
     * @param shop
     * @throws MtWmErrorException
     */
    void save(Shop shop) throws MtWmErrorException;

    /**
     * 获取门店id
     *
     * @return
     * @throws MtWmErrorException
     */
    List<String> getIds() throws MtWmErrorException;

    /**
     * 批量获取门店详细信息
     *
     * @param appPoiCodes
     * @return
     * @throws MtWmErrorException
     */
    List<Shop> gets(List<Long> appPoiCodes) throws MtWmErrorException;

    /**
     * 门店设置为营业状态（开发者可以不使用这个API，因为也可以通过poi/save接口更新open_level字段值来实现）
     *
     * @param id
     * @throws MtWmErrorException
     */
    void open(String id) throws MtWmErrorException;

    /**
     * 门店设置为休息状态（开发者可以不使用这个API，因为也可以通过poi/save接口更新open_level字段值来实现）
     *
     * @param id
     * @throws MtWmErrorException
     */
    void close(String id) throws MtWmErrorException;

    /**
     * 门店设置为下线状态（开发者可以不使用这个API，因为也可以通过poi/save接口更新is_online字段值来实现）
     *
     * @param id
     * @param reason
     * @throws MtWmErrorException
     */
    void offline(String id, String reason) throws MtWmErrorException;

    /**
     * 门店设置为上线状态（开发者可以不使用这个API，因为也可以通过poi/save接口更新is_online字段值来实现）
     * （目前重新上线的策略是：调用上线API，不会马上上线，美团先通知美团编审人员，然后手工擦操作上线）
     *
     * @param id
     * @throws MtWmErrorException
     */
    void online(String id) throws MtWmErrorException;

    /**
     * 门店资质证书上传
     * @param qualify
     * @throws MtWmErrorException
     */
    void saveQualify(Qualify qualify) throws MtWmErrorException;

    /**
     * 同步门店预计送达时长
     * @param appPoiCodes
     * @param sendTime
     * @throws MtWmErrorException
     */
    void saveSendtime(List<String> appPoiCodes, int sendTime) throws MtWmErrorException;

    /**
     * 更改门店附加信息
     * @param additional
     * @throws MtWmErrorException
     */
    void saveAdditional(Additional additional) throws MtWmErrorException;

    /**
     * 更改门店公告信息
     * @param appPoiCode
     * @param promotion
     * @throws MtWmErrorException
     */
    void updatePromote(String appPoiCode, String promotion) throws MtWmErrorException;

    /**
     * 获取门店品类详细信息列表
     * @return
     * @throws MtWmErrorException
     */
    List<ShopTag> getShopTags() throws MtWmErrorException;

    /**
     * 更改门店营业时间
     * @param appPoiCode
     * @param shippingTime
     * @throws MtWmErrorException
     */
    void updateShippingTime(String appPoiCode, String shippingTime) throws MtWmErrorException;
}
