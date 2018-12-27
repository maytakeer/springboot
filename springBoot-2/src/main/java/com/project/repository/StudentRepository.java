package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Student findById(long id);
	
	Long deleteById(Long id);
}
