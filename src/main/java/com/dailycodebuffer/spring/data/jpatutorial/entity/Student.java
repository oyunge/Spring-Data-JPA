package com.dailycodebuffer.spring.data.jpatutorial.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//creating a new table which does exists on the database
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
         name =   "emailId_unique" ,
        columnNames = "email_address"
)
)
public class Student {
    //@id states that each student will have a unique id(studentId)
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long studentId;
    private String firstName;
    private String lastName;
    //defining a new column in our table
    @Column(name = "email_address",
    //every particular time we should be getting this particular values
            nullable = false
    )
    private String emailId;

    @Embedded
    private Guardian guardian;
//    private String guardianName;
//    private String guardianEmail;
//    private String guardianMobile;
}
