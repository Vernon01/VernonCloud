package ReviewAndInformation.Domain;

import ReviewAndInformation.Factory.dangerPlacesFactory;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/18.
 */
public class dangerPlacesTest {

    @Before
    public void setUp() throws Exception {


    }

    /*@Test
    public void testDangerPlaces() throws Exception {
        dangerPlaces dp = new dangerPlaces.Builder("khayalitsa").build();
        Assert.assertEquals("khayalitsa", dp.getAvoidedPlaces());
    }*/

    @Test
    public void testCreateDangerPlaces() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("avoidedPlaces","khayalitsa");

        dangerPlaces dp = dangerPlacesFactory.createCityInfo("khayalitsa", values);

        Assert.assertEquals("khayalitsa", dp.getAvoidedPlaces());
    }

    @Test
    public void testUpdateDangerPlaces() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("avoidedPlaces","khayalitsa");

        dangerPlaces dp = dangerPlacesFactory.createCityInfo("khayalitsa", values);

        dangerPlaces newdangerPlaces = new dangerPlaces
                .Builder(dp.getAvoidedPlaces())
                .copy(dp)
                .build();

        Assert.assertEquals("khayalitsa",newdangerPlaces.getAvoidedPlaces());
    }
}
