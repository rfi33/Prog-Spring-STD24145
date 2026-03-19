package com.example.Spring_TD.Controller;

import com.example.Spring_TD.Entity.Student;
import com.example.Spring_TD.Service.StudentService;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/welcome")
    public String welcome(@RequestParam String name){
        return studentService.getWelcomeMessage(name);
    }

    @PostMapping("/students")
    public String addStudent(@RequestBody List<Student> newStudent){
        return studentService.addStudent(newStudent);
    }

    @GetMapping("/students")
    public String getStudent(@RequestHeader("Accept") String accept){
        if(accept.equals("text/plain")){
            return studentService.getStudentName();
        }
        return "Unsupported format";
    }
}
