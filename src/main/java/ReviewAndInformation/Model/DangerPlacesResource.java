package ReviewAndInformation.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/08/24.
 */
public class DangerPlacesResource extends ResourceSupport {

    private Integer residentid;
    private String avoidedPlaces;

    private DangerPlacesResource()
    {}

    public DangerPlacesResource (Builder builder)
    {
        avoidedPlaces = builder.avoidedPlaces;
        residentid = builder.residentid;
    }

    public String getAvoidedPlaces() {return avoidedPlaces;}
    public Integer getResId() {return residentid;}

    public static class Builder {

        private String avoidedPlaces;
        private Integer residentid;

        public Builder(String avoidedPlaces) {
            this.avoidedPlaces = avoidedPlaces;
        }

        public Builder residentid(Integer value) {
            this.residentid = value;
            return this;
        }

        public Builder avoidedPlaces(String avoidedPlaces) {
            this.avoidedPlaces = avoidedPlaces;
            return this;
        }

        public Builder copy(DangerPlacesResource value) {
            this.avoidedPlaces = value.getAvoidedPlaces();
            this.residentid = value.getResId();
            return this;
        }

        public DangerPlacesResource build() {
            return new DangerPlacesResource(this);
        }
    }
}
