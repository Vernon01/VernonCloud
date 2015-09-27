package ReviewAndInformation.Services;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.placeMovieSet;
import ReviewAndInformation.Repository.placeMovieSetRepository;
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
public class placeMovieSetServiceTest extends AbstractTestNGSpringContextTests{

    private Integer id;
    @Autowired
    private placeMovieSetService service ;

    @Autowired
    private placeMovieSetRepository repo;
    private List<placeMovieSet> info;

    @Test
    public void testCreate() throws Exception {

        placeMovieSet plc = new placeMovieSet.Builder("Stillbaai")
                .build();
        repo.save(plc);
        id=plc.getId();
        Assert.assertNotNull(plc.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testGetCityInfo() throws Exception {
        Assert.assertTrue( service.getPlacesSet().size() == 1);
    }
}
