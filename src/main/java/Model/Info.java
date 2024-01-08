package Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "info")
public class Info implements Serializable {
//    doctor ID
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "experiences")
    private Long experiences;

    @Column(name = "passengers")
    private Long passengers;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "price")
    private Long price;


    @Column(name = "hospital_id")
    private Long hospital_id;

    @Column(name = "specialization_id")
    private Long specialization_id;

    public Info(Long id,
                Long experiences,
                Long passengers,
                Float rating,
                Long price,
                Long hospital_id,
                Long specialization_id) {
        this.id = id;
        this.experiences = experiences;
        this.passengers = passengers;
        this.rating = rating;
        this.price = price;
        this.hospital_id = hospital_id;
        this.specialization_id = specialization_id;
    }

    public Info() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setSpecialization_id(Long specialization_id) {
        this.specialization_id = specialization_id;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setPassengers(Long passengers) {
        this.passengers = passengers;
    }

    public void setHospital_id(Long hospital_id) {
        this.hospital_id = hospital_id;
    }

    public void setExperiences(Long experiences) {
        this.experiences = experiences;
    }

    public Long getSpecialization_id() {
        return specialization_id;
    }

    public Long getPrice() {
        return price;
    }

    public Long getPassengers() {
        return passengers;
    }

    public Long getHospital_id() {
        return hospital_id;
    }

    public Long getExperiences() {
        return experiences;
    }

    public Float getRating() {
        return rating;
    }
    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", experiences=" + experiences +
                ", passengers=" + passengers +
                ", rating=" + rating +
                ", price=" + price +
                ", hospital_id=" + hospital_id +
                ", specialization_id=" + specialization_id +
                '}';
    }
}
