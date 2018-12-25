package com.project.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springBoot.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Student findById(long id);
	
	Long deleteById(Long id);
}
