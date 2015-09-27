package ReviewAndInformation.Domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/18.
 */
@Entity
public class movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(unique = true)
    private int length;
    private String category;

    private movie()
    {}

    public movie (Builder builder)
    {
        id=builder.id;
        name = builder.name;
        length = builder.length;
        category = builder.category;

    }

    public String getName() {return name;}
    public int getLength() {return length;}
    public String getCategory() {return category;}
    public Integer getId() {return id;}

    public static class Builder {

        private String name;
        private int length;
        private String category;
        private Integer id;


        public Builder(String name) {
            this.name = name;
        }

        public Builder length(int value) {
            this.length = value;
            return this;
        }

        public Builder category(String value) {
            this.category = value;
            return this;
        }

        public Builder id(Integer value){
            this.id=value;
            return this;
        }


        public Builder copy(movie value)
        {
            this.id=value.getId();
            this.name = value.getName();
            this.length = value.getLength();
            this.category = value.getCategory();
            return this;
        }

        public movie build() {return new movie(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof movie)) return false;

        movie movie = (movie) o;

        if (id != movie.id) return false;
        if (length != movie.length) return false;
        if (category != null ? !category.equals(movie.category) : movie.category != null) return false;
        if (name != null ? !name.equals(movie.name) : movie.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {return name != null ? name.hashCode() : 0;}

    @Override
    public String toString() {
        return "Movie{" +
                "id= " + id +
                "name=" + name +
                ", category='" + category + '\'' +
                '}';
    }
}
