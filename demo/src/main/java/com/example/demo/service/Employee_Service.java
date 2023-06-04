package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Employee_dao;
import com.example.demo.entities.Employee_Entity;

@Service
public class Employee_Service {
	@Autowired
	private Employee_dao dao;
	
	public Employee_Service()
	{
		System.out.println("Service class executing..");
	}

	public Employee_Entity add(Employee_Entity employee) {
		
	Employee_Entity s  = dao.findByName(employee.getName());
		if(s==null)
		{
			
			return dao.save(employee);
		}
		else
		{
			return null;
		}
	}

	public List<Employee_Entity> getall() {
		
		return dao.findAll();
		
	}

	public Optional<Employee_Entity> getbid(int id) {
		boolean result = dao.existsById(id);
		// TODO Auto-generated method stub
		if(dao.findById(id)!=null)
		{
			return dao.findById(id);
		}
		else
		{
			return null;
		}
	}

	public boolean deleteall() {
		// TODO Auto-generated method stub
		boolean b=true;
		if(b==true)
		{
			dao.deleteAll();
			return true;
		}return false;
	}

	public String deletebd(int id) {
		// TODO Auto-generated method stub
		boolean b = dao.existsById(id);
		if(b==true)
		{
			dao.deleteById(id);
			return "Data deleted Successfully";
		} return "There is no data found by given id";
	}

	public Employee_Entity update(Employee_Entity employee) {

		Employee_Entity e = dao.findByName(employee.getName());
		if(e!=null)
		{
			e.setAge(employee.getAge());
			e.setGender(employee.getGender());
			e.setLocation(employee.getLocation());
			e.setSalary(employee.getSalary());
			return dao.save(e);
		}else
		{
			return null;
		}
	}

	public Employee_Entity getbname(String name) {
		
		Employee_Entity e = dao.findByName(name);
		if(e!=null)
		{
			return e;
		}else
		{
			return e;
		}
		
	}

	
	
	
	

}
