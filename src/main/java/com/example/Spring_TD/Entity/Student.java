package com.example.Spring_TD.Entity;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Student {
    private String reference;
    private String lastName;
    private String firstName;
    private int age;
}
