package ReviewAndInformation.Services.Impl;

import ReviewAndInformation.Domain.producer;
import ReviewAndInformation.Repository.producerRepository;
import ReviewAndInformation.Services.producerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
@Service
public class producerServiceImpl implements producerService {

    @Autowired
    producerRepository repository;

    @Override
    public List<producer> getProducers() {
        List<producer> allproducers = new ArrayList<producer>();

        Iterable<producer> producers = repository.findAll();
        for (producer pr : producers) {
            allproducers.add(pr);
        }
        return allproducers;
    }
}
