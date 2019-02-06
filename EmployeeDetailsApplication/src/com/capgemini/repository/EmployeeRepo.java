package com.capgemini.repository;


import java.util.List;

import com.capgemini.beans.Employee;

public interface EmployeeRepo {
	
	Employee save(Employee e);
	List<Employee> findByName(String name);
}