package ReviewAndInformation.Respository;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.musicType;
import ReviewAndInformation.Repository.musicTypeRepository;
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
public class musicTypeRepoTest extends AbstractTestNGSpringContextTests{

    private Integer id;

    @Autowired
    musicTypeRepository repo;

    @Test
    public void testCreate() throws Exception {

        musicType mt = new musicType.Builder("Linkin Park")
                .build();
        repo.save(mt);
        id=mt.getId();
        Assert.assertNotNull(mt.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        musicType mt = repo.findOne(id);
        Assert.assertEquals("Linkin Park", mt.getRock());
    }


    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {

        musicType mt = repo.findOne(id);
        musicType newmt = new musicType.Builder("Mellows").id(mt.getId())
                .build();
        repo.save(newmt);
        Assert.assertEquals("Mellows", newmt.getRock());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        musicType mt = repo.findOne(id);
        repo.delete(mt);
        musicType newmt = repo.findOne(id);
        Assert.assertNull(newmt);
    }
}
