package ReviewAndInformation.Services.Impl;

import ReviewAndInformation.Domain.placeMovieSet;
import ReviewAndInformation.Repository.placeMovieSetRepository;
import ReviewAndInformation.Services.placeMovieSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
@Service
public class placeMovieSetServiceImpl implements placeMovieSetService {

    @Autowired
    placeMovieSetRepository repository;

    @Override
    public List<placeMovieSet> getPlacesSet() {
        List<placeMovieSet> allplacesSet = new ArrayList<placeMovieSet>();

        Iterable<placeMovieSet> places = repository.findAll();
        for (placeMovieSet ps : places) {
            allplacesSet.add(ps);
        }
        return allplacesSet;
    }
}
