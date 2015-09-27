package ReviewAndInformation.Respository;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.singer;
import ReviewAndInformation.Repository.singerRepository;
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
public class singerRepoTest extends AbstractTestNGSpringContextTests{

    private Integer id;

    @Autowired
    singerRepository repo;

    @Test
    public void testCreate() throws Exception {

        singer si = new singer.Builder("Loyd")
                .build();
        repo.save(si);
        id=si.getId();
        Assert.assertNotNull(si.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        singer si = repo.findOne(id);
        Assert.assertEquals("Loyd", si.getSinging());
    }


    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {

        singer si = repo.findOne(id);
        singer newsi = new singer.Builder("Eminem").id(si.getId())
                .build();
        repo.save(newsi);
        Assert.assertEquals("Eminem", newsi.getSinging());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        singer si = repo.findOne(id);
        repo.delete(si);
        singer newsi = repo.findOne(id);
        Assert.assertNull(newsi);
    }
}
