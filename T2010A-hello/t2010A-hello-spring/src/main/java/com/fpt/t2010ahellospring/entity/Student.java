package com.fpt.t2010ahellospring.entity;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private String rollNumber;
    private String fullName;
    private String phone;
    private String address;
    private LocalDateTime dob;
}
