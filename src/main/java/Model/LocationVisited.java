package Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "location_visited")
public class LocationVisited implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "loc_id")
    private Long loc_id;

    @Column(name = "user_id")
    private Long user_id;

    public LocationVisited() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocationVisited(Long loc_id,
                           Long user_id) {
        this.loc_id = loc_id;
        this.user_id = user_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getLoc_id() {
        return loc_id;
    }

    public void setLoc_id(Long loc_id) {
        this.loc_id = loc_id;
    }
}
