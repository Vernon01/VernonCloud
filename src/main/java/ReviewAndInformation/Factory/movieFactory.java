package ReviewAndInformation.Factory;

import ReviewAndInformation.Domain.movie;

import java.util.Map;

/**
 * Created by student on 2015/04/25.
 */
public class movieFactory {

    public static movie createMovie(int length, Map<String,String> values)
    {
        movie mv = new movie
                .Builder(values.get("name"))
                .length(89)
                .category(values.get("category"))
                .build();
        return mv;
    }
}
