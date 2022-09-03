package com.database.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher_Details")
public class Teacher_Details {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "detail_id")
private int detail_id;

@Column(name = "address")
private String address;

@Column(name = "hobby")
private String hobby;

@OneToOne(mappedBy = "detail_id", cascade = CascadeType.ALL)
private Teacher teacher;


public Teacher_Details() {

}

public Teacher_Details(String address, String hobby) {

	this.address = address;
	this.hobby = hobby;
}

public int getDetail_Id() {
	return detail_id;
}

public void setDetail_Id(int detail_Id) {
	detail_id = detail_Id;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getHobby() {
	return hobby;
}

public void setHobby(String hobby) {
	this.hobby = hobby;
}

@Override
public String toString() {
	return "Teacher_Details [Detail_Id=" + detail_id + ", Address=" + address + ", Hobby=" + hobby + "]";
}




}
