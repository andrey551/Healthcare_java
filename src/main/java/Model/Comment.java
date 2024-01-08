package Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "time")
    private Time time;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "hospital_id")
    private Long hospital_id;

    @Column(name = "content")
    private String content;

    public Comment(Time time,
                   Long user_id,
                   Long hospital_id,
                   String content) {
        this.time = time;
        this.user_id = user_id;
        this.hospital_id = hospital_id;
        this.content = content;
    }

    public Comment() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setHospital_id(Long hospital_id) {
        this.hospital_id = hospital_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getHospital_id() {
        return hospital_id;
    }

    public Time getTime() {
        return time;
    }

    public Long getUser_id() {
        return user_id;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", time=" + time +
                ", user_id=" + user_id +
                ", hospital_id=" + hospital_id +
                ", content='" + content + '\'' +
                '}';
    }
}
