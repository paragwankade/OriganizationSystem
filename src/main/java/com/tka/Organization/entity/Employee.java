package com.tka.Organization.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)	
int id;
String name;
String depertment;
String status;
String phoneno;
double salary;
Date createdtm;
String createby;
Date updatedtm;
String updateby;
String emailid;

public Employee() {
	
}

public Employee(String name, String depertment, String status, String phoneno, double salary, Date createdtm,
		String createby, Date updatedtm, String updateby, String emailid, Country country) {
	super();
	this.name = name;
	this.depertment = depertment;
	this.status = status;
	this.phoneno = phoneno;
	this.salary = salary;
	this.createdtm = createdtm;
	this.createby = createby;
	this.updatedtm = updatedtm;
	this.updateby = updateby;
	this.emailid = emailid;
	this.country = country;
}



@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", depertment=" + depertment + ", status=" + status + ", phoneno="
			+ phoneno + ", salary=" + salary + ", createdtm=" + createdtm + ", createby=" + createby + ", updatedtm="
			+ updatedtm + ", updateby=" + updateby + ", emailid=" + emailid + ", country=" + country + "]";
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public String getDepertment() {
	return depertment;
}



public void setDepertment(String depertment) {
	this.depertment = depertment;
}



public String getStatus() {
	return status;
}



public void setStatus(String status) {
	this.status = status;
}



public String getPhoneno() {
	return phoneno;
}



public void setPhoneno(String phoneno) {
	this.phoneno = phoneno;
}



public double getSalary() {
	return salary;
}



public void setSalary(double salary) {
	this.salary = salary;
}



public Date getCreatedtm() {
	return createdtm;
}



public void setCreatedtm(Date createdtm) {
	this.createdtm = createdtm;
}



public String getCreateby() {
	return createby;
}



public void setCreateby(String createby) {
	this.createby = createby;
}



public Date getUpdatedtm() {
	return updatedtm;
}



public void setUpdatedtm(Date updatedtm) {
	this.updatedtm = updatedtm;
}



public String getUpdateby() {
	return updateby;
}



public void setUpdateby(String updateby) {
	this.updateby = updateby;
}



public String getEmailid() {
	return emailid;
}



public void setEmailid(String emailid) {
	this.emailid = emailid;
}



public Country getCountry() {
	return country;
}



public void setCountry(Country country) {
	this.country = country;
}



@ManyToOne
@JoinColumn(name="c_id")
Country country;
}
