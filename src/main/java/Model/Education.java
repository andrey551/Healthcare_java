package Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "education")
public class Education implements Serializable {
//    doctor ID
    @Id
    @Column(name = "id")
    private Long id;


    @Column(name = "institute")
    private String institute;

    @Column(name = "from")
    private Date from;

    @Column(name = "to")
    private Date to;

    public Education(Long id,
                     String institute,
                     Date from,
                     Date to) {
        this.id = id;
        this.institute = institute;
        this.from = from;
        this.to = to;
    }

    public Education() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getInstitute() {
        return institute;
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", institute='" + institute + '\'' +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
