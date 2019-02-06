package com.capgemini.repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.beans.Employee;

public class EmployeeRepoImp implements EmployeeRepo{

	Map<String, Employee> employees  = new HashMap<String, Employee>();
	
	@Override
	public Employee save(Employee e) {
		employees.put(e.getId(), e);
		return employees.get(e.getId());
	}

	@Override
	public List<Employee> findByName(String name) {
		List<Employee> list = new ArrayList<>();
		for (Map.Entry<String,Employee> entry : employees.entrySet())  {
				
			if(entry.getValue().getName().equals(name))
			  list.add(entry.getValue());
		  }
		return list;
	}
	
}