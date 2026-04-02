package com.anuj.repository;

import com.anuj.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Marks this as a Data Access Object (DAO)
public interface StudentRepository extends JpaRepository<Student, Long> {

    // You don't need to write any code here for basic CRUD!
    // JpaRepository already provides:
    // save(), findById(), findAll(), deleteById(), existsById(), etc.
    Student findByName(String name);
    List<Student> findByNameContaining(String namePart);

    @Query("SELECT s FROM Student s WHERE s.name = :stName")
    Student findStudentByExactName(@Param("stName") String name);

    // 2. Native SQL Query (Works on Table/Column names)
    @Query(value = "SELECT * FROM students WHERE name LIKE %:keyword%",nativeQuery = true)
    List<Student> searchByName(@Param("keyword") String keyword);
}