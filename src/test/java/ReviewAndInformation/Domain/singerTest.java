package ReviewAndInformation.Domain;

import ReviewAndInformation.Factory.singerFactory;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/18.
 */
public class singerTest {

    @Before
    public void setUp() throws Exception {


    }
    /*@Test
    public void testSinger() throws Exception {
        singer si = new singer.Builder("keysha").build();
        Assert.assertEquals("keysha", si.getSinging());
    }*/

    @Test
    public void testCreateSinger() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("singing","Melodies");

        singer si = singerFactory.createSinger("Melodies", values);

        Assert.assertEquals("Melodies", si.getSinging());
    }

    @Test
    public void testUpdateSinger() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("singing","Melodies");

        singer si = singerFactory.createSinger("Melodies", values);

        singer newsinger = new singer
                .Builder(si.getSinging())
                .copy(si)
                .build();

        Assert.assertEquals("Melodies",newsinger.getSinging());
    }
}
