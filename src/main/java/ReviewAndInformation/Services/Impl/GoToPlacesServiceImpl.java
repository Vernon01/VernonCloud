package ReviewAndInformation.Services.Impl;

import ReviewAndInformation.Domain.GoToPlaces;
import ReviewAndInformation.Repository.GoToPlacesRepository;
import ReviewAndInformation.Services.GoToPlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
@Service
public class GoToPlacesServiceImpl implements GoToPlacesService {

    @Autowired
    GoToPlacesRepository repository;

    @Override
    public List<GoToPlaces> getGoPlaces() {
        List<GoToPlaces> allplaces = new ArrayList<GoToPlaces>();

        Iterable<GoToPlaces> places = repository.findAll();
        for (GoToPlaces gtp : places) {
            allplaces.add(gtp);
        }
        return allplaces;
    }
}
