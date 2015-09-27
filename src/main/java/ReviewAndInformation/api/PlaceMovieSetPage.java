package ReviewAndInformation.api;

import ReviewAndInformation.Domain.placeMovieSet;
import ReviewAndInformation.Model.PlaceMovieSetResource;
import ReviewAndInformation.Services.placeMovieSetService;
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
@RequestMapping(value="/PlaceMovieSet/**")
public class PlaceMovieSetPage {

    @Autowired
    private placeMovieSetService service;
    @RequestMapping(value="/PlaceMovieSet", method = RequestMethod.GET)
    public List<PlaceMovieSetResource> getPlaceMovieSetInfo(){
        List<PlaceMovieSetResource> hateos = new ArrayList<>();
        List<placeMovieSet> placems = service.getPlacesSet();
        for (placeMovieSet ctyInf: placems){
            PlaceMovieSetResource res = new PlaceMovieSetResource
                    .Builder(ctyInf.getCityDirectedIn())
                    .residentid(ctyInf.getId())
                    .build();
            hateos.add(res);
        }
        return hateos;
    }
}
