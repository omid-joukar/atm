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
@Table(name = "Customers")
public class Customers {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String telefonnumber;
    private String email;
    private String jobTitle;
    private List<Accounts> accountsList = new ArrayList<>();
    private List<Transactions> transactions = new ArrayList<>();
    @Id
    @Column(name = "customerId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getCustomerId(){
        return customerId;
    }
    public void setCustomerId(Integer customerId){
        this.customerId = customerId;
    }

    @Column(name = "firstName")
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    @Column(name = "lastName")
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @Column(name = "address")
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    @Column(name = "telefonnumber")
    public String getTelefonnumber(){
        return telefonnumber;
    }
    public void setTelefonnumber(String telefonnumber){
        this.telefonnumber = telefonnumber;
    }

    @Column(name = "email")
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){this.email = email;
    }

    @Column(name = "jobTitle")
    public String getJobTitle(){
        return jobTitle;
    }
    public void setJobTitle(String jobTitle){
        this.jobTitle = jobTitle;
    }
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "customeraccount" ,
            joinColumns = @JoinColumn(name = "customerId") ,
            inverseJoinColumns = @JoinColumn(name = "accountId"))
    public List<Accounts> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(List<Accounts> accountsList) {
        this.accountsList = accountsList;
    }
    @OneToMany(mappedBy = "customers")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }
}
