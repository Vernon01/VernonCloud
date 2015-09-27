package ReviewAndInformation.Services.Impl;

import ReviewAndInformation.Domain.dangerPlaces;
import ReviewAndInformation.Repository.dangerPlacesRepository;
import ReviewAndInformation.Services.dangerPlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
@Service
public class dangerPlacesServiceImpl implements dangerPlacesService {

    @Autowired
    dangerPlacesRepository repository;

    @Override
    public List<dangerPlaces> getDangerPlaces() {
        List<dangerPlaces> alldangerPlaces = new ArrayList<dangerPlaces>();

        Iterable<dangerPlaces> places = repository.findAll();
        for (dangerPlaces dp : places) {
            alldangerPlaces.add(dp);
        }
        return alldangerPlaces;
    }
}
