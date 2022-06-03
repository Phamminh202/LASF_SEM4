package com.fpt.t2010ahellospring.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "students")
public class Student {
    @Id
    private String rollNumber;
    private String fullName;
    private String phone;
    private String email;
    private String address;
    private String note;
    private LocalDateTime dob;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    private int status;
}
