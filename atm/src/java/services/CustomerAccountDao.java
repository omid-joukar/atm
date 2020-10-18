package services;

import model.CustomerAccount;
import model.CustomerAccountPmk;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by omid on 10/13/2020.
 */
public class CustomerAccountDao {
    public void insertCustomerAccount(int customerId,int accountId){
        CustomerAccountPmk customerAccountPmk = new CustomerAccountPmk();
        customerAccountPmk.setAccountId(accountId);
        customerAccountPmk.setCustomerId(customerId);
        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setId(customerAccountPmk);
        try(Session session = HiberConf.getSession()){
            Transaction tx = session.getTransaction();
            try{
                tx.begin();
                session.save(customerAccount);
                tx.commit();

            }catch (Exception e){
                tx.rollback();
            }
        }
    }
}
