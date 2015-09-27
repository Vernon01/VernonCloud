package ReviewAndInformation.Services;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.producer;
import ReviewAndInformation.Repository.producerRepository;
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
public class producerServiceTest extends AbstractTestNGSpringContextTests{

    private Integer id;
    @Autowired
    private producerService service ;

    @Autowired
    private producerRepository repo;
    private List<producer> info;

    @Test
    public void testCreate() throws Exception {

        producer prod1 = new producer.Builder("Billy")
                .age(45)
                .yearsProducing(3)
                .build();
        repo.save(prod1);
        id=prod1.getId();
        Assert.assertNotNull(prod1.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testGetCityInfo() throws Exception {
        Assert.assertTrue( service.getProducers().size() == 1);
    }
}
