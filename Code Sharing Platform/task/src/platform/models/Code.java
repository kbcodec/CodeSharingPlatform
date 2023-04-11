package platform.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CODE")
public class Code {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "C_ID")
    public long id;
    @JsonProperty("code")
    @Column(name = "C_CONTENT")
    public String content;
    @JsonProperty("date")
    @Column(name = "C_LASTUPDATE")
    public String lastUpdate;
    @Transient
    @JsonIgnore
    private final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";

    public Code (String content) {
        this.content = content;
        this.lastUpdate = DateTimeFormatter.ofPattern(DATE_FORMAT).format(LocalDateTime.now());;

    }

    @Transient
    @JsonIgnore
    public String getDATE_FORMAT() {
        return DATE_FORMAT;
    }

    @JsonIgnore
    public Map<String, String> getIdAsJson() {
        HashMap<String, String> jsonId = new HashMap<>();
        jsonId.put("id", String.valueOf(this.id));
        return jsonId;
    }

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
