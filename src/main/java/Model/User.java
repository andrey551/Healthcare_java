package Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name= "usertb")
public class User implements Serializable {
//account ID
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "age")
    private Long age;

    @Column(name = "height")
    private Long height;


    @Column(name = "longitude")
    private Float longitude;

    @Column(name = "latitude")
    private Float latitude;

    public User() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public User(
            Long id,
            String name,
            String avatar,
            Long age,
            Long height,
            Float longitude,
            Float latitude) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.age = age;
        this.height = height;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public void setAge(Long age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public Long getHeight() {
        return height;
    }

    public Long getAge() {
        return age;
    }


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
