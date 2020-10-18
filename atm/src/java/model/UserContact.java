package model;

import javax.persistence.*;

/**
 * Created by omid on 10/11/2020.
 */
@Entity
@Table(name = "usercontact")
public class UserContact {
    private Integer id;
    private String userName;
    private String userFamily;
    private String email;
    private String text;
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
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
