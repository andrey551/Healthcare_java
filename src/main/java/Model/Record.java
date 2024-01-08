package Model;

import jakarta.persistence.*;
import Utils.issueAnalyser;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "record")
public class Record implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Long id;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "weight")
    private Long weight;

    @Column(name= "height")
    private Long height;

    @Column(name = "heart_beat")
    private Long heart_beat;

    @Column(name = "blood_pressure")
    private Long blood_pressure;

    @Column(name = "cholesterol")
    private Long cholesterol;

    @Column(name = "analysis")
    private String analysis;

    @Column(name = "user_id")
    private Long user_id;

    public Record( Long heart_beat, Long blood_pressure, Long cholesterol, Long weight, Long height, Long user_id) {
        this.time = new Timestamp(System.currentTimeMillis());
        this.heart_beat = heart_beat;
        this.blood_pressure = blood_pressure;
        this.cholesterol = cholesterol;
        this.analysis = issueAnalyser.fakeAnalyser(time, heart_beat, blood_pressure, cholesterol);
        this.user_id = user_id;
        this.weight = weight;
        this.height = height;
    }

    public Record() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public void setHeartbeat(Long heart_beat) {
        this.heart_beat = heart_beat;
    }

    public void setCholesterol(Long cholesterol) {
        this.cholesterol = cholesterol;
    }

    public void setBloodPressure(Long blood_pressure) {
        this.blood_pressure = blood_pressure;
    }

    public String getAnalysis() {
        return analysis;
    }

    public Long getHeartBeat() {
        return heart_beat;
    }

    public Long getBloodPressure() {
        return blood_pressure;
    }

    public Long getCholesterol() {
        return cholesterol;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public Long getHeight() {
        return height;
    }

    public Long getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", time=" + time +
                ", heart beat=" + heart_beat +
                ", blood pressure=" + blood_pressure +
                ", cholesterol=" + cholesterol +
                ", analysis='" + analysis + '\'' +
                '}';
    }
}

