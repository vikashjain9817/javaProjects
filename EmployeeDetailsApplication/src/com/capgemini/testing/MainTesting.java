package com.capgemini.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.Exception.AddressNotGivenException;
import com.capgemini.Exception.DuplicateIdException;
import com.capgemini.Exception.IdNotgivenException;
import com.capgemini.Exception.NameNotFindException;
import com.capgemini.Exception.NameNotGivenException;
import com.capgemini.beans.Address;
import com.capgemini.beans.City;
import com.capgemini.beans.Country;
import com.capgemini.repository.EmployeeRepo;
import com.capgemini.repository.EmployeeRepoImp;
import com.capgemini.service.EmployeeService;
import com.capgemini.service.EmployeeServiceInterface;
public class MainTesting {
	
	EmployeeRepo empRepo = new EmployeeRepoImp();
	EmployeeServiceInterface empService  = new EmployeeService(empRepo);
	
	
	@Test(expected = com.capgemini.Exception.NameNotGivenException.class)
	public void WhenTheNameIsNotGivenThenThrowAnError() throws NameNotGivenException, IdNotgivenException, AddressNotGivenException, DuplicateIdException {
		
		City city = new City("pune");
		Country country = new Country("india", city);
		Address add = new Address("talwade", country);
		empService.createEmployee("123", "", add);
		
	}
	
	
	@Test(expected = com.capgemini.Exception.IdNotgivenException.class)
	public void WhenTheIdIsNotGivenThenThrowAnError() throws NameNotGivenException, IdNotgivenException, AddressNotGivenException, DuplicateIdException {
		
		City city = new City("pune");
		Country country = new Country("india", city);
		Address add = new Address("talwade", country);
		empService.createEmployee("", "vikash", add);
		
	}
	
	@Test(expected = com.capgemini.Exception.AddressNotGivenException.class)
	public void WhenTheAddressLineIsNotGivenThenThrowAnError() throws NameNotGivenException, IdNotgivenException, AddressNotGivenException, DuplicateIdException {
		
		City city = new City("pune");
		Country country = new Country("india", city);
		Address add = new Address("", country);
		empService.createEmployee("123", "vikash", add);
		
	}
	
	@Test
	public void WhenTheValidInfoIsGivenThenDetailsStoredSuccessfully() throws NameNotGivenException, IdNotgivenException, AddressNotGivenException, DuplicateIdException {
		
		City city = new City("pune");
		Country country = new Country("india", city);
		Address add = new Address("talwade", country);
		empService.createEmployee("123", "vikash", add);
		
	}
	
	@Test(expected = com.capgemini.Exception.DuplicateIdException.class)
	public void WhenTheDupicateIdIsGivenThenThrowException() throws NameNotGivenException, IdNotgivenException, AddressNotGivenException, DuplicateIdException {
		
		City city = new City("delhi");
		Country country = new Country("india", city);
		Address add = new Address("chandni chauck", country);
		empService.createEmployee("123", "balveer", add);
		
		City city1 = new City("pune");
		Country country1 = new Country("india", city1);
		Address add1 = new Address("talwade", country1);
		empService.createEmployee("123", "vikash", add1);
	}
	
	@Test
	public void WhenTheValidNameIstGivenInSearchingSuccessfully() throws NameNotGivenException, IdNotgivenException, AddressNotGivenException, DuplicateIdException, NameNotFindException {
		City city = new City("delhi");
		Country country = new Country("india", city);
		Address add = new Address("chandni chauck", country);
		empService.createEmployee("123", "balveer", add);
		
		empService.searchByName("balveer");
	
	}
	
	@Test(expected = com.capgemini.Exception.NameNotFindException.class)
	public void WhenTheValidNameIsNotGivenThenThrowAnError() throws NameNotGivenException, IdNotgivenException, AddressNotGivenException, DuplicateIdException, NameNotGivenException, NameNotFindException{
		City city = new City("delhi");
		Country country = new Country("india", city);
		Address add = new Address("chandni chauck", country);
		empService.createEmployee("123", "balveer", add);
		
		empService.searchByName("vikash");
	}
	
	
	
	
	
	
}
