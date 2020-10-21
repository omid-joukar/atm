package services;

import model.Accounts;
import model.Employees;
import model.Transactions;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by omid on 10/19/2020.
 */
public class TransactionsDao {
    public List<Transactions> getTransactionsList(){
        List<Transactions> transactionsList = new ArrayList<>();
        try(Session session = HiberConf.getSession()){
            transactionsList = session.createQuery("from Transactions").getResultList();
        }
        return transactionsList;
    }
    public void insertTransaction(Accounts accounts, String targetAccountNumber, float balance){
        Transactions transactions = new Transactions();
        transactions.setAccounts(accounts);
        transactions.setTargetAccountNumber(targetAccountNumber);
        transactions.setBalance(balance);
        transactions.setCustomers(accounts.getCustomersList().get(0));
        transactions.setType("Online Transfer");
        transactions.setDate(new Date());
        transactions.setStatus("In Order");
        try(Session session = HiberConf.getSession()){
            Transaction tx = session.getTransaction();
            try {
                tx.begin();
                session.save(transactions);
                tx.commit();
            }catch (Exception e){
                tx.rollback();
            }
       }
    }

    public void confirmTransaction(Integer employeeId, Integer transactionId) {
        try(Session session = HiberConf.getSession()){
            Transactions transactions = session.get(Transactions.class , transactionId);
            Employees employees = session.get(Employees.class , employeeId);
            transactions.setEmployees(employees);
            transactions.setStatus("Complete");
                Transaction tx = session.getTransaction();
                try {
                    tx.begin();
                    session.merge(transactions);
                    tx.commit();
                }catch (Exception e){
                    tx.rollback();
                }
            }
    }

    public void rejectTransaction(Integer employeeId, Integer transactionId, Integer accountId, Integer targetAccountNumber, Float balance) {
        try(Session session = HiberConf.getSession()){
            Transactions transactions = session.get(Transactions.class , transactionId);
            Employees employees = session.get(Employees.class , employeeId);
            transactions.setEmployees(employees);
            transactions.setStatus("Reject");
            Transaction tx = session.getTransaction();
            try {
                tx.begin();
                session.merge(transactions);
                tx.commit();
            }catch (Exception e){
                tx.rollback();
            }
        }
    }
    }

