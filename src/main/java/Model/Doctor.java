package Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "info_id")
    private Long info_id;

    @Column(name = "prize_id")
    private Long prize_id;

    @Column(name = "education_id")
    private Long education_id;

    public Doctor(String name,
                  Long age,
                  Long info_id,
                  Long prize_id,
                  Long education_id) {
        this.name = name;
        this.age = age;
        this.info_id = info_id;
        this.prize_id = prize_id;
        this.education_id = education_id;
    }

    public Doctor() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public void setEducation_id(Long education_id) {
        this.education_id = education_id;
    }

    public void setPrize_id(Long prize_id) {
        this.prize_id = prize_id;
    }

    public void setInfo_id(Long info_id) {
        this.info_id = info_id;
    }

    public String getName() {
        return name;
    }

    public Long getAge() {
        return age;
    }

    public Long getPrize_id() {
        return prize_id;
    }

    public Long getInfo_id() {
        return info_id;
    }

    public Long getEducation_id() {
        return education_id;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", info_id=" + info_id +
                ", prize_id=" + prize_id +
                ", education_id=" + education_id +
                '}';
    }
}
