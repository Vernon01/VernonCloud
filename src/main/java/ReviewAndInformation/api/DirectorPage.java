package ReviewAndInformation.api;

import ReviewAndInformation.Domain.director;
import ReviewAndInformation.Model.DirectorResource;
import ReviewAndInformation.Services.directorService;
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
@RequestMapping(value="/Director/**")
public class DirectorPage {

    @Autowired
    private directorService service;
    @RequestMapping(value="/Director", method = RequestMethod.GET)
    public List<DirectorResource> getDirectorInfo(){
        List<DirectorResource> hateos = new ArrayList<>();
        List<director> names = service.getDirectors();
        for (director directorName: names){
            DirectorResource res = new DirectorResource
                    .Builder(directorName.getName())
                    .residentid(directorName.getId())
                    .age(34)
                    .yearsDirecting(2)
                    .build();
            hateos.add(res);
        }
        return hateos;
    }
}
