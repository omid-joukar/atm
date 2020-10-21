package services;

import com.mysql.cj.protocol.Resultset;
import model.Accounts;
import model.Transactions;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by omid on 10/4/2020.
 */
public class AccountsDao {
    public void insertAccount(String accountName, String accountNumber,String accountPassword,String cardnummber,float balance) {
        Accounts accounts = new Accounts();
        accounts.setBalance(balance);
        accounts.setAccountPassword(accountPassword);
        accounts.setAccountName(accountName);
        accounts.setCardnummber(cardnummber);
        accounts.setAccountNumber(accountNumber);
        try (Session session = HiberConf.getSession();) {
            Transaction tx = session.getTransaction();
            try {
                tx.begin();
                session.save(accounts);
                tx.commit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Accounts getAccount(String accountNumber , String accountPassword) {
        int accountNum = Integer.parseInt(accountNumber);
        String accountPass = accountPassword;
        Accounts target = null;
        try (Session session = HiberConf.getSession();) {
            List<Accounts> accountsList = session.createQuery("from Accounts").getResultList();
            for (Accounts accounts : accountsList){
                if (Integer.parseInt(accounts.getAccountNumber())==accountNum){
                    target = accounts;
                }
            }
        }
        return target;
    }
    public int getAccountId(String accountNumber , String accountPassword) {
        int accountNum = Integer.parseInt(accountNumber);
        String accountPass = accountPassword;
        Accounts target = null;
        try (Session session = HiberConf.getSession();) {
            List<Accounts> accountsList = session.createQuery("from Accounts").getResultList();
            for (Accounts accounts : accountsList){
                if (Integer.parseInt(accounts.getAccountNumber())==accountNum){
                    target = accounts;
                }
            }
        }
        return target.getAccountId();
    }
    public Accounts getAccount(String accountNumber) {
        int accountNum = Integer.parseInt(accountNumber);
        Accounts target = null;
        try (Session session = HiberConf.getSession();) {
            List<Accounts> accountsList = session.createQuery("from Accounts").getResultList();
            for (Accounts accounts : accountsList){
                if (Integer.parseInt(accounts.getAccountNumber())==accountNum){
                    target = accounts;
                }
            }
        }
        return target;
    }
    public void transferMony(int accountId ,int targetAccountId ,float balance){
        Accounts accounts = null;
        Accounts targetAccount = null;
        try(Session session = HiberConf.getSession();){
            Transaction tx = session.getTransaction();
            accounts = session.get(Accounts.class , accountId);
            targetAccount = session.get(Accounts.class , targetAccountId);
            if (accounts == null || targetAccount == null){
                throw new Exception("the targets are null");
            }else {
                tx.begin();
                accounts.setBalance(accounts.getBalance() - balance);
                targetAccount.setBalance(targetAccount.getBalance() + balance);
                session.merge(accounts);
                session.merge(targetAccount);
                tx.commit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void changePassword(String accountNumber , String accountNewPassword){
        String accountNum = accountNumber;
        String accountNewPass = accountNewPassword;
        Accounts target = null;
        try (Session session = HiberConf.getSession();) {
            Transaction tx = session.getTransaction();
            List<Accounts> accountsList = session.createQuery("from Accounts").getResultList();
            for (Accounts accounts : accountsList){
                if (accounts.getAccountNumber().equalsIgnoreCase(accountNum) == true){
                    target = accounts;
                    tx.begin();
                    target.setAccountPassword(accountNewPassword);
                    session.merge(target);
                    tx.commit();
                }
            }
        }
    }

    public void updateAccount(Integer accountId, String accountName, String accountNumber, String accountPassword, String cardnummber) {
        try(Session session = HiberConf.getSession()) {
            Accounts accounts = session.get(Accounts.class,accountId);
            accounts.setAccountName(accountName);
            accounts.setAccountNumber(accountNumber);
            accounts.setAccountPassword(accountPassword);
            accounts.setCardnummber(cardnummber);
            Transaction tx = session.getTransaction();
            try {
                tx.begin();
                session.merge(accounts);
                tx.commit();
            }catch (Exception e){
                tx.rollback();
            }
        }
    }
}
