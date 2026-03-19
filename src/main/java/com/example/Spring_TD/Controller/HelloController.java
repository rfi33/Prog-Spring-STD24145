package com.example.Spring_TD.Controller;

import com.example.Spring_TD.Service.HelloService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/hello-world")

    public String helloWorld(){
        return helloService.HelloMessage();
    }

}
