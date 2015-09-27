package ReviewAndInformation.Domain;

import ReviewAndInformation.Factory.placeMoiveSetFactory;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/18.
 */
public class placeMovieSetTest {

    @Before
    public void setUp() throws Exception {

    }

    /*@Test
    public void testPlaceMovieSet() throws Exception {
        placeMovieSet plms = new placeMovieSet.Builder("France").build();
        Assert.assertEquals("France", plms.getCityDirectedIn());
    }*/

    @Test
    public void testCreatePlaceMovieSet() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("cityDirectedIn","bahamas");

        placeMovieSet place = placeMoiveSetFactory.createPlaceMS("bahamas", values);

        Assert.assertEquals("bahamas", place.getCityDirectedIn());
    }

    @Test
    public void testUpdatePlaceMovieSet() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("cityDirectedIn","bahamas");

        placeMovieSet place = placeMoiveSetFactory.createPlaceMS("bahamas", values);

        placeMovieSet newplace = new placeMovieSet
                .Builder(place.getCityDirectedIn())
                .copy(place)
                .build();

        Assert.assertEquals("bahamas",newplace.getCityDirectedIn());
    }
}
