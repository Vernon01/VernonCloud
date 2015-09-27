package ReviewAndInformation.Services;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.cityInfo;
import ReviewAndInformation.Repository.cityInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class cityInfoServiceTest extends AbstractTestNGSpringContextTests {

    private Integer id;
    @Autowired
    private cityInfoService service ;

    @Autowired
    private cityInfoRepository repo;
    private List<cityInfo> info;

    @BeforeMethod
    public void setUp() throws Exception {
        info = new ArrayList<cityInfo>();
    }

    @Test
    public void testCreate() throws Exception {

        cityInfo cti = new cityInfo.Builder("uptown")
                .build();
        info.add(cti);
        repo.save(cti);
        id=cti.getId();
        Assert.assertNotNull(cti.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testGetCityInfo() throws Exception {
        Assert.assertTrue( service.getCityInfo().size() == 1);
    }
}
