package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
//import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.demo.entities.Employee_Entity;
import com.example.demo.service.Employee_Service;
import java.util.List;
import java.util.Optional;
import javax.websocket.server.PathParam;


@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping("/employee")

public class Employee_Controller {

	@Autowired
	private Employee_Service ser;

	public Employee_Controller() {
		System.out.println("CONTROLLER CLASS EXECUTING...");
	}

	@PostMapping("/add")
	public ResponseEntity<Employee_Entity> add(@RequestBody Employee_Entity employee) {
		Employee_Entity emp = ser.add(employee);
		
		if(emp==null)
		{
			return ResponseEntity.status(400).body(emp);
		}
		return ResponseEntity.status(200).body(emp);	
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<Employee_Entity>> getall() {
		List<Employee_Entity> emp = ser.getall();
		if (emp == null) {
			return ResponseEntity.status(400).body(emp);
		}
		return ResponseEntity.status(200).body(emp);
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Optional<Employee_Entity>> getbid(@PathVariable int id) {
		Optional<Employee_Entity> emp = ser.getbid(id);
		if (emp != null) {
			return ResponseEntity.status(200).body(emp);
		}
			return ResponseEntity.status(400).body(emp);
		
		
	}

	@DeleteMapping("/deleteall")
	public ResponseEntity<String> deleteall() {
		boolean b = ser.deleteall();
		if (b == true) {
			return ResponseEntity.status(200).body("All the data deleted Successfully");
		}
		return ResponseEntity.status(400).body("There is no data to delete..");

	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String> deletebd(@PathVariable int id) {
		String s = ser.deletebd(id);
		if (s != null) {
			return ResponseEntity.status(200).body(s);
		} else {
			return ResponseEntity.status(400).body(s);
		}
	}
	
	@GetMapping("/getbyname/{name}")
	public ResponseEntity getbname(@PathVariable String name)
	{
		Employee_Entity e = ser.getbname(name);
		if(e!=null)
		{
			return ResponseEntity.status(200).body(e);
		}return ResponseEntity.status(400).body(e);
	}
	
	@PutMapping("/update")
	public ResponseEntity update(@RequestBody Employee_Entity employee)
	{
		Employee_Entity e = ser.update(employee);
		if(e!=null)
		{
			return ResponseEntity.status(200).body("data updated\n"+e);
		}return ResponseEntity.status(400).body("user not found "+e);
	}

}
