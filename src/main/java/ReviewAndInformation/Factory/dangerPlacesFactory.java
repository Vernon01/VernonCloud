package ReviewAndInformation.Factory;

import ReviewAndInformation.Domain.dangerPlaces;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class dangerPlacesFactory {

    public static dangerPlaces createCityInfo(String avoidedPlaces, Map<String,String> values)
    {
        dangerPlaces dp = new dangerPlaces
                .Builder(values.get("avoidedPlaces"))
                .build();
        return dp;
    }
}
