package comjiabangou.mtwmsdk.api.impl;

import com.jiabangou.mtwmsdk.api.ShippingService;
import com.jiabangou.mtwmsdk.exception.MtWmErrorException;
import com.jiabangou.mtwmsdk.model.Region;
import com.jiabangou.mtwmsdk.model.Shipping;
import comjiabangou.mtwmsdk.api.ServiceTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanglei on 16-10-12.
 */
public class ShippingServiceImplTest extends ServiceTest {

    private final static ShippingService service = mtWmClient.getShippingService();

    @Test
    public void save() throws MtWmErrorException {

        List<Region> regions = new ArrayList<>();
        //{"x":39941199,"y":116385384},{ "x":39926983,"y":116361694},{"x ":39921586,"y":116398430}
        Region region1 = new Region();
        region1.setX("39.941199");
        region1.setY("11.6385384");

        Region region2 = new Region();
        region2.setX("39.941199");
        region2.setY("11.6385384");

        Region region3 = new Region();
        region3.setX("39.941199");
        region3.setY("11.6385384");

        regions.add(region1);
        regions.add(region2);
        regions.add(region3);

        Shipping shipping = new Shipping();
        shipping.setApp_poi_code("test_poi_02");
        shipping.setApp_shipping_code("test_poi_02");
        shipping.setType("1");
        shipping.setArea(regions);
        shipping.setMin_price(1.0);
        shipping.setShipping_fee(5.0);
        service.save("test_poi_02", shipping);
    }

    @Test
    public void getsByAppPoiCode() throws MtWmErrorException {
        List<Shipping> shippings = service.getsByAppPoiCode("test_poi_01");
        System.out.println(shippings);
    }

}
