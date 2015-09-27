package ReviewAndInformation.api;

import ReviewAndInformation.Domain.recordLabel;
import ReviewAndInformation.Model.RecordLabelResource;
import ReviewAndInformation.Services.recordLabelService;
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
@RequestMapping(value="/RecordLabel/**")
public class RecordLabelPage {

    @Autowired
    private recordLabelService service;
    @RequestMapping(value="/RecordLabel", method = RequestMethod.GET)
    public List<RecordLabelResource> getRecordLabelInfo(){
        List<RecordLabelResource> hateos = new ArrayList<>();
        List<recordLabel> recordl = service.getRecordLabels();
        for (recordLabel ctyInf: recordl){
            RecordLabelResource res = new RecordLabelResource
                    .Builder(ctyInf.getLabel())
                    .residentid(ctyInf.getId())
                    .build();
            hateos.add(res);
        }
        return hateos;
    }
}
