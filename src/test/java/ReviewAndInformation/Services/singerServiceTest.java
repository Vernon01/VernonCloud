package ReviewAndInformation.Services;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.singer;
import ReviewAndInformation.Repository.singerRepository;
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
public class singerServiceTest extends AbstractTestNGSpringContextTests{

    private Integer id;
    @Autowired
    private SingerService service ;

    @Autowired
    private singerRepository repo;
    private List<singer> info;

    @Test
    public void testCreate() throws Exception {

        singer si = new singer.Builder("Bostin")
                .build();
        repo.save(si);
        id=si.getId();
        Assert.assertNotNull(si.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testGetCityInfo() throws Exception {
        Assert.assertTrue( service.getSingers().size() == 1);
    }
}
