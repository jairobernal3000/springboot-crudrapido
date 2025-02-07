package com.example.crudrapido.service;

import com.example.crudrapido.entity.Student;
import com.example.crudrapido.repository.StudentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudent(UUID id){
        return studentRepository.findById(id);
    }

    public void saveOrUpdate(Student student){
        System.out.println(Objects.toString(student));
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
            System.out.println(json); // Imprime el JSON de manera legible
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        studentRepository.save(student);
    }

    public void delete(UUID id){
        studentRepository.deleteById(id);
    }
}
