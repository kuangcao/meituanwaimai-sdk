package comjiabangou.mtwmsdk.api;

import com.jiabangou.mtwmsdk.api.MtWmClient;
import com.jiabangou.mtwmsdk.api.impl.MtWmClientImpl;
import com.jiabangou.mtwmsdk.api.impl.MtWmInMemoryConfigStorage;
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
        configStorage.setAppId("409");
        configStorage.setSecret("9f9d5562d44dedef5b25a780a08bc0ca");
        mtWmClient.setConfigStorage(configStorage);
        mtWmClient.setIsTest(true);
    }

}
