package com.example.Spring_TD.Controller;

import com.example.Spring_TD.Entity.Student;
import com.example.Spring_TD.Service.StudentService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> welcome(@RequestParam(required = false) String name){
        if(name == null || name.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error: the 'name' parameter is required");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.getWelcomeMessage(name));
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
