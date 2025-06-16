package springmvcproject.one.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public User getUser() {
        Session session = null;
        Transaction transaction = null;
        User user = null;
        
        try {
            session = sessionFactory.openSession(); 
            transaction = session.beginTransaction();
            user = session.get(User.class, 1);
            transaction.commit();
            System.out.println("User retrieved: " + user);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        return user;
    }
}