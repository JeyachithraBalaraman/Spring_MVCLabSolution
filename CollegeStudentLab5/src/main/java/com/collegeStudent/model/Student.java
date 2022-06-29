package com.collegeStudent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "studName")
	private String studName;
	@Column(name = "studDept")
	private String studDept;
	@Column(name = "studCountry")
	private String studCountry;

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public String getStudDept() {
		return studDept;
	}

	public void setStudDept(String studDept) {
		this.studDept = studDept;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getStudCountry() {
		return studCountry;
	}

	public void setStudCountry(String studCountry) {
		this.studCountry = studCountry;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studName=" + studName + ", studDept=" + studDept + ", studCountry="
				+ studCountry + "]";
	}

	public Student(String studName, String studDept, String studCountry) {
		super();
		this.studName = studName;
		this.studDept = studDept;
		this.studCountry = studCountry;
	}

	public Student() {
	}
}
