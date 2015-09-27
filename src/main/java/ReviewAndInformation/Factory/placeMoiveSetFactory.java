package ReviewAndInformation.Factory;

import ReviewAndInformation.Domain.placeMovieSet;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class placeMoiveSetFactory {

    public static placeMovieSet createPlaceMS(String cityDirectedIn, Map<String,String> values)
    {
         placeMovieSet place = new placeMovieSet
                .Builder(values.get("cityDirectedIn"))
                .build();
        return place;
    }
}
