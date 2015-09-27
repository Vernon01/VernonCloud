package ReviewAndInformation.api;

import ReviewAndInformation.Domain.dangerPlaces;
import ReviewAndInformation.Model.DangerPlacesResource;
import ReviewAndInformation.Services.dangerPlacesService;
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
@RequestMapping(value="/DangerPlaces/**")
public class DangerPlacesPage {

    @Autowired
    private dangerPlacesService service;
    @RequestMapping(value="/DangerPlaces", method = RequestMethod.GET)
    public List<DangerPlacesResource> getDangerPlaces(){
        List<DangerPlacesResource> hateos = new ArrayList<>();
        List<dangerPlaces> places = service.getDangerPlaces();
        for (dangerPlaces ctyInf: places){
            DangerPlacesResource res = new DangerPlacesResource
                    .Builder(ctyInf.getAvoidedPlaces())
                    .residentid(ctyInf.getId())
                    .build();
            hateos.add(res);
        }
        return hateos;
    }
}
