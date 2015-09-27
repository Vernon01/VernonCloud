package ReviewAndInformation.Respository;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.GoToPlaces;
import ReviewAndInformation.Repository.GoToPlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by student on 2015/05/18.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class GoToPlacesRepoTest extends AbstractTestNGSpringContextTests {

    private Integer id;

    @Autowired
    GoToPlacesRepository repo;

    @Test
    public void testCreate() throws Exception {

        GoToPlaces gtp = new GoToPlaces.Builder("CapeTown")
                .build();
        repo.save(gtp);
        id=gtp.getId();
        Assert.assertNotNull(gtp.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        GoToPlaces gtp = repo.findOne(id);
        Assert.assertEquals("CapeTown", gtp.getCityToVisit());
    }


    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {

        GoToPlaces gtp = repo.findOne(id);
        GoToPlaces newgtp = new GoToPlaces.Builder(gtp.getCityToVisit())
                .copy(gtp)
                .cityToVisit("George")
                .build();
        repo.save(newgtp);
        Assert.assertEquals("George", newgtp.getCityToVisit());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        GoToPlaces gtp = repo.findOne(id);
        repo.delete(gtp);
        GoToPlaces newgtp = repo.findOne(id);
        Assert.assertNull(newgtp);
    }
}
