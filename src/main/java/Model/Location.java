package Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "location")
public class Location implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "longitude")
    private Float longitude;

    @Column(name = "latitude")
    private Float latitude;

    @Column(name = "name")
    private String name;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "passengers")
    private Long passengers;

    @Column(name = "from")
    private Time from;

    @Column(name = "to")
    private Time to;

    @Column(name = "type")
    private String type;

    public Location(String address,
                    Float longitude,
                    Float latitude,
                    String name,
                    String avatar,
                    Float rating,
                    Long passengers,
                    Time from,
                    Time to,
                    String type) {
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.avatar = avatar;
        this.rating = rating;
        this.passengers = passengers;
        this.from = from;
        this.to = to;
        this.type = type;
    }

    public Location() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public Float getLongitude() {
        return longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setPassengers(Long passengers) {
        this.passengers = passengers;
    }

    public Long getPassengers() {
        return passengers;
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

    public void setTo(Time to) {
        this.to = to;
    }

    public Float getRating() {
        return rating;
    }

    public void setFrom(Time from) {
        this.from = from;
    }

    public Time getTo() {
        return to;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Time getFrom() {
        return from;
    }

    public String getType() {
        return type;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
