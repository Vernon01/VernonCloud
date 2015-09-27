package ReviewAndInformation.Services.Impl;

import ReviewAndInformation.Domain.movie;
import ReviewAndInformation.Repository.movieRepository;
import ReviewAndInformation.Services.movieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/19.
 */
@Service
public class movieServiceImpl implements movieService {

    @Autowired
    movieRepository repository;

    @Override
    public List<movie> getMovies() {
        List<movie> allmovies = new ArrayList<movie>();

        Iterable<movie> movies = repository.findAll();
        for (movie mv : movies) {
            allmovies.add(mv);
        }
        return allmovies;
    }
}
