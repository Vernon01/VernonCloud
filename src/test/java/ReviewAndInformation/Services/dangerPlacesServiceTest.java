package ReviewAndInformation.Services;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.dangerPlaces;
import ReviewAndInformation.Repository.dangerPlacesRepository;
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
public class dangerPlacesServiceTest extends AbstractTestNGSpringContextTests{

    private Integer id;
    @Autowired
    private dangerPlacesService service ;

    @Autowired
    private dangerPlacesRepository repo;
    private List<dangerPlaces> info;

    @BeforeMethod
    public void setUp() throws Exception {
        info = new ArrayList<dangerPlaces>();
    }

    @Test
    public void testCreate() throws Exception {

        dangerPlaces dp = new dangerPlaces.Builder("rufu")
                .build();
        info.add(dp);
        repo.save(dp);
        id=dp.getId();
        Assert.assertNotNull(dp.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testGetCityInfo() throws Exception {
        Assert.assertTrue( service.getDangerPlaces().size() == 1);
    }
}
