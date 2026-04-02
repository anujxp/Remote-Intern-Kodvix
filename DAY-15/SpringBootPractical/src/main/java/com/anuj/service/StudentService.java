package com.anuj.service;

import com.anuj.entity.Student;
import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    void deleteStudent(Long id);
    List<Student> searchStudents(String name);

    Student updateStudent(Long id, Student studentDetails);

    Student updateStudentName(Long id, String newName);
}