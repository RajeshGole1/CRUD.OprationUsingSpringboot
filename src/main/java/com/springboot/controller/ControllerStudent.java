package com.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.repository.StudentRepository;
import com.springboot.dto.Student;

@RestController
public class ControllerStudent {
	@Autowired
	StudentRepository sr;
	
	@PostMapping("/saveStudentt")
	public String saveStudent(@RequestBody Student s1)
	{
		sr.save(s1);
		return "data saved";
	}
	
	@GetMapping("/SfetchstudentById")
	public Student fetchbyId(@RequestParam int id)
	{
		Optional<Student> o=sr.findById(id);
		Student students=o.get();
		return students;
	}
	
	@GetMapping("/SfetchstudentByname")
	public List<Student> getByName(String name)
	{
		List<Student> student=sr.findByname(name);
		return student;
		
	}
	
	@DeleteMapping("/deleteS")
	public String delete(@RequestParam int id)
	{
		sr.deleteById(id);
		return "Data deleted";
	}
	
	@PutMapping("/updateStd")
	public String updateuser(@RequestBody Student s1)
	{
		sr.save(s1);
		return "data updated";
	}
}
