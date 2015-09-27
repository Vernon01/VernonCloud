package ReviewAndInformation.Domain;

import ReviewAndInformation.Factory.directorFactory;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/18.
 */
public class directorTest {

    @Before
    public void setUp() throws Exception {


    }

    /*@Test
    public void testDirector() throws Exception {
        director dr = new director.Builder("darrick").age(23).yearsDirecting(12).build();
        Assert.assertEquals("darrick", dr.getName());
    }*/

    @Test
    public void testCreateDirector() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("name","Tony");

        director dr = directorFactory.createDirector(34, values);

        Assert.assertEquals("Tony", dr.getName());
    }

    @Test
    public void testUpdateDirector() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("name","Tony");

        director dr1 = directorFactory.createDirector(34, values);

        director newdirector = new director
                .Builder(dr1.getName())
                .copy(dr1)
                .age(34)
                .yearsDirecting(3)
                .build();

        Assert.assertEquals("Tony",newdirector.getName());
        Assert.assertEquals(34,newdirector.getAge());
        Assert.assertEquals(3,newdirector.getYearsDirecting());
    }
}
