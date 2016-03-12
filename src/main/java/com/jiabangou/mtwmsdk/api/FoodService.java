package com.jiabangou.mtwmsdk.api;

import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.Food;
import com.jiabangou.mtwmsdk.model.FoodCategory;

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
    List<FoodCategory> list(String appPoiCode) throws MtWmErrorException;

    /**
     * 创建/更新菜品
     * 推荐使用批量创建/更新菜品Api，批量更新门店菜品
     * 注：现对菜品上传接口进行升级，分为两步，第一步为上传图片，第二步为创建/更新菜品，详细内容如下。
     * （目前接口会兼容原有形式，但新接入时，推荐使用升级后的形式，即分为两步创建/更新菜品）
     * http://developer.waimai.meituan.com/doc/show#4.3
     * @throws MtWmErrorException
     */
    void save(Food food) throws MtWmErrorException;

}
