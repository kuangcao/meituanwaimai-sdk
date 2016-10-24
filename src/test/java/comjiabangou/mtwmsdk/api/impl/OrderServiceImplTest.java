package comjiabangou.mtwmsdk.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.jiabangou.mtwmsdk.api.OrderService;
import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.OrderDetail;
import com.jiabangou.mtwmsdk.utils.MtWmUtils;
import comjiabangou.mtwmsdk.api.ServiceTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanglei on 16-10-12.
 */
public class OrderServiceImplTest extends ServiceTest {

    private final static OrderService orderService = mtWmClient.getOrderService();

    @Test
    public void decodeUrl() {
        Map<String, String> params = new HashMap<>();
        params.put("wm_poi_name", "%E5%85%A8%E8%81%9A%E5%BE%B7%E6%B5%8B%E8%AF%95%E5%BA%97");
        MtWmUtils.sigCheck("111", params, "409", "9f9d5562d44dedef5b25a780a08bc0ca");
    }

    @Test
    public void checkSig() {
        String json = "{\"original_price\":\"9.1\",\"wm_poi_name\":\"%E5%85%A8%E8%81%9A%E5%BE%B7%E6%B5%8B%E8%AF%95%E5%BA%97\",\"invoice_title\":\"\",\"latitude\":\"31.143873\",\"extras\":\"%5B%7B%7D%5D\",\"delivery_time\":\"0\",\"sig\":\"16b154fcaae01986ec3ff6e9e18c738c\",\"total\":\"9.1\",\"avg_send_time\":\"0.0\",\"ctime\":\"1476355768\",\"pay_type\":\"2\",\"caution\":\"\",\"app_id\":\"409\",\"timestamp\":\"1476355830\",\"longitude\":\"97.175621\",\"utime\":\"1476355768\",\"is_third_shipping\":\"0\",\"shipper_phone\":\"\",\"recipient_address\":\"%E8%A5%BF%E8%97%8F%E6%98%8C%E9%83%BD%E5%B8%82%E6%B0%94%E8%B1%A1%E5%B1%80%40%23%E8%A5%BF%E8%97%8F%E8%87%AA%E6%B2%BB%E5%8C%BA%E6%98%8C%E9%83%BD%E5%B8%82%E5%8D%A1%E8%8B%A5%E5%8C%BA%E5%9F%8E%E5%85%B3%E9%95%87%E6%9E%97%E5%BB%93%E8%B7%AF286%E5%8F%B7\",\"shipping_fee\":\"9.0\",\"wm_poi_id\":\"1564462\",\"app_poi_code\":\"test_poi_01\",\"has_invoiced\":\"0\",\"day_seq\":\"2\",\"poi_receive_detail\":\"\",\"detail\":\"%5B%7B%22app_food_code%22%3A%221%22%2C%22box_num%22%3A0%2C%22box_price%22%3A0%2C%22food_discount%22%3A1%2C%22food_name%22%3A%22%E6%B5%8B%E8%AF%95%E8%8F%9C%E5%93%811%22%2C%22price%22%3A0.1%2C%22quantity%22%3A1%2C%22sku_id%22%3A%221%22%2C%22unit%22%3A%22%E5%93%88%22%7D%5D\",\"wm_poi_address\":\"%E5%8D%97%E6%9E%81%E6%B4%B24%E5%8F%B7%E7%AB%99\",\"recipient_name\":\"%E7%8E%8B%E7%A3%8A+%28%E5%85%88%E7%94%9F%29\",\"order_id\":\"2310763339\",\"wm_poi_phone\":\"4009208801\",\"wm_order_id_view\":\"15644621401905893\",\"city_id\":\"999999\",\"status\":\"2\",\"recipient_phone\":\"13651187030\"}";
        HashMap<String, String> tempTimes = JSONObject.parseObject(json, HashMap.class);
        MtWmUtils.sigCheck("http://is52e.ngrok.natapp.cn/waimai/m/1/meituan/callback.json", tempTimes, "409", "9f9d5562d44dedef5b25a780a08bc0ca");
        System.out.println(tempTimes);
    }

    @Test
    public void createOrder() {
        String json = "{\"original_price\":\"9.1\",\"wm_poi_name\":\"%E5%85%A8%E8%81%9A%E5%BE%B7%E6%B5%8B%E8%AF%95%E5%BA%97\",\"invoice_title\":\"\",\"latitude\":\"31.143873\",\"extras\":\"%5B%7B%7D%5D\",\"delivery_time\":\"0\",\"sig\":\"16b154fcaae01986ec3ff6e9e18c738c\",\"total\":\"9.1\",\"avg_send_time\":\"0.0\",\"ctime\":\"1476355768\",\"pay_type\":\"2\",\"caution\":\"\",\"app_id\":\"409\",\"timestamp\":\"1476355830\",\"longitude\":\"97.175621\",\"utime\":\"1476355768\",\"is_third_shipping\":\"0\",\"shipper_phone\":\"\",\"recipient_address\":\"%E8%A5%BF%E8%97%8F%E6%98%8C%E9%83%BD%E5%B8%82%E6%B0%94%E8%B1%A1%E5%B1%80%40%23%E8%A5%BF%E8%97%8F%E8%87%AA%E6%B2%BB%E5%8C%BA%E6%98%8C%E9%83%BD%E5%B8%82%E5%8D%A1%E8%8B%A5%E5%8C%BA%E5%9F%8E%E5%85%B3%E9%95%87%E6%9E%97%E5%BB%93%E8%B7%AF286%E5%8F%B7\",\"shipping_fee\":\"9.0\",\"wm_poi_id\":\"1564462\",\"app_poi_code\":\"test_poi_01\",\"has_invoiced\":\"0\",\"day_seq\":\"2\",\"poi_receive_detail\":\"\",\"detail\":\"%5B%7B%22app_food_code%22%3A%221%22%2C%22box_num%22%3A0%2C%22box_price%22%3A0%2C%22food_discount%22%3A1%2C%22food_name%22%3A%22%E6%B5%8B%E8%AF%95%E8%8F%9C%E5%93%811%22%2C%22price%22%3A0.1%2C%22quantity%22%3A1%2C%22sku_id%22%3A%221%22%2C%22unit%22%3A%22%E5%93%88%22%7D%5D\",\"wm_poi_address\":\"%E5%8D%97%E6%9E%81%E6%B4%B24%E5%8F%B7%E7%AB%99\",\"recipient_name\":\"%E7%8E%8B%E7%A3%8A+%28%E5%85%88%E7%94%9F%29\",\"order_id\":\"2310763339\",\"wm_poi_phone\":\"4009208801\",\"wm_order_id_view\":\"15644621401905893\",\"city_id\":\"999999\",\"status\":\"2\",\"recipient_phone\":\"13651187030\"}";
        HashMap<String, String> tempTimes = JSONObject.parseObject(json, HashMap.class);
        mtWmClient.pushHandle("http://is52e.ngrok.natapp.cn/waimai/m/1/meituan/callback.json", tempTimes, "create_order");
    }

    @Test
    public void getOrderDetail() throws MtWmErrorException {
        OrderDetail orderDetail = orderService.getOrderDetail("2312883182", Short.valueOf("1"));
        System.out.println(orderDetail);
    }

    @Test
    public void confirmOrder() throws MtWmErrorException {
        orderService.confirm("2395382642");
    }

    @Test
    public void cancelOrder() throws MtWmErrorException {
        orderService.cancel("2395382642", 1202, "测试订单取消");
    }
}
