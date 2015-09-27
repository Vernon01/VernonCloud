package ReviewAndInformation.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/08/24.
 */
public class MovieResource extends ResourceSupport {

    private Integer residentid;
    private String name;
    private int length;
    private String category;

    private MovieResource()
    {}

    public MovieResource (Builder builder)
    {
        residentid=builder.residentid;
        name = builder.name;
        length = builder.length;
        category = builder.category;

    }

    public String getName() {return name;}
    public int getLength() {return length;}
    public String getCategory() {return category;}
    public Integer getResId() {return residentid;}

    public static class Builder {

        private String name;
        private int length;
        private String category;
        private Integer residentid;


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

        public Builder residentid(Integer value){
            this.residentid=value;
            return this;
        }


        public Builder copy(MovieResource value)
        {
            this.residentid=value.getResId();
            this.name = value.getName();
            this.length = value.getLength();
            this.category = value.getCategory();
            return this;
        }

        public MovieResource build() {return new MovieResource(this);}
    }
}
