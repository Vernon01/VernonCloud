package ReviewAndInformation.Domain;

import ReviewAndInformation.Factory.recordLabelFactory;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by student on 2015/04/18.
 */
public class recordLabelTest {

    @Before
    public void setUp() throws Exception {


    }
    /*@Test
    public void testRecordLabel() throws Exception {
        recordLabel rl = new recordLabel.Builder("Shady Records").build();
        Assert.assertEquals("Shady Records", rl.getLabel());
    }*/

    @Test
    public void testCreateRecordLabel() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("label","Shady Records");

        recordLabel rl = recordLabelFactory.createRecordLabel("Shady Records", values);

        Assert.assertEquals("Shady Records", rl.getLabel());
    }

    @Test
    public void testUpdateRecordLabel() throws Exception
    {
        Map<String, String> values = new HashMap();

        values.put("label","Shady Records");

        recordLabel rl = recordLabelFactory.createRecordLabel("Shady Records", values);

        recordLabel newrecordLabel = new recordLabel
                .Builder(rl.getLabel())
                .copy(rl)
                .build();

        Assert.assertEquals("Shady Records",newrecordLabel.getLabel());
    }
}
