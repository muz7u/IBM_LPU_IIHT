package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="instructor_details")
public class InstructorDetails
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="course")
	private String course;
	
	@Column(name="hobby")
	private String hobby;

	@JsonBackReference
	@OneToOne(mappedBy="instructorDetails", cascade=CascadeType.ALL)
	private Instructor instructor;

	public InstructorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public InstructorDetails(String course, String hobby, Instructor instructor) {
		super();
		this.course = course;
		this.hobby = hobby;
		this.instructor = instructor;
	}
	



	public Instructor getInstructor() {
		return instructor;
	}


	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public InstructorDetails(String course, String hobby) {
		super();
		this.course = course;
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetails [id=" + id + ", course=" + course + ", hobby=" + hobby + "]";
	}
	
	
	
	
}
