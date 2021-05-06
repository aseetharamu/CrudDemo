package com.crud.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.crud.demo.entity.Employee;

public interface EmpService {
	
	public List<String> getAllEmployeeNames();
	
	public Employee saveEmployee(Employee emp);

	public List<Employee> getAllEmployees();

	public Employee getEmpById(Long id);

	public void deleteEmpById(Long id);

}
