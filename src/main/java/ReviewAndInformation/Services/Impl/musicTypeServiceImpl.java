package ReviewAndInformation.Services.Impl;

import ReviewAndInformation.Domain.musicType;
import ReviewAndInformation.Repository.musicTypeRepository;
import ReviewAndInformation.Services.musicTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
@Service
public class musicTypeServiceImpl implements musicTypeServices {

    @Autowired
    musicTypeRepository repository;

    @Override
    public List<musicType> getMusicTypes() {
        List<musicType> alltypes = new ArrayList<musicType>();

        Iterable<musicType> types = repository.findAll();
        for (musicType mt : types) {
            alltypes.add(mt);
        }
        return alltypes;
    }
}
