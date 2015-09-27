package ReviewAndInformation.api;

import ReviewAndInformation.Domain.cityInfo;
import ReviewAndInformation.Model.CityInfoResource;
import ReviewAndInformation.Services.cityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/08/19.
 */

@RestController
@RequestMapping(value="/City/**")
public class CityInfoPage {

    @Autowired
    private cityInfoService service;
    @RequestMapping(value="/CityInfo", method = RequestMethod.GET)
    public List<CityInfoResource> getCityInfo(){
        List<CityInfoResource> hateos = new ArrayList<>();
        List<cityInfo> cities = service.getCityInfo();
        for (cityInfo ctyInf: cities){
            CityInfoResource res = new CityInfoResource
                    .Builder(ctyInf.getCityInformation())
                    .residentid(ctyInf.getId())
                    .build();
            hateos.add(res);
        }
        return hateos;
    }
}
