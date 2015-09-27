package ReviewAndInformation.Respository;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.dangerPlaces;
import ReviewAndInformation.Repository.dangerPlacesRepository;
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
public class dangerPlacesRepoTest extends AbstractTestNGSpringContextTests {

    private Integer id;

    @Autowired
    dangerPlacesRepository repo;

    @Test
    public void testCreate() throws Exception {

        dangerPlaces dp = new dangerPlaces.Builder("khayalitsa")
                .build();
        repo.save(dp);
        id=dp.getId();
        Assert.assertNotNull(dp.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        dangerPlaces dp = repo.findOne(id);
        Assert.assertEquals("khayalitsa", dp.getAvoidedPlaces());
    }


    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {

        dangerPlaces dp = repo.findOne(id);
        dangerPlaces newdp = new dangerPlaces.Builder(dp.getAvoidedPlaces())
                .copy(dp)
                .avoidedPlaces("Joburg")
                .build();
        repo.save(newdp);
        Assert.assertEquals("Joburg", newdp.getAvoidedPlaces());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        dangerPlaces dp = repo.findOne(id);
        repo.delete(dp);
        dangerPlaces newdp = repo.findOne(id);
        Assert.assertNull(newdp);
    }
}
