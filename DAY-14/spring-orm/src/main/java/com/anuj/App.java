package com.anuj;

import com.anuj.dao.StudentDao;
import com.anuj.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        // Load Configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        // Get DAO Bean
        StudentDao dao = context.getBean("studentDao", StudentDao.class);

        // Create Student Object
        Student s = new Student(101, "Anuj Gupta");

        // Save to Database
        int result = dao.insert(s);
        System.out.println("Inserted student with ID: " + result);
    }
}
