package com.collegeStudent.controller;

import java.util.List;

import com.collegeStudent.model.Student;
import com.collegeStudent.services.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/collegeStudent")
public class CollegeStudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping("/listStudent")
	public String listStudent(Model model) {
		System.out.println("List of Students");
		List<Student> students = studentService.getAllStudent();
		model.addAttribute("Student", students);
		return "list-Students";
	}

	@RequestMapping("/formForAdd")
	public String formForAdd(Model model) {
		Student student = new Student();
		model.addAttribute("Student", student);
		return "Student-form";

	}

	@RequestMapping("/formForUpdate")
	public String formForUpdate(@RequestParam("id") int theId, Model model) {
		Student student = studentService.findById(theId);
		model.addAttribute("Student", student);
		return "Student-form";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("studName") String studName,
			@RequestParam("studDept") String studDept, @RequestParam("studCountry") String studCountry) {
		System.out.println(id);
		Student student;
		if (id != 0) {
			student = studentService.findById(id);
			student.setStudName(studName);
			student.setStudDept(studDept);
			student.setStudCountry(studCountry);
		} else
			student = new Student(studName, studDept, studCountry);
		studentService.saveStudent(student);
		return "redirect:/collegeStudent/listStudent";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		studentService.deleteById(id);
		return "redirect:/collegeStudent/listStudent";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "exit";
	}

}
