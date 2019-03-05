package com.capgemini.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.beans.Employee;

@Service
public class EmployeeService {
	
	static List<Employee> employees = new LinkedList<>();
	
	
	static {
		
		employees.add(new Employee(101,"vikash",12000.23f, "analyst"));
		employees.add(new Employee(102,"shivam",1200.23f, "tester"));
		employees.add(new Employee(103,"balveer",13000.23f, "developer"));
		employees.add(new Employee(104,"yash",15000.23f, "designer"));
	}
	
	public Employee findOne(int id){
		
		Employee employee = null;
		Iterator<Employee> it = employees.iterator(); 
		while(it.hasNext()) {
			employee = it.next();
			if(employee.getId() == id)
				return employee;
		}
		return null;
	}
	
	public Employee save(Employee employee) {
		
		employees.add(employee);
		return findOne(employee.getId());
	}
	
	public List<Employee> get()
	{
		return employees;
	}
	
	public Employee delete(int id)
	{
		Employee employee = findOne(id);
		if(employees.remove(employee))
			return employee;
		else
			return null;
	}
	
	public Employee update(Employee employee)
	{
		Employee emp = findOne(employee.getId());
		if(emp == null)
			return null;
		else
		{
			emp.setName(employee.getName());
			emp.setDesignation(employee.getDesignation());
			emp.setSalary(employee.getSalary());
			return emp;
		}
		
	}
}
