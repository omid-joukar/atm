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
@Table(name = "accounts")
public class Accounts {
    private Integer accountId;
    private String accountName;
    private String accountNumber;
    private String accountPassword;
    private String cardnummber;
    private Float balance;
    private List<Customers> customersList = new ArrayList<>();
    private List<Transactions> transactionsList = new ArrayList<>();

    @Id
    @Column(name = "accountId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
    @Column (name= "accountName")
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    @Column(name = "accountNumber")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    @Column(name = "accountPassword")
    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }
    @Column(name = "balance")
    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
    @Column(name = "cardnummber")
    public String getCardnummber() {
        return cardnummber;
    }

    public void setCardnummber(String cardnummber) {
        this.cardnummber = cardnummber;
    }

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "customeraccount" ,
            joinColumns = @JoinColumn(name = "accountId") ,
            inverseJoinColumns = @JoinColumn(name = "customerId"))
    public List<Customers> getCustomersList() {
        return customersList;
    }

    public void setCustomersList(List<Customers> customersList) {
        this.customersList = customersList;
    }
    @OneToMany( mappedBy = "accounts")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }
}
