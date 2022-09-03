package com.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Review_Of_Courses")
public class ReviewOfCourses {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "review_id")
	private int review_id ;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "ratings")
	private int ratings;

	public ReviewOfCourses() {
		
	}

	public ReviewOfCourses(String comment,int ratings) {
		this.comment = comment;
		this.ratings = ratings;
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "ReviewOfCourses [review_id=" + review_id + ", comment=" + comment + ", ratings=" + ratings + "]";
	}
	

}
