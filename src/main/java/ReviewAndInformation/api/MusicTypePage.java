package ReviewAndInformation.api;

import ReviewAndInformation.Domain.musicType;
import ReviewAndInformation.Model.MusicTypeResource;
import ReviewAndInformation.Services.musicTypeServices;
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
@RequestMapping(value="/MusicType/**")
public class MusicTypePage {

    @Autowired
    private musicTypeServices service;
    @RequestMapping(value="/MusicType", method = RequestMethod.GET)
    public List<MusicTypeResource> getMusicTypeInfo(){
        List<MusicTypeResource> hateos = new ArrayList<>();
        List<musicType> type = service.getMusicTypes();
        for (musicType ctyInf: type){
            MusicTypeResource res = new MusicTypeResource
                    .Builder(ctyInf.getRock())
                    .residentid(ctyInf.getId())
                    .build();
            hateos.add(res);
        }
        return hateos;
    }
}
