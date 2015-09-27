package ReviewAndInformation.Domain;

import ReviewAndInformation.Factory.musicTypeFactory;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/18.
 */
public class musicTypeTest {

    @Before
    public void setUp() throws Exception {


    }

    /*@Test
    public void testMusicType() throws Exception {
        musicType mt = new musicType.Builder("linkin park").build();
        Assert.assertEquals("linkin park", mt.getRock());
    }*/

    @Test
    public void testCreateMusicType() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("rock","Linkin Park Songs");

        musicType mt = musicTypeFactory.createMusicType("Linkin Park Songs",values);

        Assert.assertEquals("Linkin Park Songs", mt.getRock());
    }

    @Test
    public void testUpdateMusicType() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("rock","Linkin Park Songs");

        musicType mt = musicTypeFactory.createMusicType("Linkin Park Songs", values);

        musicType newMusicType = new musicType
                .Builder(mt.getRock())
                .copy(mt)
                .build();

        Assert.assertEquals("Linkin Park Songs",newMusicType.getRock());
    }
}
