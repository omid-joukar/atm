package services;

import model.Customers;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by omid on 10/13/2020.
 */
public class CustomersDao {
    public void insertCustomer(String firstName,String lastName,String address,String telefonnumber,String email,String jobTitle){
        Customers customers = new Customers();
        customers.setFirstName(firstName);
        customers.setLastName(lastName);
        customers.setAddress(address);
        customers.setTelefonnumber(telefonnumber);
        customers.setEmail(email);
        customers.setJobTitle(jobTitle);
        try(Session session = HiberConf.getSession()){
            Transaction tx = session.getTransaction();
            try {
                tx.begin();
                session.save(customers);
                tx.commit();
            }catch (Exception e){
                tx.rollback();
            }
        }
    }
    public int getCustomerId(String firstName , String lastName , String email){
        int customerId = 0;
        try(Session session = HiberConf.getSession()){
         List<Customers> customersList = session.createQuery("from Customers as c where c.firstName = :fn and c.lastName = :ln and c.email = :em")
                 .setString("fn",firstName).setString("ln",lastName).setString("em",email).getResultList();
        for (Customers customers : customersList){
            customerId = customers.getCustomerId();
        }
        }
        return customerId;
    }
}
