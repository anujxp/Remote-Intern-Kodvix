package com.anuj.entities;

import jakarta.persistence.*; // Hibernate 6 uses these as the base
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "certificates")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "student_id")
    // Pure Hibernate annotation to handle database-level deletes
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Student student;

    public Certificate() {}
    public Certificate(String name, Student student) {
        this.name = name;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}