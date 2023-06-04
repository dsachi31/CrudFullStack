package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee_Entity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String gender;
	private double salary;
	private String location;
	
	public Employee_Entity()
	{
		System.out.println("Entity class executing...");
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Employee_Entity(int id, String name, int age, String gender, double salary, String location) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.location = location;
	}
	@Override
	public String toString() {
		return "Employee_Entity [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", salary="
				+ salary + ", location=" + location + "]";
	}
	
}
