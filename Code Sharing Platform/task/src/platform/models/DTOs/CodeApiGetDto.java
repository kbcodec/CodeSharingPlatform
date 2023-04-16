package platform.models.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeApiGetDto {
    @JsonProperty("code")
    private String content;
    @JsonProperty("date")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private String lastUpdate;
    @JsonProperty("time")
    private long timeRestriction;
    @JsonProperty("view")
    private int viewsRestriction;
    @JsonIgnore
    public final static String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
}
