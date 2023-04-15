package platform.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Code {
    @Id
    @GeneratedValue
    private UUID id;
    private String content;
    private LocalDateTime lastUpdate;
    private long timeRestriction;
    private LocalDateTime dateToHide;
    private int viewsRestriction;
    private boolean isTimeRestriction;
    private boolean isViewsRestriction;
    private boolean isHide;

    @PrePersist
    protected void onCreate() {
        lastUpdate = LocalDateTime.now();
        isTimeRestriction = timeRestriction > 0;
        isViewsRestriction = viewsRestriction > 0;
        isHide = false;
        dateToHide = lastUpdate.plusSeconds(timeRestriction);
    }

    public boolean isTimeRestriction() {
        return isTimeRestriction;
    }

    public boolean isViewsRestriction() {
        return isViewsRestriction;
    }
}
