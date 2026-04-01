package com.anuj;

import com.anuj.entities.Certificate;
import com.anuj.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Standard Hibernate Bootstrapping
        Configuration cfg = new Configuration().configure();

        try (SessionFactory factory = cfg.buildSessionFactory();
             Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();

            // Create objects
            Student s1 = new Student("Anuj Gupta");
            Certificate c1 = new Certificate("Hibernate Architecture", s1);
            Certificate c2 = new Certificate("Advanced Mapping", s1);

            s1.addCertificate(c1);
            s1.addCertificate(c2);

            session.persist(s1);

            tx.commit();
            System.out.println("Saved using Hibernate Session!");
        }

        try (SessionFactory factory  = cfg.buildSessionFactory();
                Session session = factory.openSession()) {
            // 1. Create the HQL String (Note: 'Student' is the Class name)
            String hql = "from Student where name = :studentName";

            // 2. Create the Query object
            Query<Student> query = session.createQuery(hql, Student.class);

            // 3. Set Parameter (Prevents SQL Injection)
            query.setParameter("studentName", "Anuj Gupta");

            // 4. Get the result (single result or list)
            Student s = query.uniqueResult();
            System.out.println("Found Student: " + s.getName());
        }
    }
}