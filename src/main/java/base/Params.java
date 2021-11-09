package base;

import com.fasterxml.jackson.annotation.JsonProperty;

@lombok.NoArgsConstructor
@lombok.Data
public class Params {

    @JsonProperty("a")
    private Integer a;
}
