package Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "store")
public class Store implements Serializable {
//    location ID
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "passengers")
    private Long passengers;

    @Column(name = "from")
    private Timestamp from;

    @Column(name = "to")
    private Timestamp to;

    public Store(
                    Long id,
                    String name,
                    String avatar,
                    Float rating,
                    Long passengers,
                    Timestamp from,
                    Timestamp to) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.rating = rating;
        this.passengers = passengers;
        this.from = from;
        this.to = to;
    }

    public Store() {

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

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public Float getRating() {
        return rating;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getPassengers() {
        return passengers;
    }

    public void setPassengers(Long passengers) {
        this.passengers = passengers;
    }

    public void setTo(Timestamp to) {
        this.to = to;
    }

    public void setFrom(Timestamp from) {
        this.from = from;
    }

    public Timestamp getFrom() {
        return from;
    }

    public Timestamp getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", rating=" + rating +
                ", passengers=" + passengers +
                '}';
    }
}
