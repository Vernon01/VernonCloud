package ReviewAndInformation.api;

import ReviewAndInformation.Domain.movie;
import ReviewAndInformation.Model.MovieResource;
import ReviewAndInformation.Services.movieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/24.
 */

@RestController
@RequestMapping(value="/Movie/**")
public class MoviePage {

    @Autowired
    private movieService service;
    @RequestMapping(value="/Movie", method = RequestMethod.GET)
    public List<MovieResource> getMovieInfo(){
        List<MovieResource> hateos = new ArrayList<>();
        List<movie> movies = service.getMovies();
        for (movie ctyInf: movies){
            MovieResource res = new MovieResource
                    .Builder(ctyInf.getName())
                    .residentid(ctyInf.getId())
                    .category("action")
                    .length(86)
                    .build();
            hateos.add(res);
        }
        return hateos;
    }
}
