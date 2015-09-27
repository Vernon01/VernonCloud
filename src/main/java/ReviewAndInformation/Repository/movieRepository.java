package ReviewAndInformation.Repository;

import ReviewAndInformation.Domain.movie;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by student on 2015/05/13.
 */
public interface movieRepository extends CrudRepository <movie, Integer> {
    //public movie findByName(String name);
}
