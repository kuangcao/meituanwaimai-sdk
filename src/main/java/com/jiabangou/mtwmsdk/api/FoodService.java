package com.jiabangou.mtwmsdk.api;

import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.Food;
import com.jiabangou.mtwmsdk.model.FoodCategory;
import com.jiabangou.mtwmsdk.model.FoodCategoryDetail;

import java.util.List;

/**
 * 菜品类API
 * Created by freeway on 16/3/12.
 */
public interface FoodService {

    /**
     * 更新菜品分类
     * http://developer.waimai.meituan.com/doc/show#4.1
     * @param foodCategory
     * @throws MtWmErrorException
     */
    void updateCategory(FoodCategory foodCategory) throws MtWmErrorException;

    /**
     * 删除菜品分类
     * http://developer.waimai.meituan.com/doc/show#4.2
     * @param appPoiCode APP方门店id
     * @param categoryName APP方分类名
     * @throws MtWmErrorException
     */
    void deleteCategory(String appPoiCode, String categoryName) throws MtWmErrorException;

    /**
     * 查询门店菜品分类列表
     * http://developer.waimai.meituan.com/doc/show#4.9
     * @param appPoiCode APP方门店id
     * @return
     * @throws MtWmErrorException
     */
    List<FoodCategoryDetail> list(String appPoiCode) throws MtWmErrorException;

    /**
     * 创建/更新菜品
     * 推荐使用批量创建/更新菜品Api，批量更新门店菜品
     * 注：现对菜品上传接口进行升级，分为两步，第一步为上传图片，第二步为创建/更新菜品，详细内容如下。
     * （目前接口会兼容原有形式，但新接入时，推荐使用升级后的形式，即分为两步创建/更新菜品）
     * http://developer.waimai.meituan.com/doc/show#4.3
     * @throws MtWmErrorException
     */
    void save(Food food) throws MtWmErrorException;

    /**
     * 创建/更新菜品
     * 推荐使用批量创建/更新菜品Api，批量更新门店菜品
     * 注：现对菜品上传接口进行升级，分为两步，第一步为上传图片，第二步为创建/更新菜品，详细内容如下。
     * （目前接口会兼容原有形式，但新接入时，推荐使用升级后的形式，即分为两步创建/更新菜品）
     * http://developer.waimai.meituan.com/doc/show#4.4
     * @throws MtWmErrorException
     */
    void initdata(Food food) throws MtWmErrorException;

    /**
     * 批量创建/更新菜品
     * 菜品信息以json格式请求，详细参数请参见创建/更新菜品Api参数定义
     *
     * 说明：
     * 批量更新的菜品会和原有菜品进行比对：
     * 如果某个菜品原来没有，就会新增此菜品；
     * 如果原来有，就会更新此菜品；
     * 如果原来有的菜品不在此次更新的数据中，就会删除原来的菜品。
     *
     * http://developer.waimai.meituan.com/doc/show#4.7
     * @param appPoiCode
     * @param foods
     * @throws MtWmErrorException
     */
    void batchSave(String appPoiCode, List<Food> foods) throws MtWmErrorException;

    /**
     * 删除菜品
     * http://developer.waimai.meituan.com/doc/show#4.5
     * @param appPoiCode APP方门店id
     * @param appFoodCode APP方菜品ID, 最大长度128 不同门店可以重复，同一门店内不能重复
     * @throws MtWmErrorException
     */
    void delete(String appPoiCode, String appFoodCode) throws MtWmErrorException;

    /**
     * 查询门店菜品列表
     * http://developer.waimai.meituan.com/doc/show#4.6
     * @param appPoiCode
     * @return
     * @throws MtWmErrorException
     */
    List<Food> gets(String appPoiCode) throws MtWmErrorException;


}
