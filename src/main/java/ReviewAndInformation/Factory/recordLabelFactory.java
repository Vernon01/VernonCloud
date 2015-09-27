package ReviewAndInformation.Factory;

import ReviewAndInformation.Domain.recordLabel;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class recordLabelFactory {

    public static recordLabel createRecordLabel(String label, Map<String,String> values)
    {
        recordLabel rl = new recordLabel
                .Builder(values.get("label"))
                .build();
        return rl;
    }
}
