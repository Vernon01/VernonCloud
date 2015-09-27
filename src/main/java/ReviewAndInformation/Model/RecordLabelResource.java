package ReviewAndInformation.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by student on 2015/08/24.
 */
public class RecordLabelResource extends ResourceSupport {

    private Integer residentid;
    private String label;

    private RecordLabelResource()
    {}

    public RecordLabelResource (Builder builder)
    {
        label = builder.label;
        residentid = builder.residentid;
    }

    public String getLabel() {return label;}
    public Integer getResId() {return residentid;}

    public static class Builder {

        private String label;
        private Integer residentid;

        public Builder(String label) {
            this.label = label;
        }

        public Builder residentid (Integer value)
        {
            this.residentid = value;
            return this;
        }

        public Builder copy(RecordLabelResource value)
        {
            this.label = value.getLabel();
            this.residentid = value.getResId();
            return this;
        }

        public RecordLabelResource build() {return new RecordLabelResource(this);}
    }
}
