package comjiabangou.mtwmsdk.api.impl;

import com.jiabangou.mtwmsdk.api.FoodService;
import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.Food;
import com.jiabangou.mtwmsdk.model.FoodCategory;
import com.jiabangou.mtwmsdk.model.FoodCategoryDetail;
import comjiabangou.mtwmsdk.api.ServiceTest;
import org.junit.Test;

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
        food.setApp_food_code("1");
        food.setName("测试菜品1");
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
        foodService.save(food);
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

}
