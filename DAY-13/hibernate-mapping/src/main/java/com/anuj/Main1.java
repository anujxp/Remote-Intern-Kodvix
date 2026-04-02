package com.anuj;

import com.anuj.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        try (SessionFactory factory = cfg.buildSessionFactory();
             Session session = factory.openSession()) {

            System.out.println("--- 1. Fetching All Students ---");
            Query<Student> query1 = session.createQuery("from Student", Student.class);
            List<Student> allStudents = query1.list();
            allStudents.forEach(s -> System.out.println(s.getName()));

            System.out.println("\n--- 2. Parameterized Query (Filter by City) ---");
            Query<Student> query2 = session.createQuery("from Student where city = :c", Student.class);
            query2.setParameter("c", "Indore");
            List<Student> indoreStudents = query2.list();
            indoreStudents.forEach(s -> System.out.println(s.getName() + " from " ));

            System.out.println("\n--- 3. Search Query (LIKE) ---");
            Query<Student> query3 = session.createQuery("from Student where name like :n", Student.class);
            query3.setParameter("n", "A%"); // Names starting with A
            List<Student> searchResults = query3.list();
            searchResults.forEach(s -> System.out.println("Matches:" + s.getName()));

            System.out.println("\n4. Projection (Select only Names)");
            Query<String> query4 = session.createQuery("select name from Student", String.class);
            List<String> nameList = query4.list();
            System.out.println("All Student Names: " + nameList);

            System.out.println("\n--- 5. Pagination (Top 2 Records) ---");
            Query<Student> query5 = session.createQuery("from Student order by id desc", Student.class);
            query5.setFirstResult(0);
            query5.setMaxResults(2);
            List<Student> paginated = query5.list();
            paginated.forEach(s -> System.out.println("Recent: " + s.getName()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
