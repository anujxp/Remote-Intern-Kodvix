package com.anuj.entities;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "students_mapping")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // Using 'Set' is often preferred in Hibernate to prevent duplicates
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Certificate> certificates = new HashSet<>();

    public Student() {}
    public Student(String name) { this.name = name; }

    public void addCertificate(Certificate cert) {
        certificates.add(cert);
        cert.setStudent(this);
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

    public Set<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(Set<Certificate> certificates) {
        this.certificates = certificates;
    }
}