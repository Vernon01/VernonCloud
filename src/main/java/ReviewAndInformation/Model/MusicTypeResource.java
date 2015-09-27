package ReviewAndInformation.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/08/24.
 */
public class MusicTypeResource extends ResourceSupport {

    private Integer residentid;
    private String rock;

    private MusicTypeResource()
    {}

    public MusicTypeResource (Builder builder)
    {
        rock = builder.rock;
        residentid = builder.residentid;
    }

    public String getRock() {return rock;}
    public Integer getResId() {return residentid;}

    public static class Builder {

        private String rock;
        private Integer residentid;

        public Builder(String rock) {
            this.rock = rock;
        }

        public Builder residentid (Integer value)
        {
            this.residentid = value;
            return this;
        }

        public Builder copy(MusicTypeResource value)
        {
            this.rock = value.getRock();
            this.residentid = value.getResId();
            return this;
        }

        public MusicTypeResource build() {return new MusicTypeResource(this);}
    }
}
