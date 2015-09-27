package ReviewAndInformation.Respository;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.placeMovieSet;
import ReviewAndInformation.Repository.placeMovieSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by student on 2015/05/15.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class placeMovieSetRepoTest extends AbstractTestNGSpringContextTests {

    private Integer id;

    @Autowired
    placeMovieSetRepository repo;

    @Test
    public void testCreate() throws Exception {

        placeMovieSet plc = new placeMovieSet.Builder("Jhb")
                .build();
        repo.save(plc);
        id=plc.getId();
        Assert.assertNotNull(plc.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        placeMovieSet plc = repo.findOne(id);
        Assert.assertEquals("Jhb", plc.getCityDirectedIn());
    }


    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {

        placeMovieSet plc = repo.findOne(id);
        placeMovieSet newplc = new placeMovieSet.Builder("Cpt").id(plc.getId())
                .build();
        repo.save(newplc);
        Assert.assertEquals("Cpt", newplc.getCityDirectedIn());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        placeMovieSet plc = repo.findOne(id);
        repo.delete(plc);
        placeMovieSet newplc = repo.findOne(id);
        Assert.assertNull(newplc);
    }
}
