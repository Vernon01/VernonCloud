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
public class musicType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String rock;

    private musicType()
    {}

    public musicType (Builder builder)
    {
        rock = builder.rock;
        id = builder.id;
    }

    public String getRock() {return rock;}
    public Integer getId() {return id;}

    public static class Builder {

        private String rock;
        private Integer id;

        public Builder(String rock) {
            this.rock = rock;
        }

        public Builder id (Integer value)
        {
            this.id = value;
            return this;
        }

        public Builder copy(musicType value)
        {
            this.rock = value.getRock();
            this.id = value.getId();
            return this;
        }

        public musicType build() {return new musicType(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof musicType)) return false;

        musicType musicType = (musicType) o;

        if (id != null ? !id.equals(musicType.id) : musicType.id != null) return false;
        if (rock != null ? !rock.equals(musicType.rock) : musicType.rock != null) return false;

        return true;
    }

    @Override
    public int hashCode() {return rock != null ? rock.hashCode() : 0;}

    @Override
    public String toString() {
        return "Music type{" +
                "Is the following=" + rock +
                '}';
    }
}
