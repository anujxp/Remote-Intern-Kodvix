package com.anuj.controller;

import com.anuj.entity.Student;
import com.anuj.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // 1. POST (Create) - Returns 201 Created
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    // 2. GET (All) - Returns 200 OK
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // 3. GET (By ID) - Returns 200 OK or 404 Not Found
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.notFound().build();
    }

    // 4. PUT (Full Update) - Replaces the entire resource
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student updatedStudent = studentService.updateStudent(id, studentDetails);
        return ResponseEntity.ok(updatedStudent);
    }

    // 5. PATCH (Partial Update) - Updates only specific fields
    @PatchMapping("/{id}/name")
    public ResponseEntity<Student> updateStudentName(@PathVariable Long id, @RequestParam String newName) {
        Student updatedStudent = studentService.updateStudentName(id, newName);
        return ResponseEntity.ok(updatedStudent);
    }

    // 6. DELETE - Returns 204 No Content (Standard for successful delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    // URL: http://localhost:8081/api/students/search?name=Developer
    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudents(@RequestParam("name") String name) {
        // 1. Call the service layer (which calls the @Param query in the repository)
        List<Student> searchResults = studentService.searchStudents(name);
        return ResponseEntity.ok(searchResults);
    }

}