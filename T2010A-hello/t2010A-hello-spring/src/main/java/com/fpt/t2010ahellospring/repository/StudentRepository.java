package com.fpt.t2010ahellospring.repository;

import com.fpt.t2010ahellospring.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,String> {
}
