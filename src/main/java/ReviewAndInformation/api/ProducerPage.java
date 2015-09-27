package ReviewAndInformation.api;

import ReviewAndInformation.Domain.producer;
import ReviewAndInformation.Model.ProducerResource;
import ReviewAndInformation.Services.producerService;
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
@RequestMapping(value="/ProducerPage/**")
public class ProducerPage {

    @Autowired
    private producerService service;
    @RequestMapping(value="/ProducerPage", method = RequestMethod.GET)
    public List<ProducerResource> getProducerPageInfo(){
        List<ProducerResource> hateos = new ArrayList<>();
        List<producer> prod = service.getProducers();
        for (producer ctyInf: prod){
            ProducerResource res = new ProducerResource
                    .Builder(ctyInf.getName())
                    .residentid(ctyInf.getId())
                    .age(34)
                    .yearsProducing(7)
                    .build();
            hateos.add(res);
        }
        return hateos;
    }
}
