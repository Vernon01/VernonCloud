package ReviewAndInformation.Services;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.director;
import ReviewAndInformation.Repository.directorRepository;
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
public class directorServiceTest extends AbstractTestNGSpringContextTests {

    private Integer id;
    @Autowired
    private directorService service ;

    @Autowired
    private directorRepository repo;
    private List<director> info;

    @Test
    public void testCreate() throws Exception {

        director dir1 = new director.Builder("Will")
                .age(35)
                .yearsDirecting(7)
                .build();
        repo.save(dir1);
        id=dir1.getId();
        Assert.assertNotNull(dir1.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testGetCityInfo() throws Exception {
        Assert.assertTrue( service.getDirectors().size() == 1);
    }
}
