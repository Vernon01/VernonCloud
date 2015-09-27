package ReviewAndInformation.Model;


import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/08/19.
 */
public class CityInfoResource extends ResourceSupport {

    private Integer residentid;
    private String cityInformation;

    private CityInfoResource(){
    }

    public Integer getresidentId() {return residentid;}
    public String getCityInformation() {return cityInformation;}

    public CityInfoResource (Builder builder)
    {
        this.residentid = builder.residentid;
        this.cityInformation = builder.cityInformation;
    }

    public static class Builder{
        private Integer residentid;
        private String cityInformation;

        public Builder(String cityInformation){this.cityInformation=cityInformation;}

        public Builder residentid(Integer value){
            this.residentid=value;
            return this;
        }

        public Builder copy(CityInfoResource value){
            this.residentid=value.residentid;
            this.cityInformation=value.cityInformation;
            return this;
        }

        public CityInfoResource build(){return new CityInfoResource(this);}
    }
}

