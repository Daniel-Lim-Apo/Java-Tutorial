package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utilities.SessionFactoryProvider;

public class Create {
    public static void main(String[] args)
    {
        SessionFactory sessionFactory=SessionFactoryProvider.provideSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction t=session.beginTransaction();

        Student s=new Student(101,"John",10);
        session.save(s);
        t.commit();

        sessionFactory.close();
    }
}
