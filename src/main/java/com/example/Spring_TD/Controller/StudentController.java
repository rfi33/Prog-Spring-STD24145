package com.example.Spring_TD.Controller;

import com.example.Spring_TD.Service.StudentService;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
