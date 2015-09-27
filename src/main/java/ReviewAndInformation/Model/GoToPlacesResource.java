package ReviewAndInformation.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/08/24.
 */
public class GoToPlacesResource extends ResourceSupport {

    private Integer residentid;
    private String cityToVisit;

    private GoToPlacesResource()
    {}

    public GoToPlacesResource (Builder builder)
    {
        cityToVisit = builder.cityToVisit;
        residentid = builder.residentid;
    }

    public String getCityToVisit() {return cityToVisit;}
    public Integer getResId() {return residentid;}

    public static class Builder {

        private String cityToVisit;
        private Integer residentid;

        public Builder(String cityToVisit) {
            this.cityToVisit = cityToVisit;
        }

        public Builder residentid (Integer value)
        {
            this.residentid = value;
            return this;
        }

        public Builder cityToVisit(String cityToVisit)
        {
            this.cityToVisit = cityToVisit;
            return this;
        }

        public Builder copy(GoToPlacesResource value)
        {
            this.cityToVisit = value.getCityToVisit();
            this.residentid = value.getResId();
            return this;
        }

        public GoToPlacesResource build() {return new GoToPlacesResource(this);}
    }
}
