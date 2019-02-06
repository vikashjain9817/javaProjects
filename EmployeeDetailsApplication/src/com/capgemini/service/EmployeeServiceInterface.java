package com.capgemini.service;

import java.util.List;

import com.capgemini.Exception.AddressNotGivenException;
import com.capgemini.Exception.DuplicateIdException;
import com.capgemini.Exception.IdNotgivenException;
import com.capgemini.Exception.NameNotFindException;
import com.capgemini.Exception.NameNotGivenException;
import com.capgemini.beans.Address;
import com.capgemini.beans.Employee;

public interface EmployeeServiceInterface {

	Employee createEmployee(String id, String name, Address address) throws NameNotGivenException, IdNotgivenException, AddressNotGivenException, DuplicateIdException;

	List<Employee> searchByName(String name) throws NameNotGivenException, NameNotFindException;

}