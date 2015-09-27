package ReviewAndInformation.Respository;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.director;
import ReviewAndInformation.Repository.directorRepository;
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
public class directorRepoTest extends AbstractTestNGSpringContextTests {

    private Integer id;

    @Autowired
    directorRepository repo;

    @Test
    public void testCreate() throws Exception {

        director dir1 = new director.Builder("Taker")
                .age(35)
                .yearsDirecting(7)
                .build();
        repo.save(dir1);
        id=dir1.getId();
        Assert.assertNotNull(dir1.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        director dir1 = repo.findOne(id);
        Assert.assertEquals("Taker",dir1.getName());
    }


    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {

        director dr1 = repo.findOne(id);
        director newdirector = new director.Builder(dr1.getName())
                .copy(dr1)
                .age(45)
                .yearsDirecting(12)
                .build();
        repo.save(newdirector);
        Assert.assertEquals(45, newdirector.getAge());
        Assert.assertEquals(12,newdirector.getYearsDirecting());

    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        director dir1 = repo.findOne(id);
        repo.delete(dir1);
        director newdirector = repo.findOne(id);
        Assert.assertNull(newdirector);
    }
}
