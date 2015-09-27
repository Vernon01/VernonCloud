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
public class placeMovieSet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String cityDirectedIn;

    private placeMovieSet()
    {}

    public placeMovieSet (Builder builder)
    {
        cityDirectedIn = builder.cityDirectedIn;
        id = builder.id;
    }

    public String getCityDirectedIn() {return cityDirectedIn;}
    public Integer getId(){return id;}

    public static class Builder {

        private String cityDirectedIn;
        private Integer id;

        public Builder(String cityDirectedIn) {
            this.cityDirectedIn = cityDirectedIn;
        }

        public Builder id(Integer value){
            this.id=value;
            return this;
        }

        public Builder copy(placeMovieSet value)
        {
            this.cityDirectedIn = value.getCityDirectedIn();
            this.id = value.getId();
            return this;
        }

        public placeMovieSet build() {return new placeMovieSet(this);}
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof placeMovieSet)) return false;

        placeMovieSet that = (placeMovieSet) o;

        if (cityDirectedIn != null ? !cityDirectedIn.equals(that.cityDirectedIn) : that.cityDirectedIn != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {return cityDirectedIn != null ? cityDirectedIn.hashCode() : 0;}

    @Override
    public String toString() {
        return "Movie{" +
                "id" + id +
                "cityDirectedIn=" + cityDirectedIn +
                '}';
    }
}
