package com.fpt.t2010ahellospring.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String slug;
    @Column(columnDefinition = "text")
    private String description;
    private String detail;
    @Column(columnDefinition = "text")
    private String image;
    private String producer;

    @CreationTimestamp
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    private int userCreate;
    private int userUpdate;
    private int userDelete;

    private int status;
}