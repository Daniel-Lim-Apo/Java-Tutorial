package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utilities.SessionFactoryProvider;

public class Update {
    public static void main(String[] args)
    {
        SessionFactory sessionFactory=SessionFactoryProvider.provideSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction t=session.beginTransaction();

        Student s=session.get(Student.class, 101);
        s.setStd(11);
        session.save(s);
        t.commit();

        sessionFactory.close();
    }
}
