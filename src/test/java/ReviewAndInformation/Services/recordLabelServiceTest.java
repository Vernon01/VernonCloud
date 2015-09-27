package ReviewAndInformation.Services;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.recordLabel;
import ReviewAndInformation.Repository.recordLabelRepository;
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
public class recordLabelServiceTest extends AbstractTestNGSpringContextTests{

    private Integer id;
    @Autowired
    private recordLabelService service ;

    @Autowired
    private recordLabelRepository repo;
    private List<recordLabel> info;

    @Test
    public void testCreate() throws Exception {

        recordLabel rl = new recordLabel.Builder("Owley")
                .build();
        repo.save(rl);
        id=rl.getId();
        Assert.assertNotNull(rl.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testGetCityInfo() throws Exception {
        Assert.assertTrue( service.getRecordLabels().size() == 1);
    }
}
