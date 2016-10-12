package comjiabangou.mtwmsdk.api;

import com.jiabangou.mtwmsdk.api.MtWmClient;
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
        mtWmClient.setConfigStorage(configStorage);
        mtWmClient.setIsTest(false);
    }

}
