package ReviewAndInformation.Services.Impl;

import ReviewAndInformation.Domain.recordLabel;
import ReviewAndInformation.Repository.recordLabelRepository;
import ReviewAndInformation.Services.recordLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/05/20.
 */
@Service
public class recordLabelServiceImpl implements recordLabelService {

    @Autowired
    recordLabelRepository repository;

    @Override
    public List<recordLabel> getRecordLabels() {
        List<recordLabel> allrLabels = new ArrayList<recordLabel>();

        Iterable<recordLabel> labels = repository.findAll();
        for (recordLabel rl : labels) {
            allrLabels.add(rl);
        }
        return allrLabels;
    }
}
