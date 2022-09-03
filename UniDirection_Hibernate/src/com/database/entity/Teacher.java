package com.database.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Teacher")
public class Teacher {
	
	@Id
	@Column(name = "teacher_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacher_id; 
	
	@Column(name = "f_Name")
	private String f_Name;
	
	@Column(name = "l_Name")
	private String l_Name;
	
	@Column(name = "email")
	private String email;
	
	// Set up Mapping Between Teacher and Teacher_Details One to One UniDirectional 
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="detail_id")
	private Teacher_Details detail_id;
	
	// Set up Mapping Between Teacher and Courses One to Many UniDirectional
	@OneToMany(fetch=FetchType.LAZY,mappedBy="teacher_id",
			   cascade = {CascadeType.DETACH,
	  		              CascadeType.MERGE,
			              CascadeType.PERSIST,
			              CascadeType.REFRESH})
	private List<Courses> course_id;
	
	public Teacher() {
		
	}

	public Teacher( String f_Name, String l_Name, String email) {
	
		this.f_Name = f_Name;
		this.l_Name = l_Name;
		this.email = email;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getF_Name() {
		return f_Name;
	}

	public void setF_Name(String f_Name) {
		this.f_Name = f_Name;
	}

	public String getL_Name() {
		return l_Name;
	}

	public void setL_Name(String l_Name) {
		this.l_Name = l_Name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Teacher_Details getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(Teacher_Details detail_id) {
		this.detail_id = detail_id;
	}

	public List<Courses> getCourse_id() {
		return course_id;
	}

	public void setCourse_id(List<Courses> course_id) {
		this.course_id = course_id;
	}

	@Override
	public String toString() {
		return "Teacher [teacher_id=" + teacher_id + ", f_Name=" + f_Name + ", l_Name=" + l_Name + ", email=" + email+ "]";
	}


}
