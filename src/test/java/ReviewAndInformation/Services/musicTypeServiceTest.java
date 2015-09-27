package ReviewAndInformation.Services;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.musicType;
import ReviewAndInformation.Repository.musicTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class musicTypeServiceTest extends AbstractTestNGSpringContextTests{

    private Integer id;
    @Autowired
    private musicTypeServices service ;

    @Autowired
    private musicTypeRepository repo;
    private List<musicType> info;

    @Test
    public void testCreate() throws Exception {

        musicType mt = new musicType.Builder("blaaaah")
                .build();
        repo.save(mt);
        id=mt.getId();
        Assert.assertNotNull(mt.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testGetCityInfo() throws Exception {
        Assert.assertTrue( service.getMusicTypes().size() == 1);
    }
}
