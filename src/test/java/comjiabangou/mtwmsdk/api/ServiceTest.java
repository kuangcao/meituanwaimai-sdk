package comjiabangou.mtwmsdk.api;

import com.alibaba.fastjson.JSON;
import com.jiabangou.mtwmsdk.api.MtWmClient;
import com.jiabangou.mtwmsdk.api.PushConsumer;
import com.jiabangou.mtwmsdk.api.impl.MtWmClientImpl;
import com.jiabangou.mtwmsdk.api.impl.MtWmInMemoryConfigStorage;
import com.jiabangou.mtwmsdk.model.OrderDetail;
import org.junit.BeforeClass;

/**
 * Created by freeway on 16/7/14.
 *
 */
public class ServiceTest {

    protected static MtWmClient mtWmClient;

    @BeforeClass
    public static void BeforeClass() {
        MtWmInMemoryConfigStorage configStorage = new MtWmInMemoryConfigStorage();
        mtWmClient = new MtWmClientImpl();
        mtWmClient.setConfigStorage(configStorage);
        mtWmClient.setIsTest(false);
        mtWmClient.setPushConsumer(new PushConsumer() {
            @Override
            public void createOrder(OrderDetail orderDetail) {

            }

            @Override
            public void confirmedOrder(OrderDetail orderDetail) {

            }

            @Override
            public void completedOrder(OrderDetail orderDetail) {

            }

            @Override
            public void cancelOrder(String orderId, Integer reasonCode, String reason) {

            }

            @Override
            public void refundOrder(String orderId, String notifyType, String reason) {

            }

            @Override
            public void deliveryStatus(String orderId, Short statusCode, String time, String dispatcherName, String dispatcherMobile) {

            }
        });
        mtWmClient.setLogListener((cmd, method, isSuccess, request, response) -> {
            System.out.println("cmd:"+cmd);
            System.out.println("method:"+method);
            System.out.println("isSuccess:"+isSuccess);
            System.out.println("request:"+ JSON.toJSONString(request));
            System.out.println("response:"+JSON.toJSONString(response));
        });
    }

}
