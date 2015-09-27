package ReviewAndInformation.Services.Impl;

import ReviewAndInformation.Domain.director;
import ReviewAndInformation.Repository.directorRepository;
import ReviewAndInformation.Services.directorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
@Service
public class directorServiceImpl implements directorService {

    @Autowired
    directorRepository repository;

    @Override
    public List<director> getDirectors() {
        List<director> alldirectors = new ArrayList<director>();

        Iterable<director> directors = repository.findAll();
        for (director dr : directors) {
            alldirectors.add(dr);
        }
        return alldirectors;
    }
}
