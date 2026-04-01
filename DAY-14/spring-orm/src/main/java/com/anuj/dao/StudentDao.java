package com.anuj.dao;

import com.anuj.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
//import org.springframework.orm.hibernate6.HibernateTemplate;
//import org.springframework.orm.hibernate6.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class StudentDao {
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int insert(Student student) {
        // save() returns the serializable ID
        Integer i = (Integer) this.hibernateTemplate.save(student);
        return i;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}