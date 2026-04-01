package com.anuj;

import com.anuj.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

class Pagination {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        try (SessionFactory factory = cfg.buildSessionFactory();
             Session session = factory.openSession()) {

            // --- Pagination Variables ---
            int pageSize = 3;    // Number of records per page
            int pageNumber = 1;  // Current page number (1st page)

            // Formula: (pageNumber - 1) * pageSize
            // Page 1 starts at 0, Page 2 starts at 3, etc.
            int startPosition = (pageNumber - 1) * pageSize;

            System.out.println("--- Fetching Page " + pageNumber + " ---");

            // 1. Create HQL Query
            Query<Student> query = session.createQuery("from Student", Student.class);

            // 2. Apply Pagination Methods
            query.setFirstResult(startPosition); // Setting the OFFSET (Where to start)
            query.setMaxResults(pageSize);      // Setting the LIMIT (How many to fetch)

            // 3. Execute and Print
            List<Student> students = query.list();

            for (Student s : students) {
                System.out.println("ID: " + s.getId() + " | Name: " + s.getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}