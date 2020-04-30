package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name ="student")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_roll_no")
	private Integer schoolRollNo;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="student_class")
	private Integer studentClass;
	
	@Column(name="student_school_name")
	private String schoolName;

	public Student(String studentName, Integer studentClass, String schoolName) {
		super();
		this.studentName = studentName;
		this.studentClass = studentClass;
		this.schoolName = schoolName;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
