package platform.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Code {
    @JsonIgnore
    public long id;
    @JsonProperty("code")
    public String content;
    @JsonProperty("date")
    public String lastUpdate;


    @Override
    public String toString() {
        return "Code{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Code code = (Code) o;
        return id == code.id && Objects.equals(content, code.content) && Objects.equals(lastUpdate, code.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, lastUpdate);
    }
}
