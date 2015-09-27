package ReviewAndInformation.Domain;

import ReviewAndInformation.Factory.movieFactory;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/18.
 */
public class movieTest {

    @Before
    public void setUp() throws Exception {


    }

  /*  @Test
    public void testMovie() throws Exception {
        movie mv = new movie.Builder("awesome").category("DL").length(90).build();
        Assert.assertEquals("awesome", mv.getName());
    } */

    @Test
    public void testCreateMovie() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("name","Dark Lies");

        movie mv = movieFactory.createMovie(89,values);

        Assert.assertEquals("Dark Lies",mv.getName());
    }

    @Test
    public void testUpdateMovie() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("name","Dark Lies");

        movie mv1 = movieFactory.createMovie(89,values);

        movie newmovie = new movie
                .Builder(mv1.getName())
                .copy(mv1)
                .length(86)
                .category("Action")
                .build();

        Assert.assertEquals("Dark Lies",newmovie.getName());
        Assert.assertEquals(86,newmovie.getLength());
        Assert.assertEquals("Action",newmovie.getCategory());
    }
}
