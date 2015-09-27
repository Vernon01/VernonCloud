package ReviewAndInformation.Factory;

import ReviewAndInformation.Domain.singer;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class singerFactory {

    public static singer createSinger(String singing, Map<String,String> values)
    {
        singer si = new singer
                .Builder(values.get("singing"))
                .build();
        return si;
    }
}
