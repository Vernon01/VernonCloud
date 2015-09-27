package ReviewAndInformation.api;

import ReviewAndInformation.Domain.movie;
import ReviewAndInformation.Services.movieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by student on 2015/05/21.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {

    @Autowired
    private movieService service;

    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String Index()
    {
        return "Welcome To My HomePage";
    }

    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    public List<movie> getMovies()
    {
        return service.getMovies();
    }
}
