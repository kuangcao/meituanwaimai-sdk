package comjiabangou.mtwmsdk.api.impl;

import com.jiabangou.mtwmsdk.api.ShopService;
import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.Additional;
import com.jiabangou.mtwmsdk.model.Shop;
import com.jiabangou.mtwmsdk.model.ShopTag;
import comjiabangou.mtwmsdk.api.ServiceTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanglei on 16-10-9.
 */
public class ShopServiceImplTest extends ServiceTest {

    private final static ShopService shopService = mtWmClient.getShopService();

    @Test
    public void save() throws MtWmErrorException {
        //Body:{"address":"天津市天津市市辖区南开大学","app_poi_code":"39","invoice_support":0,
        // "is_online":1,"latitude":39.103693,"longitude":117.167299,"name":"DY的美团小店","open_level":1,
        // "phone":"4008917222","pic_url":"http://i.test.xygcdn.com/z/h/1G_qsT_701x363.jpg",
        // "pic_url_large":"http://i.test.xygcdn.com/z/h/1G_qsT_701x363.jpg","pre_book":1,
        // "promotion_info":"","shipping_time":"06:00-10:00,10:00-14:00,14:00-23:45","standby_tel":"13594664819",
        // "third_tag_name":"北京菜","time_select":1}
        Shop shop = new Shop();
        shop.setApp_poi_code("39-test-2");
        shop.setName("DY的美团小店test2");
        shop.setAddress("天津市天津市市辖区南开大学");
        shop.setLongitude(117.167299);
        shop.setLatitude(39.103693);
        shop.setPic_url("http://i.test.xygcdn.com/z/h/1G_qsT_701x363.jpg");
        shop.setPic_url_large("http://i.test.xygcdn.com/z/h/1G_qsT_701x363.jpg");
        shop.setPhone("4008917222");
        shop.setStandby_tel("13594011234");
        shop.setShipping_fee(0.0);
        shop.setShipping_time("06:00-10:00,10:00-14:00,14:00-23:45");
        shop.setOpen_level(1);
        shop.setIs_online(1);
        shop.setInvoice_support(0);
        shop.setPromotion_info("");
        shop.setPre_book(1);
//        shop.setInvoice_min_price(1.0);
//        shop.setInvoice_description("满3块开发票");
        shop.setThird_tag_name("北京菜");
        shop.setTime_select(1);
        shopService.save(shop);
    }

    @Test
    public void getIds() throws MtWmErrorException {
        List<String> code = shopService.getIds();
        System.out.println(code);
    }

    @Test
    public void gets() throws MtWmErrorException {
        List<String> pois = new ArrayList<>();
        pois.add("39");
        List<Shop> shops = shopService.gets(pois);
        System.out.println(shops);
    }

    @Test
    public void open() throws MtWmErrorException {
        shopService.open("test_poi_01");
    }

    @Test
    public void close() throws MtWmErrorException {
        shopService.close("test_poi_01");
    }

    @Test
    public void saveSendtime() throws MtWmErrorException {
        List<String> pois = new ArrayList<>();
        pois.add("test_poi_01");
        shopService.saveSendtime(pois, 60);
    }

    @Test
    public void saveAdditional() throws MtWmErrorException {
        Additional additional = new Additional();
        additional.setApp_poi_code("test_poi_01");
        additional.setApp_poi_email("wangleimvp110@126.com");
        additional.setApp_brand_code("qjd");
        additional.setApp_org_id("11213");
        shopService.saveAdditional(additional);
    }

    @Test
    public void updatePromote() throws MtWmErrorException {
        shopService.updatePromote("test_poi_01", "哈哈哈，测试公告信息");
    }

    @Test
    public void getShopTags() throws MtWmErrorException {
        List<ShopTag> shopTags = shopService.getShopTags();
        System.out.println(shopTags);
    }

    @Test
    public void updateShippingTime() throws MtWmErrorException {
        shopService.updateShippingTime("test_poi_01", "5:00-23:00");
    }

}
