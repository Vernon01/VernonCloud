package ReviewAndInformation.Factory;

import ReviewAndInformation.Domain.GoToPlaces;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class GoToPlacesFactory {

    public static GoToPlaces createGoToPlaces(String avoidedPlaces, Map<String,String> values)
    {
        GoToPlaces gtp = new GoToPlaces
                .Builder(values.get("cityToVisit"))
                .build();
        return gtp;
    }
}
