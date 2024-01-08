package Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "chat_id")
    private Long chat_id;

    @Column(name = "time")
    private Time time;

    @Column(name = "text")
    private String text;

    @Column(name = "from")
    private Long from;

    @Column(name = "to")
    private Long to;

    public Message(Long chat_id,
                   String text,
                   Long from,
                   Long to) {
        this.chat_id = chat_id;
        this.text = text;
        this.from = from;
        this.to = to;
        this.time = new Time(System.currentTimeMillis());
    }

    public Message() {

    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public void setChat_id(Long chat_id) {
        this.chat_id = chat_id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Time getTime() {
        return time;
    }

    public Long getChat_id() {
        return chat_id;
    }

    public Long getFrom() {
        return from;
    }

    public Long getTo() {
        return to;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", chat_id=" + chat_id +
                ", time=" + time +
                ", text='" + text + '\'' +
                ", from=" + from +
                ", to=" + to +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
