package Raw;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class RawComment {

    private String name;
    private String avatar;
    private String content;
    private Timestamp time;
    private Long rate;
    @Id
    private Long id;

    public RawComment(String name,
                      String avatar,
                      String content,
                      Timestamp time,
                      Long rate) {
        this.avatar = avatar;
        this.name = name;
        this.content = content;
        this.rate = rate;
        this.time = time;
    }

    public RawComment(){};

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public Long getRate() {
        return rate;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
