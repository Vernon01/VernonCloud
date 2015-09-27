package ReviewAndInformation.Factory;

import ReviewAndInformation.Domain.musicType;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class musicTypeFactory {

    public static musicType createMusicType(String rock, Map<String,String> values)
    {
        musicType mt = new musicType
                .Builder(values.get("rock"))
                .build();
        return mt;
    }
}
