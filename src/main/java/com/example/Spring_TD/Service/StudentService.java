package com.example.Spring_TD.Service;

import lombok.*;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class StudentService {

    public String getWelcomeMessage(String name){
        return "Welcome" + name;
    }
}
