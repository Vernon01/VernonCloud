package ReviewAndInformation.Factory;

import ReviewAndInformation.Domain.producer;

import java.util.Map;

/**
 * Created by student on 2015/04/26.
 */
public class producerFactory {

    public static producer createProducer(int name, Map<String,String> values)
    {
        producer pr = new producer
                .Builder(values.get("name"))
                .age(45)
                .yearsProducing(12)
                .build();
        return pr;
    }
}
