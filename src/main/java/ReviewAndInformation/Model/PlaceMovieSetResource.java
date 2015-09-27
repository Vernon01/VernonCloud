package ReviewAndInformation.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/08/24.
 */
public class PlaceMovieSetResource extends ResourceSupport{

    private Integer residentid;
    private String cityDirectedIn;

    private PlaceMovieSetResource()
    {}

    public PlaceMovieSetResource (Builder builder)
    {
        cityDirectedIn = builder.cityDirectedIn;
        residentid = builder.residentid;
    }

    public String getCityDirectedIn() {return cityDirectedIn;}
    public Integer getResId(){return residentid;}

    public static class Builder {

        private String cityDirectedIn;
        private Integer residentid;

        public Builder(String cityDirectedIn) {
            this.cityDirectedIn = cityDirectedIn;
        }

        public Builder residentid(Integer value){
            this.residentid=value;
            return this;
        }

        public Builder copy(PlaceMovieSetResource value)
        {
            this.cityDirectedIn = value.getCityDirectedIn();
            this.residentid = value.getResId();
            return this;
        }

        public PlaceMovieSetResource build() {return new PlaceMovieSetResource(this);}
    }
}
