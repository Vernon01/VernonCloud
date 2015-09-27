package ReviewAndInformation.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/08/24.
 */
public class DirectorResource extends ResourceSupport {

    private Integer residentid;
    private String name;
    private int age;
    private int yearsDirecting;

    private DirectorResource()
    {}

    public DirectorResource (Builder builder)
    {
        name = builder.name;
        age = builder.age;
        yearsDirecting = builder.yearsDirecting;
        residentid = builder.residentid;
    }

    public String getName() {return name;}
    public int getAge() {return age;}
    public int getYearsDirecting() {return yearsDirecting;}
    public Integer getResId() {return residentid;}

    public static class Builder {

        private String name;
        private int age;
        private int yearsDirecting;
        private Integer residentid;

        public Builder(String name) {
            this.name = name;
        }

        public Builder age(int value) {
            this.age = value;
            return this;
        }

        public Builder yearsDirecting(int value) {
            this.yearsDirecting = value;
            return this;
        }

        public Builder residentid (Integer value)
        {
            this.residentid = value;
            return this;
        }

        public Builder copy(DirectorResource value)
        {
            this.name = value.getName();
            this.age = value.getAge();
            this.yearsDirecting = value.getYearsDirecting();
            this.residentid = value.getResId();
            return this;
        }

        public DirectorResource build() {return new DirectorResource(this);}
    }
}
