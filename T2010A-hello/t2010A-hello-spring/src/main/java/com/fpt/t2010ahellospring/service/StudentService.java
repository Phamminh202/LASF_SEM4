package com.fpt.t2010ahellospring.service;

import com.fpt.t2010ahellospring.entity.Student;
import com.fpt.t2010ahellospring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Iterable<Student> findALl(){
        return studentRepository.findAll();
    }
    public Optional<Student> findById(String id){
        return studentRepository.findById(id);
    }
    public Student save(Student student){
        return studentRepository.save(student);
    }
    public void deleteById(String id){
        studentRepository.deleteById(id);
    }
}
