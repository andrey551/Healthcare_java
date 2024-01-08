package Model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "wallet")
public class Wallet implements Serializable {
//    user ID
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "currency_unit_id")
    private Long currency_unit_id;

    @Column(name = "card_number")
    private String card_number;

    @Column(name = "CVV")
    private String cvv;

    @Column(name = "mmyy")
    private String mmyy;

    public Wallet(Long id,
                  Long balance,
                  Long currency_unit_id,
                  String card_number,
                  String cvc,
                  String mmyy) {
        this.id = id;
        this.balance = balance;
        this.currency_unit_id = currency_unit_id;
        this.card_number = card_number;
        this.cvv = cvc;
        this.mmyy = mmyy;
    }

    public Wallet() {

    }

    public void setMmyy(String mmyy) {
        this.mmyy = mmyy;
    }

    public void setCvv(String cvc) {
        this.cvv = cvc;
    }

    public void setCurrency_unit_id(Long currency_unit_id) {
        this.currency_unit_id = currency_unit_id;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getBalance() {
        return balance;
    }

    public Long getCurrency_unit_id() {
        return currency_unit_id;
    }

    public String getCard_number() {
        return card_number;
    }

    public String getCvv() {
        return cvv;
    }

    public String getMmyy() {
        return mmyy;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", balance=" + balance +
                ", currency_unit_id=" + currency_unit_id +
                ", card_number='" + card_number + '\'' +
                ", cvc='" + cvv + '\'' +
                ", mmyy='" + mmyy + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
