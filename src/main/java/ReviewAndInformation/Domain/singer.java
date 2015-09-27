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
public class singer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String singing;

    private singer()
    {}

    public singer (Builder builder)
    {
        singing = builder.singing;
        id = builder.id;
    }

    public String getSinging() {return singing;}
    public Integer getId() {return id;}

    public static class Builder {

        private String singing;
        private Integer id;

        public Builder(String singing) {
            this.singing = singing;
        }

        public Builder id (Integer value)
        {
            this.id = value;
            return this;
        }

        public Builder copy(singer value)
        {
            this.singing = value.getSinging();
            this.id = value.getId();
            return this;
        }

        public singer build() {return new singer(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof singer)) return false;

        singer singer = (singer) o;

        if (id != null ? !id.equals(singer.id) : singer.id != null) return false;
        if (singing != null ? !singing.equals(singer.singing) : singer.singing != null) return false;

        return true;
    }

    @Override
    public int hashCode() {return singing != null ? singing.hashCode() : 0;}

    @Override
    public String toString() {
        return "Singer{" +
                "is the following=" + singing +
                '}';
    }
}
