package ReviewAndInformation.Respository;

import ReviewAndInformation.App;
import ReviewAndInformation.Domain.producer;
import ReviewAndInformation.Repository.producerRepository;
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
public class producerRepoTest extends AbstractTestNGSpringContextTests {

    private Integer id;

    @Autowired
    producerRepository repo;

    @Test
    public void testCreate() throws Exception {

        producer prod1 = new producer.Builder("Sam")
                .age(45)
                .yearsProducing(3)
                .build();
        repo.save(prod1);
        id=prod1.getId();
        Assert.assertNotNull(prod1.getId());
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        producer prod1 = repo.findOne(id);
        Assert.assertEquals("Sam",prod1.getName());
        Assert.assertEquals(3,prod1.getYearsProducing());
    }


    @Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {

        producer prod1 = repo.findOne(id);
        producer newproducer = new producer.Builder("Steve").id(prod1.getId())
                .age(45).yearsProducing(12).build();
        repo.save(newproducer);
        Assert.assertEquals("Steve", newproducer.getName());
        Assert.assertEquals(45, newproducer.getAge());
        Assert.assertEquals(12,newproducer.getYearsProducing());

    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        producer prod1 = repo.findOne(id);
        repo.delete(prod1);
        producer newproducer = repo.findOne(id);
        Assert.assertNull(newproducer);
    }
}
