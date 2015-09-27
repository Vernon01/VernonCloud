package ReviewAndInformation.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/08/24.
 */
public class SingerResource extends ResourceSupport {

    private Integer residentid;
    private String singing;

    private SingerResource()
    {}

    public SingerResource (Builder builder)
    {
        singing = builder.singing;
        residentid = builder.residentid;
    }

    public String getSinging() {return singing;}
    public Integer getResId() {return residentid;}

    public static class Builder {

        private String singing;
        private Integer residentid;

        public Builder(String singing) {
            this.singing = singing;
        }

        public Builder residentid (Integer value)
        {
            this.residentid = value;
            return this;
        }

        public Builder copy(SingerResource value)
        {
            this.singing = value.getSinging();
            this.residentid = value.getResId();
            return this;
        }

        public SingerResource build() {return new SingerResource(this);}
    }
}
