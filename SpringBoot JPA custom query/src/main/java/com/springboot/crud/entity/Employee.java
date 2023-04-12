package com.springboot.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Emp_Id")
	private int id;
	@Column(name = "Emp_Name")
	private String name;
	@Column(name = "Emp_Email")
	private String email;
	@Column(name = "Emp_Mobile")
	private String mobile;
	@Column(name = "Emp_Age")
	private int age;
	@Column(name = "Emp_Salary")
	private double salary;
	@Column(name = "Emp_City")
	private String city;

	public Employee(int id, String name, String email, String mobile, int age, double salary, String city) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.age = age;
		this.salary = salary;
		this.city = city;
	}

	public Employee() {
		super();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", age=" + age
				+ ", salary=" + salary + ", city=" + city + "]";
	}
}
