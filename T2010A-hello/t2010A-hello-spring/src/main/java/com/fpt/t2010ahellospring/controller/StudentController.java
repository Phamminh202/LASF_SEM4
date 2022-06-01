package com.fpt.t2010ahellospring.controller;

import com.fpt.t2010ahellospring.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/student")
public class StudentController {
    private static List<Student> list;
    public StudentController() {
        list = new ArrayList<>();
        list.add(Student.builder().rollNumber("A001").fullName("So01").build());
        list.add(Student.builder().rollNumber("A002").fullName("So02").build());
        list.add(Student.builder().rollNumber("A003").fullName("So03").build());
        list.add(Student.builder().rollNumber("A004").fullName("So04").build());
        list.add(Student.builder().rollNumber("A005").fullName("So05").build());
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> fillAll(){
        return list;
    }

    @RequestMapping(path = "{id}",method = RequestMethod.GET)
    public Student fillById(@PathVariable String id){
        int fountIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)){
                fountIndex = i;
                break;
            }
        }
        if (fountIndex == -1){
            return null;
        }
        return list.get(fountIndex);
    }
    @RequestMapping(method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
        list.add(student);
        return student;
    }
    @RequestMapping(path = "{id}",method = RequestMethod.DELETE)
    public boolean deleteById(@PathVariable String id){
        int fountIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)){
                fountIndex = i;
                break;
            }
        }
        if (fountIndex == -1){
            return false;
        }
        list.remove(fountIndex);
        return true;
    }
    @RequestMapping(path = "{id}",method = RequestMethod.PUT)
    public Student update(@PathVariable String id,@RequestBody Student student){
        int fountIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)){
                fountIndex = i;
                break;
            }
        }
        if (fountIndex == -1){
            return null;
        }
        Student st = list.get(fountIndex);
        st.setFullName(student.getFullName());
        /*st.setPhone(student.getPhone());
        st.setAddress(student.getAddress());
        st.setDob(student.getDob());*/
        return st;
    }
}
