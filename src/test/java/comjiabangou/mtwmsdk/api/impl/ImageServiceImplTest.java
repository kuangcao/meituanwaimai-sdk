package comjiabangou.mtwmsdk.api.impl;

import com.jiabangou.mtwmsdk.api.ImageService;
import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import comjiabangou.mtwmsdk.api.ServiceTest;
import org.junit.Test;

/**
 * Created by wanglei on 16-9-30.
 */
public class ImageServiceImplTest extends ServiceTest {

    @Test
    public void uploadImage() throws MtWmErrorException {
        ImageService imageService = mtWmClient.getImageService();
        String code = imageService.uploadImage("test_poi_01", "37375183__1582979.jpg", "http://pic54.nipic.com/file/20141204/19902974_135858226000_2.jpg");
        System.out.println(code);
    }
}
