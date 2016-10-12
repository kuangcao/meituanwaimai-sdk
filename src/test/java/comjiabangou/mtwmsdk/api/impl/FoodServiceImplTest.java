package comjiabangou.mtwmsdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.mtwmsdk.api.FoodService;
import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.*;
import comjiabangou.mtwmsdk.api.ServiceTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanglei on 16-10-11.
 */
public class FoodServiceImplTest extends ServiceTest {

    private final static FoodService foodService = mtWmClient.getFoodService();

    @Test
    public void updateCategory() throws MtWmErrorException {
        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setApp_poi_code("test_poi_01");
        foodCategory.setCategory_name("测试分类,新1");
        foodCategory.setSequence("1");
        foodService.updateCategory(foodCategory);
    }

    @Test
    public void deleteCategory() throws MtWmErrorException {
        foodService.deleteCategory("test_poi_01", "测试分类,新");
    }

    @Test
    public void catList() throws MtWmErrorException {
        List<FoodCategoryDetail> foodCategories = foodService.list("test_poi_01");
        System.out.println(foodCategories);
    }

    @Test
    public void save() throws MtWmErrorException {
        Food food = new Food();
        food.setApp_poi_code("test_poi_01");
        food.setApp_food_code("2");
        food.setName("测试菜品2");
        food.setDescription("这个是测试菜gai");
        food.setPrice(0.1);
        food.setMin_order_count(1);
        food.setUnit("哈");
        food.setBox_num(0f);
        food.setBox_price(0.0);
        food.setCategory_name("测试分类,新");
        food.setIs_sold_out(0);
        food.setPicture("B65DE625D25B4C809569E13760D9E33F");
        food.setSequence(1);

        AvailableTimes availableTime = new AvailableTimes();
        availableTime.setMonday("6:00-23:00");
        availableTime.setTuesday("6:00-23:00");
        availableTime.setWednesday("6:00-23:00");
        availableTime.setThursday("6:00-23:00");
        availableTime.setFriday("6:00-23:00");
        availableTime.setSaturday("6:00-23:00");
        availableTime.setSunday("6:00-23:00");


        Sku sku = new Sku();
        sku.setSku_id("1");
        sku.setSpec("测试sku1");
        sku.setPrice(0.2);
        sku.setStock(10);
        sku.setAvailable_times(availableTime);

        Sku sku1 = new Sku();
        sku1.setSku_id("2");
        sku1.setSpec("测试sku2");
        sku1.setPrice(0.2);
        sku1.setStock(10);
        sku1.setAvailable_times(availableTime);

        List<Sku> skus = new ArrayList<>();
        skus.add(sku);
        skus.add(sku1);

        food.setSkus(skus);

        foodService.initdata(food);
    }

    @Test
    public void gets() throws MtWmErrorException {
        List<Food> foods = foodService.gets("test_poi_01");
        System.out.println(foods);
    }

    @Test
    public void delete() throws MtWmErrorException {
        foodService.delete("test_poi_01", "1");
    }

    @Test
    public void abc(){
//        String json = "{\"category_name\":\"美味汉堡\",\"skus\":\"[{\\\"available_times\\\":{\\\"friday\\\":\\\"\\\",\\\"monday\\\":\\\"\\\",\\\"saturday\\\":\\\"\\\",\\\"sunday\\\":\\\"\\\",\\\"thursday\\\":\\\"\\\",\\\"tuesday\\\":\\\"\\\",\\\"wednesday\\\":\\\"\\\"},\\\"location_code\\\":\\\"\\\",\\\"price\\\":\\\"30.0\\\",\\\"sku_id\\\":\\\"food_code02\\\",\\\"spec\\\":\\\"\\\",\\\"stock\\\":\\\"\\\",\\\"upc\\\":\\\"\\\"}]\",\"utime\":1475050338,\"app_food_code\":\"food_code02\",\"box_num\":0.0,\"min_order_count\":1,\"box_price\":0.0,\"description\":\"醇香土豆泥1份\",\"picture\":\"http://p0.meituan.net/xianfu/e3a70fdf141280567b9bede64a81981916384.jpg\",\"sequence\":0,\"app_poi_code\":\"\",\"unit\":\"\",\"price\":30.0,\"name\":\"土豆泥餐\",\"ctime\":1475050338,\"is_sold_out\":0}";
        String json = "{\"category_name\":\"美味汉堡\",\"skus\":\"[{\\\"available_times\\\":{\\\"friday\\\":\\\"\\\",\\\"monday\\\":\\\"\\\",\\\"saturday\\\":\\\"\\\",\\\"sunday\\\":\\\"\\\",\\\"thursday\\\":\\\"\\\",\\\"tuesday\\\":\\\"\\\",\\\"wednesday\\\":\\\"\\\"},\\\"location_code\\\":\\\"\\\",\\\"price\\\":\\\"30.0\\\",\\\"sku_id\\\":\\\"food_code02\\\",\\\"spec\\\":\\\"\\\",\\\"stock\\\":\\\"\\\",\\\"upc\\\":\\\"\\\"}]\",\"utime\":1475050338,\"app_food_code\":\"food_code02\",\"box_num\":0.0,\"min_order_count\":1,\"box_price\":0.0,\"description\":\"醇香土豆泥1份\",\"picture\":\"http://p0.meituan.net/xianfu/e3a70fdf141280567b9bede64a81981916384.jpg\",\"sequence\":0,\"app_poi_code\":\"\",\"unit\":\"\",\"price\":30.0,\"name\":\"土豆泥餐\",\"ctime\":1475050338,\"is_sold_out\":0}";
        JSONObject jsonObject = JSON.parseObject(json);
        jsonObject.put("skus", JSON.parseArray(jsonObject.getString("skus")));
        TypeUtils.castToJavaBean(jsonObject, Food.class);
    }

}
