package ReviewAndInformation.Services;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.movie;
import ReviewAndInformation.Repository.movieRepository;
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
public class movieServiceTest extends AbstractTestNGSpringContextTests{

    private Integer id;
    @Autowired
    private movieService service ;

    @Autowired
    private movieRepository repo;
    private List<movie> info;

    @Test
    public void testCreate() throws Exception {

        movie mov1 = new movie.Builder("blake")
                .length(84).category("Crime").build();
        repo.save(mov1);
        id=mov1.getId();
        Assert.assertNotNull(mov1.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testGetCityInfo() throws Exception {
        Assert.assertTrue( service.getMovies().size() == 1);
    }
}
