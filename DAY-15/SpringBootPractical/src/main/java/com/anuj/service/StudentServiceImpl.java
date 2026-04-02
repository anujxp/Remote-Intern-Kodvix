package com.anuj.service;

import com.anuj.entity.Student;
import com.anuj.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Section 11.7 in your notes
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        // Business Logic Example: Don't save if name is empty
        if(student.getName() == null || student.getName().isEmpty()) {
            throw new RuntimeException("Student name cannot be empty");
        }
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> searchStudents(String name) {
        return studentRepository.searchByName(name);
    }
    @Override
    public Student updateStudent(Long id, Student studentDetails) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        existingStudent.setName(studentDetails.getName());
        return studentRepository.save(existingStudent);
    }

    @Override
    public Student updateStudentName(Long id, String newName) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setName(newName);
        return studentRepository.save(existingStudent);
    }
}