package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
public List<Student> findByname(String name);
}
