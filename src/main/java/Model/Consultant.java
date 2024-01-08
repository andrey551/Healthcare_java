package Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "consultant")
public class Consultant implements Serializable {
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

    @Column(name = "specialization_id")
    private Long specialization_id;

    public Consultant(Time time,
                      Long user_id,
                      Long hospital_id,
                      Long specialization_id) {
        this.time = time;
        this.user_id = user_id;
        this.hospital_id = hospital_id;
        this.specialization_id = specialization_id;
    }

    public Consultant() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setHospital_id(Long hospital_id) {
        this.hospital_id = hospital_id;
    }

    public void setSpecialization_id(Long specialization_id) {
        this.specialization_id = specialization_id;
    }

    public Time getTime() {
        return time;
    }

    public Long getUser_id() {
        return user_id;
    }

    public Long getHospital_id() {
        return hospital_id;
    }

    public Long getSpecialization_id() {
        return specialization_id;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                "id=" + id +
                ", time=" + time +
                ", user_id=" + user_id +
                ", hospital_id=" + hospital_id +
                ", specialization_id=" + specialization_id +
                '}';
    }
}
