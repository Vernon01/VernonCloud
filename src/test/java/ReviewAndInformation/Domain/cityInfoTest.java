package ReviewAndInformation.Domain;

import ReviewAndInformation.Factory.cityInfoFactory;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/18.
 */
public class cityInfoTest {

    @Before
    public void setUp() throws Exception {

    }

    /*@Test
    public void testCityInfo() throws Exception {
        cityInfo ci = new cityInfo.Builder("Big city to explore").build();
        Assert.assertEquals("Big city to explore", ci.getCityInformation());
    }*/

    @Test
    public void testCreatePlaceMovieSet() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("cityInformation","Big bright city");

        cityInfo ci = cityInfoFactory.createCityInfo("Big bright city", values);

        Assert.assertEquals("Big bright city", ci.getCityInformation());
    }

    @Test
    public void testUpdatePlaceMovieSet() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("cityInformation","Big bright city");

        cityInfo ci = cityInfoFactory.createCityInfo("Big bright city", values);

        cityInfo newcityInfo = new cityInfo
                .Builder(ci.getCityInformation())
                .copy(ci)
                .build();

        Assert.assertEquals("Big bright city",newcityInfo.getCityInformation());
    }
}
