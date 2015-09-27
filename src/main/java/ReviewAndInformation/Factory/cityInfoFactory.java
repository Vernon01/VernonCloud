package ReviewAndInformation.Factory;

import ReviewAndInformation.Domain.cityInfo;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class cityInfoFactory {

    public static cityInfo createCityInfo(String cityDirectedIn, Map<String,String> values)
    {
        cityInfo ci = new cityInfo
                .Builder(values.get("cityInformation"))
                .build();
        return ci;
    }
}
