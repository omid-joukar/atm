package model;

import javax.persistence.*;

/**
 * Created by omid on 10/12/2020.
 */
@Entity
@Table(name = "changecardnummber")
public class ChangeCardNummber {
    private Integer id;
    private String userName;
    private String userFamily;
    private String email;
    private String cardnummber;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Column(name = "userFamily")
    public String getUserFamily() {
        return userFamily;
    }

    public void setUserFamily(String userFamily) {
        this.userFamily = userFamily;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "cardnummber")
    public String getCardnummber() {
        return cardnummber;
    }

    public void setCardnummber(String cardnummber) {
        this.cardnummber = cardnummber;
    }
}
