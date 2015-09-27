package ReviewAndInformation.api;

import ReviewAndInformation.Domain.GoToPlaces;
import ReviewAndInformation.Model.GoToPlacesResource;
import ReviewAndInformation.Services.GoToPlacesService;
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
@RequestMapping(value="/GoToPlaces/**")
public class GoToPlacesPage {

    @Autowired
    private GoToPlacesService service;
    @RequestMapping(value="/GoToPlaces", method = RequestMethod.GET)
    public List<GoToPlacesResource> getGoToPlacesInfo(){
        List<GoToPlacesResource> hateos = new ArrayList<>();
        List<GoToPlaces> places = service.getGoPlaces();
        for (GoToPlaces ctyInf: places){
            GoToPlacesResource res = new GoToPlacesResource
                    .Builder(ctyInf.getCityToVisit())
                    .residentid(ctyInf.getId())
                    .build();
            hateos.add(res);
        }
        return hateos;
    }
}
