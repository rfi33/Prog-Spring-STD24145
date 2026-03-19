package com.example.Spring_TD.Controller;

import com.example.Spring_TD.Entity.Student;
import com.example.Spring_TD.Service.StudentService;
import lombok.*;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<Student>> addStudent(@RequestBody List<Student> newStudent){
        try {
            List<Student> students = studentService.addStudent(newStudent);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(students);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @GetMapping("/students")
    public ResponseEntity<Object> getStudent(@RequestHeader("Accept") String accept){
       try{
           if(accept == null || accept.isEmpty()){
               return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                       .body("ERROR : the 'Accept' header is required");
           }
           if (accept.equals("text/plain") || accept.equals("application/json")) {
               return ResponseEntity.status(HttpStatus.OK)
                       .body(studentService.getStudents());
           }
           return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                   .body("Unsupported format");
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .build();
       }
    }
}
