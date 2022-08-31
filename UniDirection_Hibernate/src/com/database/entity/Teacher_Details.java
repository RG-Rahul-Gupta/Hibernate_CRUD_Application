package com.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher_Details")
public class Teacher_Details {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name = "Detail_Id")
private int Detail_Id;

@Column(name = "Address")
private String Address;

@Column(name = "Hobby")
private String Hobby;

public Teacher_Details() {

}

public Teacher_Details(String address, String hobby) {

	Address = address;
	Hobby = hobby;
}

public int getDetail_Id() {
	return Detail_Id;
}

public void setDetail_Id(int detail_Id) {
	Detail_Id = detail_Id;
}

public String getAddress() {
	return Address;
}

public void setAddress(String address) {
	Address = address;
}

public String getHobby() {
	return Hobby;
}

public void setHobby(String hobby) {
	Hobby = hobby;
}

@Override
public String toString() {
	return "Teacher_Details [Detail_Id=" + Detail_Id + ", Address=" + Address + ", Hobby=" + Hobby + "]";
}




}
