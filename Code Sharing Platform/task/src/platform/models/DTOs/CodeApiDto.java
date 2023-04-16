package platform.models.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CodeApiDto {
    @JsonProperty("code")
    private String content;
    @JsonProperty("time")
    private long timeRestriction;
    @JsonProperty("view")
    private int viewsRestriction;
}
