package ReviewAndInformation.Services.Impl;

import ReviewAndInformation.Domain.singer;
import ReviewAndInformation.Repository.singerRepository;
import ReviewAndInformation.Services.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
@Service
public class singerServiceImpl implements SingerService {

    @Autowired
    singerRepository repository;

    @Override
    public List<singer> getSingers() {
        List<singer> allsingers = new ArrayList<singer>();

        Iterable<singer> singers = repository.findAll();
        for (singer si : singers) {
            allsingers.add(si);
        }
        return allsingers;
    }
}
