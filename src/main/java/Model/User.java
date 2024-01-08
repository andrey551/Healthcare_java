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


    @Column(name = "location_id")
    private Long location_id;

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
            Long address_id) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.age = age;
        this.height = height;
        this.location_id = address_id;
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

    public void setLocation_id(Long location_id) {
        this.location_id = location_id;
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

    public Long getLocation_id() {
        return location_id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", address_id=" + location_id +
                '}';
    }
}
