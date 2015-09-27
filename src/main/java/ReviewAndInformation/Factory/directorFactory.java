package ReviewAndInformation.Factory;

import ReviewAndInformation.Domain.director;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class directorFactory {

    public static director createDirector(int name, Map<String,String> values)
    {
        director dr = new director
                .Builder(values.get("name"))
                .age(34)
                .yearsDirecting(3)
                .build();
        return dr;
    }
}
