package comjiabangou.mtwmsdk.api.impl;

import com.jiabangou.mtwmsdk.api.ShopService;
import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import comjiabangou.mtwmsdk.api.ServiceTest;
import org.junit.Test;

import java.util.List;

/**
 * Created by wanglei on 16-10-9.
 */
public class ShopServiceImplTest extends ServiceTest {

    @Test
    public void getIds() throws MtWmErrorException {
        ShopService shopService = mtWmClient.getShopService();
        List<String> code = shopService.getIds();
        System.out.println(code);
    }

    @Test
    public void open() throws MtWmErrorException {
        ShopService shopService = mtWmClient.getShopService();
        shopService.open("test_poi_01");
    }

    @Test
    public void close() throws MtWmErrorException {
        ShopService shopService = mtWmClient.getShopService();
        shopService.close("test_poi_01");
    }

}
