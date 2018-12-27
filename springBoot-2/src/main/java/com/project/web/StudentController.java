package com.project.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Student;
import com.project.service.StudentService;

@Controller
public class StudentController {
	
	@Resource
	StudentService studentService;
	
	@RequestMapping("/")
	public String index(){
		return "redirect:/list";
	}
	
	@RequestMapping("/list")
	public String list(Model model){
		List<Student> list = studentService.getStudentList();
		model.addAttribute("students",list);
		return "student/list";
	}
	
	@RequestMapping("/toAdd")
	public String toAdd() {
        return "student/studentAdd";
    }
	
	@RequestMapping("/add")
	public String add(Student student){
		studentService.save(student);
		return "redirect:/list";
	}
	
	@RequestMapping("/toEdit")
	public String toEdit(Model model,Long id){
		Student student = studentService.findStudentById(id);
		model.addAttribute("student",student);
		return "student/studentEdit";
	}
	
	@RequestMapping("/edit")
	public String edit(Student student){
		studentService.save(student);
		return "redirect:/list";
	}
	
	@RequestMapping("delete")
	public String delete(Long id){
		studentService.delete(id);
		return "redirect:/list";
	}
}
