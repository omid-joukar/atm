package services;

import model.ChangeCardNummber;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by omid on 10/12/2020.
 */
public class ChangeCardNummberDao {
    public void insertAplication(String userName, String userFamily, String email, String cardnummber){
        ChangeCardNummber changeCardNummber = new ChangeCardNummber();
        changeCardNummber.setCardnummber(cardnummber);
        changeCardNummber.setEmail(email);
        changeCardNummber.setUserFamily(userFamily);
        changeCardNummber.setUserName(userName);
        try(Session session = HiberConf.getSession()){
         Transaction tx = session.getTransaction();
         try{
             tx.begin();
             session.save(changeCardNummber);
             tx.commit();
         }catch (Exception e){
             tx.rollback();
         }
        }
    }
}
