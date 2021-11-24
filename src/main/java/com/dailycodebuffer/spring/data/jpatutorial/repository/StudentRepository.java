package com.dailycodebuffer.spring.data.jpatutorial.repository;

import com.dailycodebuffer.spring.data.jpatutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long>{

    public List<Student> findByfirstName(String firstName);
    List<Student>findByFirstNameContaining(String name);
    List<Student>findByLastNameNotNull();

    List<Student>findByGuardianName(String GuardianName);
    Student findByFirstNameAndLastName(String firstName,
                                       String lastName);
    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);
}
