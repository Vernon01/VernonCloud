package ReviewAndInformation.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/04/18.
 */
@Entity
public class GoToPlaces implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String cityToVisit;

    private GoToPlaces()
    {}

    public GoToPlaces (Builder builder)
    {
        cityToVisit = builder.cityToVisit;
        id = builder.id;
    }

    public String getCityToVisit() {return cityToVisit;}
    public Integer getId() {return id;}

    public static class Builder {

        private String cityToVisit;
        private Integer id;

        public Builder(String cityToVisit) {
            this.cityToVisit = cityToVisit;
        }

        public Builder id (Integer value)
        {
            this.id = value;
            return this;
        }

        public Builder cityToVisit(String cityToVisit)
        {
            this.cityToVisit = cityToVisit;
            return this;
        }

        public Builder copy(GoToPlaces value)
        {
            this.cityToVisit = value.getCityToVisit();
            this.id = value.getId();
            return this;
        }

        public GoToPlaces build() {return new GoToPlaces(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoToPlaces)) return false;

        GoToPlaces that = (GoToPlaces) o;

        if (cityToVisit != null ? !cityToVisit.equals(that.cityToVisit) : that.cityToVisit != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {return cityToVisit != null ? cityToVisit.hashCode() : 0;}

    @Override
    public String toString() {
        return "Places to go to{" +
                "city to visit=" + cityToVisit +
                '}';
    }
}
