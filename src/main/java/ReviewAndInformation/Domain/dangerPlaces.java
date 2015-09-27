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
public class dangerPlaces implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String avoidedPlaces;

    private dangerPlaces()
    {}

    public dangerPlaces (Builder builder)
    {
        avoidedPlaces = builder.avoidedPlaces;
        id = builder.id;
    }

    public String getAvoidedPlaces() {return avoidedPlaces;}
    public Integer getId() {return id;}

    public static class Builder {

        private String avoidedPlaces;
        private Integer id;

        public Builder(String avoidedPlaces) {
            this.avoidedPlaces = avoidedPlaces;
        }

        public Builder id(Integer value)
        {
            this.id = value;
            return this;
        }
        public Builder avoidedPlaces(String avoidedPlaces){
            this.avoidedPlaces = avoidedPlaces;
            return this;
        }

        public Builder copy(dangerPlaces value)
        {
            this.avoidedPlaces = value.getAvoidedPlaces();
            this.id = value.getId();
            return this;
        }

        public dangerPlaces build() {return new dangerPlaces(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof dangerPlaces)) return false;

        dangerPlaces that = (dangerPlaces) o;

        if (avoidedPlaces != null ? !avoidedPlaces.equals(that.avoidedPlaces) : that.avoidedPlaces != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {return avoidedPlaces != null ? avoidedPlaces.hashCode() : 0;}

    @Override
    public String toString() {
        return "Places to go to{" +
                "city to stay away from=" + avoidedPlaces +
                '}';
    }
}
