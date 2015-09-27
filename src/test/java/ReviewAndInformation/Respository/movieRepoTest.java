package ReviewAndInformation.Respository;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.movie;
import ReviewAndInformation.Repository.movieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by student on 2015/05/14.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class movieRepoTest extends AbstractTestNGSpringContextTests{

    private Integer id;

    @Autowired
    movieRepository repo;

    @Test
    public void testCreate() throws Exception {

        movie mov1 = new movie.Builder("Avo")
                .length(84).category("Comedy").build();
        repo.save(mov1);
        id=mov1.getId();
        Assert.assertNotNull(mov1.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        movie mov1 = repo.findOne(id);
        Assert.assertEquals("Avo",mov1.getName());
    }


    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {

        movie mov1 = repo.findOne(id);
        movie newmovie = new movie.Builder("Halo").id(mov1.getId())
                .length(92).category("Action").build();
        repo.save(newmovie);
        Assert.assertEquals("Halo", newmovie.getName());
        Assert.assertEquals(92, newmovie.getLength());

    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        movie mov1 = repo.findOne(id);
        repo.delete(mov1);
        movie newmovie = repo.findOne(id);
        Assert.assertNull(newmovie);
    }
}
