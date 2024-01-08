package Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "account")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name= "last_checked")
    private Time last_checked;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.last_checked = new Time(System.currentTimeMillis());
    }

    public Account() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setLast_checked(Time last_checked) {
        this.last_checked = last_checked;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Time getLast_checked() {
        return last_checked;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", last_checked=" + last_checked +
                '}';
    }
}

