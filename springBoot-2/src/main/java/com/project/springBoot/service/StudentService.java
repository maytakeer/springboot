package com.project.springBoot.service;

import java.util.List;

import com.project.springBoot.entity.Student;

public interface StudentService {
	
	public List<Student> getStudentList();
	
	public Student findStudentById(long id);
	
	public void save(Student student);
	
	public void edit(Student student);
	
	public void delete(long id);
	
}
