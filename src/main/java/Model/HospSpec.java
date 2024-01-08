package Model;

import jakarta.persistence.*;

@Entity
@Table(name = "hospspec")
public class HospSpec {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "hosp_id")
    private Long hosp_id;

    @Column(name = "spec_id")
    private Long spec_id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getHosp_id() {
        return hosp_id;
    }

    public Long getSpec_id() {
        return spec_id;
    }

    public void setSpec_id(Long spec_id) {
        this.spec_id = spec_id;
    }

    public void setHosp_id(Long hosp_id) {
        this.hosp_id = hosp_id;
    }

    @Override
    public String toString() {
        return "HospSpec{" +
                "id=" + id +
                ", hosp_id=" + hosp_id +
                ", spec_id=" + spec_id +
                '}';
    }
}
