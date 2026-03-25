package com.example.Spring_TD.Service;

import com.example.Spring_TD.Entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> studentsInMemory = new ArrayList<>();

    public List<Student> saveAll(List<Student> newStudents) {
        studentsInMemory.addAll(newStudents);
        return studentsInMemory;
    }

    public List<Student> getAll() {
        return studentsInMemory;
    }
}