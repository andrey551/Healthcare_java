package Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "prize")
public class Prize implements Serializable {

//doctor ID
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private Long year;

    public Prize(Long id, String name, Long year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public Prize() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Prize{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
