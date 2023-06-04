package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Employee_Entity;

public interface Employee_dao extends JpaRepository<Employee_Entity, Integer> {
	
@Query(value = "SELECT * FROM employee e WHERE e.name = :name", nativeQuery = true)
public Employee_Entity findByName(String name);
	

}
