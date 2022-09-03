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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Courses")
public class Courses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "course_id")
	private int course_id;
	
	@Column (name = "course_name")
	private String course_name;
	
	@Column (name = "course_fees")
	private int course_fees;
	
	@ManyToOne(cascade = {CascadeType.DETACH,
			              CascadeType.MERGE,
			              CascadeType.PERSIST,
			              CascadeType.REFRESH})
	@JoinColumn (name ="teacher_id")
	private Teacher teacher_id;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn (name = "review_id")	
	private List<ReviewOfCourses> review_id;

    public Courses() {
				
	}

	public Courses( String course_name, int course_fees) {
		
		this.course_name = course_name;
		this.course_fees = course_fees;
	}
	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getCourse_fees() {
		return course_fees;
	}

	public void setCourse_fees(int course_fees) {
		this.course_fees = course_fees;
	}

	public List<ReviewOfCourses> getReview_id() {
		return review_id;
	}

	public void setReview_id(List<ReviewOfCourses> review_id) {
		this.review_id = review_id;
	}

	public Teacher getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(Teacher teacher_id) {
		this.teacher_id = teacher_id;
	}

	@Override
	public String toString() {
		return "Courses [course_id=" + course_id + ", course_name=" + course_name + ", course_fees=" + course_fees + "]";
	}


	
}
