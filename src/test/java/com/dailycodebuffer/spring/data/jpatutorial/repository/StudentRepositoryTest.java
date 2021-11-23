package com.dailycodebuffer.spring.data.jpatutorial.repository;

import com.dailycodebuffer.spring.data.jpatutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
//is used for testing repositories
//@DataJpaTest
class StudentRepositoryTest {
    @Autowired
private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("sam371@gmail.com")
                .firstName("edwin")
                .lastName("edwin")
//                .guardianName("sam")
//                .guardianEmail("sam2@gmail.com")
//                .guardianMobile("1234567897")
                .build();

        studentRepository.save(student);
    }
@Test
    public void saveStudentWithGuardian(){
Guardian guardian = Guardian.builder()
        .email("sam2@gmail.com")
        .name("samwel")
        .mobile("999999999")
        .build();

 Student student = Student.builder()
         .firstName("shivan")
         .emailId("edu@gmail.com")
         .lastName("ochako")
         //it will take the entire guardian object
         .guardian(guardian)
         .build();

 studentRepository.save(student);
    }
    @Test
    public  void printAllStudent(){
        List<Student>studentList =
                studentRepository.findAll();
        System.out.println("studentList =" + studentList);
    }
}