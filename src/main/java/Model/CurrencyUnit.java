package Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "currency_unit")
public class CurrencyUnit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "unit")
    private String unit;

    public CurrencyUnit(String unit) {
        this.unit = unit;
    }

    public CurrencyUnit() {

    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CurrencyUnit{" +
                "id=" + id +
                ", unit='" + unit + '\'' +
                '}';
    }
}
