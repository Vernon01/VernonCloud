package ReviewAndInformation.Respository;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.cityInfo;
import ReviewAndInformation.Repository.cityInfoRepository;
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
public class cityInfoRepoTest extends AbstractTestNGSpringContextTests {

    private Integer id;

    @Autowired
    cityInfoRepository repo;

    @Test
    public void testCreate() throws Exception {

        cityInfo cti = new cityInfo.Builder("Good Environment")
                .build();
        repo.save(cti);
        id = cti.getId();
        Assert.assertNotNull(cti.getId());
    }


    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        cityInfo cti = repo.findOne(id);
        Assert.assertEquals("Good Environment", cti.getCityInformation());
    }


    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {

        cityInfo cti = repo.findOne(id);
        cityInfo newcti = new cityInfo.Builder(cti.getCityInformation())
                .copy(cti)
                .cityInformation("Bad Environment")
                .build();
        repo.save(newcti);
        cityInfo updated = repo.findOne(id);
        Assert.assertEquals("Bad Environment", updated.getCityInformation());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        cityInfo cti = repo.findOne(id);
        repo.delete(cti);
        cityInfo newcti = repo.findOne(id);
        Assert.assertNull(newcti);
    }
}
