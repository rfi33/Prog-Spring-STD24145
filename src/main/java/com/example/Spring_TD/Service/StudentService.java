package com.example.Spring_TD.Service;

import com.example.Spring_TD.Entity.Student;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public String getWelcomeMessage(String name){
        return "Welcome" + name;
    }

    public List<Student> addStudent(List<Student> newStudent){
        students.addAll(newStudent);
        return students;
    }

    public String getStudentName(){
        List<String> names = new ArrayList<>();
        for(Student student : students){
            names.add(student.getFirstName()+" "+student.getLastName());
        }
        return names.toString();
    }
}
