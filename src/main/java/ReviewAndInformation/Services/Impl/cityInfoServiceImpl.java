package ReviewAndInformation.Services.Impl;

import ReviewAndInformation.Domain.cityInfo;
import ReviewAndInformation.Repository.cityInfoRepository;
import ReviewAndInformation.Services.cityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/19.
 */
@Service
public class cityInfoServiceImpl implements cityInfoService {

    @Autowired
    cityInfoRepository repository;

    @Override
    public List<cityInfo> getCityInfo() {
        List<cityInfo> allcityInfo = new ArrayList<cityInfo>();
        Iterable<cityInfo> infos = repository.findAll();
        for (cityInfo ci : infos) {
            allcityInfo.add(ci);
        }
        return allcityInfo;
    }
}
