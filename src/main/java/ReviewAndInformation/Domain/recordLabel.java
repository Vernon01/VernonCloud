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
public class recordLabel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String label;

    private recordLabel()
    {}

    public recordLabel (Builder builder)
    {
        label = builder.label;
        id = builder.id;
    }

    public String getLabel() {return label;}
    public Integer getId() {return id;}

    public static class Builder {

        private String label;
        private Integer id;

        public Builder(String label) {
            this.label = label;
        }

        public Builder id (Integer value)
        {
            this.id = value;
            return this;
        }

        public Builder copy(recordLabel value)
        {
            this.label = value.getLabel();
            this.id = value.getId();
            return this;
        }

        public recordLabel build() {return new recordLabel(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof recordLabel)) return false;

        recordLabel that = (recordLabel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (label != null ? !label.equals(that.label) : that.label != null) return false;

        return true;
    }

    @Override
    public int hashCode() {return label != null ? label.hashCode() : 0;}

    @Override
    public String toString() {
        return "Record Label{" +
                "is=" + label +
                '}';
    }
}
