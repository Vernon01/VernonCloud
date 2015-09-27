package ReviewAndInformation.Services;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.GoToPlaces;
import ReviewAndInformation.Repository.GoToPlacesRepository;
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
public class GoToPlacesServiceTest extends AbstractTestNGSpringContextTests{

    private Integer id;
    @Autowired
    private GoToPlacesService service ;

    @Autowired
    private GoToPlacesRepository repo;
    private List<GoToPlaces> info;

    @Test
    public void testCreate() throws Exception {

        GoToPlaces gtp = new GoToPlaces.Builder("Durban")
                .build();
        repo.save(gtp);
        id=gtp.getId();
        Assert.assertNotNull(gtp.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testGetCityInfo() throws Exception {
        Assert.assertTrue( service.getGoPlaces().size() == 1);
    }
}
