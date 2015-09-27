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
public class cityInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer residentid;
    private String cityInformation;

    private cityInfo()
    {}

    public cityInfo (Builder builder)
    {
        cityInformation = builder.cityInformation;
        residentid = builder.residentid;
    }

    public String getCityInformation() {return cityInformation;}
    public Integer getId() {return residentid;}

    public static class Builder {

        private String cityInformation;
        private Integer residentid;

        public Builder(String cityInformation) {
            this.cityInformation = cityInformation;
        }

        public Builder id(Integer value)
        {
            this.residentid = value;
            return this;
        }

        public Builder cityInformation(String cityInformation){
            this.cityInformation = cityInformation;
            return this;
        }

        public Builder copy(cityInfo value)
        {
            this.cityInformation = value.getCityInformation();
            this.residentid = value.getId();
            return this;
        }

        public cityInfo build() {return new cityInfo(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof cityInfo)) return false;

        cityInfo cityInfo = (cityInfo) o;

        if (cityInformation != null ? !cityInformation.equals(cityInfo.cityInformation) : cityInfo.cityInformation != null)
            return false;
        if (residentid != null ? !residentid.equals(cityInfo.residentid) : cityInfo.residentid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {return cityInformation != null ? cityInformation.hashCode() : 0;}

    @Override
    public String toString() {
        return "Places to go to{" +
                "city info=" + cityInformation +
                '}';
    }
}
