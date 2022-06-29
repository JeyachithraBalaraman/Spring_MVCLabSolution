package com.collegeStudent.services;
import java.util.List;

import com.collegeStudent.model.*;
public interface StudentService {
// Create Student & Update
	public void saveStudent(Student student);
//Search by Id 
	public Student findById(int id);
// Delete student
	public void deleteById(int id);
//View All Students
	public List<Student> getAllStudent();

}
