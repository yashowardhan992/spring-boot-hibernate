package com.jpacrud.demo.dao;


import com.jpacrud.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {


    //define field for entity manager

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);


        //return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName=:theData",Student.class);

        //set the query parameters
        theQuery.setParameter("theData",theLastName);


        //return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the student

        Student theStudent = entityManager.find(Student.class,id);

        entityManager.remove(theStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("Delete from Student").executeUpdate();
        return numRowsDeleted;
    }


}
