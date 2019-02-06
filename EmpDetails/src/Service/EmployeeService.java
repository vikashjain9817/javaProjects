package Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.beans.Address;
import com.capgemini.beans.City;
import com.capgemini.beans.Country;
import com.capgemini.beans.Employee;
import com.capgemini.repository.EmployeeRepo;

public class EmployeeService {
	
	EmployeeRepo employeeRepo;
	
	public EmployeeService(EmployeeRepo employeeRepo)
	{
		this.employeeRepo = employeeRepo;
	}
	
	public Employee createEmployee(String id, String name, Address address)
	{
		 Employee e = new Employee();
		 e.setId(id);
		 e.setName(name);
		 e.setAddress(address);
		 return employeeRepo.save(e);
	}
	
	public List<Employee> searchByName(String name) 
	{
		return employeeRepo.findByName(name);
		
	}
}