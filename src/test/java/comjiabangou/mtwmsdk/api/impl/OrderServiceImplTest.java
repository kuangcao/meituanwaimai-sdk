package comjiabangou.mtwmsdk.api.impl;

import com.jiabangou.mtwmsdk.api.OrderService;
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
    public void decodeUrl(){
        Map<String, String> params = new HashMap<>();
        params.put("wm_poi_name", "%E5%85%A8%E8%81%9A%E5%BE%B7%E6%B5%8B%E8%AF%95%E5%BA%97");
        MtWmUtils.sigCheck("111", params,"409", "9f9d5562d44dedef5b25a780a08bc0ca");
    }
}
