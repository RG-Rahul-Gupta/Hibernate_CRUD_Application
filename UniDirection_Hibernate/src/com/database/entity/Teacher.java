package com.database.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Teacher")
public class Teacher {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@Column(name = "f_Name")
	private String f_Name;
	
	@Column(name = "l_Name")
	private String l_Name;
	
	@Column(name = "email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Detail_Id")
	private Teacher_Details teacher_details;
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher( String f_Name, String l_Name, String email) {
	
		this.f_Name = f_Name;
		this.l_Name = l_Name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	
	public Teacher_Details getTeacher_details() {
		return teacher_details;
	}

	public void setTeacher_details(Teacher_Details teacher_details) {
		this.teacher_details = teacher_details;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", f_Name=" + f_Name + ", l_Name=" + l_Name + ", email=" + email + "]";
	}
	
	

}
