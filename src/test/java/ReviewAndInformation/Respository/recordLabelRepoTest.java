package ReviewAndInformation.Respository;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.recordLabel;
import ReviewAndInformation.Repository.recordLabelRepository;
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
public class recordLabelRepoTest extends AbstractTestNGSpringContextTests{

    private Integer id;

    @Autowired
    recordLabelRepository repo;

    @Test
    public void testCreate() throws Exception {

        recordLabel rl = new recordLabel.Builder("Shady Records")
                .build();
        repo.save(rl);
        id=rl.getId();
        Assert.assertNotNull(rl.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        recordLabel rl = repo.findOne(id);
        Assert.assertEquals("Shady Records",rl.getLabel());
    }


    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {

        recordLabel rl = repo.findOne(id);
        recordLabel newrl = new recordLabel.Builder("BMG").id(rl.getId())
                .build();
        repo.save(newrl);
        Assert.assertEquals("BMG", newrl.getLabel());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        recordLabel rl = repo.findOne(id);
        repo.delete(rl);
        recordLabel newrl = repo.findOne(id);
        Assert.assertNull(newrl);
    }
}
