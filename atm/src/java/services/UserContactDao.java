package services;

import model.UserContact;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by omid on 10/11/2020.
 */
public class UserContactDao {
    public void insertUserApplication(String userName ,String userFamily ,String  email ,String textArea){
       UserContact userContact = new UserContact();
       userContact.setText(textArea);
       userContact.setEmail(email);
       userContact.setUserFamily(userFamily);
       userContact.setUserName(userName);
        try(Session session = HiberConf.getSession()) {
            Transaction tx = session.getTransaction();
            try {
                tx.begin();

                session.save(userContact);
                tx.commit();


            } catch (Exception e) {
                tx.rollback();
            }
        }
    }
}
