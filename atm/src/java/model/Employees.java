package model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by omid on 10/4/2020.
 */
@Entity
@Table(name = "employees")
public class Employees {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String employeepassword;
    private String address;
    private String telefonnumber;
    private String email;
    private String jobTitle;
    private Employees reportsTo;
    private List<Transactions> transactions = new ArrayList<>();
    @Id
    @Column(name = "employeeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column(name = "employeepassword")
    public String getEmployeepassword() {
        return employeepassword;
    }

    public void setEmployeepassword(String employeepassword) {
        this.employeepassword = employeepassword;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Column(name = "telefonnumber")
    public String getTelefonnumber() {
        return telefonnumber;
    }

    public void setTelefonnumber(String telefonnumber) {
        this.telefonnumber = telefonnumber;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "jobTitle")
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "reportsTo")
    public Employees getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employees reportsTo) {
        this.reportsTo = reportsTo;
    }
    @OneToMany(mappedBy = "employees")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }
}