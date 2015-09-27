package ReviewAndInformation.Domain;

import ReviewAndInformation.Factory.GoToPlacesFactory;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/18.
 */
public class GoToPlacesTest {


    @Before
    public void setUp() throws Exception {


    }

    /*@Test
    public void testGoToPlaces() throws Exception {
        GoToPlaces gtp = new GoToPlaces.Builder("CapeTown").build();
        Assert.assertEquals("CapeTown", gtp.getCityToVisit());
    }*/

    @Test
    public void testCreateGoToPlaces() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("cityToVisit","Sun City");

        GoToPlaces gtp = GoToPlacesFactory.createGoToPlaces("Sun City", values);

        Assert.assertEquals("Sun City", gtp.getCityToVisit());
    }

    @Test
    public void testUpdateGoToPlaces() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("cityToVisit","Sun City");

        GoToPlaces gtp = GoToPlacesFactory.createGoToPlaces("Sun City", values);

        GoToPlaces newGoToPlaces = new GoToPlaces
                .Builder(gtp.getCityToVisit())
                .copy(gtp)
                .build();

        Assert.assertEquals("Sun City",newGoToPlaces.getCityToVisit());
    }
}
