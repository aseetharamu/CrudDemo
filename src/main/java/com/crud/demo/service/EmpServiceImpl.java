package com.crud.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.auditing.ReactiveIsNewAwareAuditingHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.demo.custom.exceptions.EmpServiceException;
import com.crud.demo.custom.exceptions.EmptyInputException;
import com.crud.demo.entity.Employee;
import com.crud.demo.repos.EmpRepoCrud;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpRepoCrud empRepoCrud;
	
	@Override
	public List<String> getAllEmployeeNames(){
		System.out.println("Getting all Employee Names in service");
		
		  List<String> result = new ArrayList<String>(); 
		  List<Employee> employees = null;
		  try {
			  
			  employees = empRepoCrud.findAll(); 
			
		  } catch (Exception e) {
			  
			  System.out.println("in service exception");
			  throw new EmpServiceException("Error while fetching data from DB", "607" );
			  
		  }
		  
		  if(employees.isEmpty()) {
			
			  throw new EmptyInputException("List of Names is null", "605" );
		  }
		  
			  for ( Employee emp : employees) { result.add(emp.getName()); }  
			  return result;
			  
	}
	
	
	@Override
	public Employee saveEmployee(Employee emp) {
		Employee savedEmployee;
		if(emp.getName().isEmpty() || emp.getName().length() == 0) {
			
			throw new EmptyInputException("Please send proper name", "602" );	
			
		}	
		try {		
			savedEmployee = empRepoCrud.save(emp);
			return savedEmployee;	
			
		} catch (IllegalArgumentException e) {
			
			throw new EmpServiceException("Please send Employee object" + e.getMessage(), "603" );
			
		} catch (Exception e) {
			
			throw new EmpServiceException("Something went wrong", "604" );
			
		}	
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		System.out.println("Getting all Employees"); 
		List<Employee> list = null;
		try {
			list = empRepoCrud.findAll();
		}
		catch (Exception e) {
			throw new EmpServiceException("Error while fetching", "608");
		}
		
		if(list.isEmpty()) {
			throw new EmptyInputException("List is null", "609" );			
		}
		return list;
		
	}


	@Override
	public Employee getEmpById(Long id) {
		
			return empRepoCrud.findById(id).get();		
			
	}


	@Override
	public void deleteEmpById(Long id) {	
		
			empRepoCrud.deleteById(id);	
			
	}
}
