package com.capgemini.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.Exception.AddressNotGivenException;
import com.capgemini.Exception.DuplicateIdException;
import com.capgemini.Exception.IdNotgivenException;
import com.capgemini.Exception.NameNotFindException;
import com.capgemini.Exception.NameNotGivenException;
import com.capgemini.beans.Address;
import com.capgemini.beans.City;
import com.capgemini.beans.Country;
import com.capgemini.beans.Employee;
import com.capgemini.repository.EmployeeRepo;

public class EmployeeService implements EmployeeServiceInterface {
	
	EmployeeRepo employeeRepo;
	
	public EmployeeService(EmployeeRepo employeeRepo)
	{
		this.employeeRepo = employeeRepo;
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.EmployeeServiceInterface#createEmployee(java.lang.String, java.lang.String, com.capgemini.beans.Address)
	 */
	@Override
	public Employee createEmployee(String id, String name, Address address) throws NameNotGivenException, IdNotgivenException, AddressNotGivenException, DuplicateIdException
	{
		if(name == "")
			throw new NameNotGivenException();
		if(id == "")
			throw new IdNotgivenException();
		if(address.getAddressLine()=="")
			throw new AddressNotGivenException();
		if(address.getCountry().getCity() == null)
			throw new AddressNotGivenException();
		if(searchId(id))
			throw new DuplicateIdException();
		 Employee e = new Employee();
		 e.setId(id);
		 e.setName(name);
		 e.setAddress(address);
		 return employeeRepo.save(e);
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.EmployeeServiceInterface#searchByName(java.lang.String)
	 */
	@Override
	public List<Employee> searchByName(String name) throws NameNotGivenException, NameNotFindException 
	{
		if(name == "")
			throw new NameNotGivenException();
		
		if(employeeRepo.findByName(name).isEmpty()) {
			System.out.println("name is not find");
			throw new NameNotFindException();
		}
			
		return	employeeRepo.findByName(name);
	}
	
	public boolean searchId(String id)
	{
		return employeeRepo.search(id);
		
	}
}
