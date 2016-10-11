package comjiabangou.mtwmsdk.api.impl;

import com.jiabangou.mtwmsdk.api.ShopService;
import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.Shop;
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

        Shop shop = new Shop();
        shop.setIs_online(1);
        shop.setPhone("010-64736466");
        shop.setStandby_tel("13594011234");
        shop.setApp_poi_code("7");
        shop.setShipping_fee(0.0);
        shop.setOpen_level(1);
        shop.setInvoice_support(1);
        shop.setAddress("朝阳区广顺北大街33号福码大厦B座2楼(望京凯德MALL北)");
        shop.setShipping_time("7:00-9:00,11:30-23:00");
        shop.setInvoice_min_price(1.0);
        shop.setName("美团-望京-test店");
        shop.setLongitude(116.467441f);
        shop.setLatitude(39.994899f);
        shop.setTime_select(1);
        shop.setInvoice_support(1);
        shop.setInvoice_description("满3块开发票");

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
        pois.add("test_poi_01");
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



}
