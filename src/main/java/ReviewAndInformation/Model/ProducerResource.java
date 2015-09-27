package ReviewAndInformation.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/08/24.
 */
public class ProducerResource extends ResourceSupport{

    private Integer residentid;
    private String name;
    private int age;
    private int yearsProducing;

    private ProducerResource()
    {}

    public ProducerResource (Builder builder)
    {
        name = builder.name;
        age = builder.age;
        yearsProducing = builder.yearsProducing;
        residentid = builder.residentid;
    }

    public String getName() {return name;}
    public int getAge() {return age;}
    public int getYearsProducing() {return yearsProducing;}
    public Integer getResId() {return residentid;}

    public static class Builder {

        private String name;
        private int age;
        private int yearsProducing;
        private Integer residentid;

        public Builder(String name) {
            this.name = name;
        }

        public Builder age(int value) {
            this.age = value;
            return this;
        }

        public Builder yearsProducing(int value) {
            this.yearsProducing = value;
            return this;
        }

        public Builder residentid (Integer value)
        {
            this.residentid = value;
            return this;
        }

        public Builder copy(ProducerResource value)
        {
            this.name = value.getName();
            this.age = value.getAge();
            this.yearsProducing = value.getYearsProducing();
            this.residentid = value.getResId();
            return this;
        }

        public ProducerResource build() {return new ProducerResource(this);}
    }
}
