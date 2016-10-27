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
        String code = imageService.uploadImage("test_poi_02", "qsP_960x720.jpg", "http://i.test.xygcdn.com/r/h/16_qsL_808x643.png@750w_625h_1e_1c_1pr");
        System.out.println(code);
    }

    @Test
    public void Image(){
        String image = "http://i.test.xygcdn.com/r/h/16_qsL_808x643.png";
        String imageName = image.substring(image.lastIndexOf("/") + 1);
        if(!imageName.contains(".jpg")){
            String a = imageName.substring(imageName.lastIndexOf("."));
            imageName = imageName.replace(a, ".jpg");
        }
        System.out.println(imageName);
    }
}
