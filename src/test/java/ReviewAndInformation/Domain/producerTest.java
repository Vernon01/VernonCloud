package ReviewAndInformation.Domain;

import ReviewAndInformation.Factory.producerFactory;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/18.
 */
public class producerTest {

    @Before
    public void setUp() throws Exception {


    }

    /*@Test
    public void testProducer() throws Exception {
        producer pr = new producer.Builder("peter").age(23).yearsProducing(4).build();
        Assert.assertEquals("peter", pr.getName());
    }*/

    @Test
    public void testCreateProducer() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("name","Stark");

        producer pr = producerFactory.createProducer(89, values);

        Assert.assertEquals("Stark", pr.getName());
    }

    @Test
    public void testUpdateProducer() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("name","Stark");

        producer pr = producerFactory.createProducer(89, values);

        producer newproducer = new producer
                .Builder(pr.getName())
                .copy(pr)
                .age(45)
                .yearsProducing(12)
                .build();

        Assert.assertEquals("Stark",newproducer.getName());
        Assert.assertEquals(45,newproducer.getAge());
        Assert.assertEquals(12,newproducer.getYearsProducing());
    }
}
