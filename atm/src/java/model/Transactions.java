package model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by omid on 10/4/2020.
 */
@Entity
@Table(name = "transactions")
public class Transactions {
    private Integer transactionId;
    private Date date;
    private String type;
    private Employees employees;
    private Customers customers;
    private Accounts accounts;
    private String targetAccountNumber;
    private Float balance;
    private String status;

    @Id
    @Column(name="transactionId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getTransactionId(){ return transactionId;}
    public void setTransactionId(Integer transactionId){ this.transactionId = transactionId;}
    @Column(name="date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @Column(name="type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "employeeId")
    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "customerId")
    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }
    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "accountId")
    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }
    @Column(name = "targetAccountNumber")
    public String getTargetAccountNumber() {
        return targetAccountNumber;
    }

    public void setTargetAccountNumber(String targetAccountNumber) {
        this.targetAccountNumber = targetAccountNumber;
    }
    @Column(name = "balance")
    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
