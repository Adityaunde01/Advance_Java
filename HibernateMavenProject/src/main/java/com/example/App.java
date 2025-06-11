package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // Create a user
        User user = new User("John Doe", "john@example.com");
        session.save(user);

        // Read a user
        User retrieved = session.get(User.class, user.getId());
        System.out.println("Retrieved: " + retrieved);

        // Update user
        retrieved.setName("Updated John");
        session.update(retrieved);

        // Delete user
        session.delete(retrieved);

        tx.commit();
        session.close();

        HibernateUtil.getSessionFactory().close();
    }
}
