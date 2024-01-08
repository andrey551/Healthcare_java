package Model;

import jakarta.persistence.*;

import java.io.Serializable;

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

    public Store(
                    Long id,
                    String name,
                    String avatar,
                    Float rating,
                    Long passengers) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.rating = rating;
        this.passengers = passengers;
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
