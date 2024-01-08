package Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "chat")
public class Chat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "from")
    private Long from;

    @Column(name = "to")
    private Long to;

    @Column(name = "last_message_id")
    private Long last_message_id;

    public Chat(Long from,
                Long to,
                Long last_message_id) {
        this.from = from;
        this.to = to;
        this.last_message_id = last_message_id;
    }

    public Chat() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public void setLast_message_id(Long last_message_id) {
        this.last_message_id = last_message_id;
    }

    public Long getLast_message_id() {
        return last_message_id;
    }

    public Long getTo() {
        return to;
    }

    public Long getFrom() {
        return from;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                ", last_message_id=" + last_message_id +
                '}';
    }
}
