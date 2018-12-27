package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Student;
import com.project.repository.StudentRepository;
import com.project.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getStudentList() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student findStudentById(long id) {
		
		return studentRepository.findById(id);
	}

	@Override
	public void save(Student student) {
		
		studentRepository.save(student);
	}

	@Override
	public void edit(Student student) {
		
		studentRepository.save(student);
	}

	@Override
	public void delete(long id) {
		
		studentRepository.delete(id);
	}

}
