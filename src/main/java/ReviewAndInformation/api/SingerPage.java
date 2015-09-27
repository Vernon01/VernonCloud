package ReviewAndInformation.api;

import ReviewAndInformation.Domain.singer;
import ReviewAndInformation.Model.SingerResource;
import ReviewAndInformation.Services.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/12.
 */

@RestController
@RequestMapping(value="/SingerPage/**")
public class SingerPage {

    @Autowired
    private SingerService service;
    @RequestMapping(value="/SingerPage", method = RequestMethod.GET)
    public List<SingerResource> getSingerInfo(){
        List<SingerResource> hateos = new ArrayList<>();
        List<singer> recordl = service.getSingers();
        for (singer sing: recordl){
            SingerResource res = new SingerResource
                    .Builder(sing.getSinging())
                    .residentid(sing.getId())
                    .build();
            hateos.add(res);
        }
        return hateos;
    }
}
