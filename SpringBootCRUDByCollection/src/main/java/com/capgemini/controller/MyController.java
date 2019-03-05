package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.beans.Employee;
import com.capgemini.service.EmployeeService;

@RestController
public class MyController {
	
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "Employee", method = RequestMethod.GET)
	public List<Employee> get(){
		  return employeeService.get();		  
	  }
	
	 @RequestMapping(value = "Employee/{id}", method = RequestMethod.GET)
	  public Employee getById(@PathVariable int id){
	    return employeeService.findOne(id);
	  }
	 
	 @RequestMapping(value = "EmployeeAdd/{id}/{name}/{salary}/{desg}", method = RequestMethod.GET)
	  public Employee save(@PathVariable int id, @PathVariable String name, @PathVariable float salary, @PathVariable String desg ){
		 Employee employee = new Employee(id, name, salary, desg);
	     return employeeService.save(employee);
	  }
	 
	 @RequestMapping(value = "EmployeeDelete/{id}", method = RequestMethod.GET)
	 public Employee delete(@PathVariable int id){
	     return employeeService.delete(id);
	  }
	 
	 @RequestMapping(value = "EmployeeUpdate/{id}/{name}/{salary}/{desg}", method = RequestMethod.GET)
	  public Employee update(@PathVariable int id, @PathVariable String name, @PathVariable float salary, @PathVariable String desg ){
		 Employee employee = new Employee(id, name, salary, desg);
	     return employeeService.update(employee);
	  }
	 
	 
}