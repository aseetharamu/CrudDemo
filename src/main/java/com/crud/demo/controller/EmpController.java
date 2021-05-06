package com.crud.demo.controller;

import org.apache.catalina.startup.HomesUserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration.WelcomePageConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.crud.demo.custom.exceptions.EmpControllerException;
import com.crud.demo.custom.exceptions.EmpServiceException;
import com.crud.demo.entity.Employee;
import com.crud.demo.repos.EmpRepoCrud;
import com.crud.demo.service.EmpService;

@RestController
@RequestMapping("/employee" )
public class EmpController {
	
	@Autowired
	private EmpService empService;

	/*
	 * @GetMapping("/listAll") public ResponseEntity<?> getAllEmployees(){
	 * System.out.println("Getting all Employees"); List<Employee> employees = null;
	 * try { employees = empService.getAllEmployees(); return new
	 * ResponseEntity<List<Employee>>(employees, HttpStatus.OK ) ; }
	 * catch(EmpServiceException e){ EmpControllerException ec = new
	 * EmpControllerException(e.getErr_msg(), e.getErr_code()); return new
	 * ResponseEntity<EmpControllerException>(ec, HttpStatus.BAD_REQUEST ) ; }
	 * 
	 * }
	 * 
	 * @GetMapping("/listNames") public ResponseEntity<?> getAllEmployeeNames(){
	 * System.out.println("Getting all Employee Names"); List<String> nameList =
	 * null; try { nameList = empService.getAllEmployeeNames(); return new
	 * ResponseEntity<List<String>>(nameList, HttpStatus.CREATED); }
	 * catch(EmpServiceException e){ System.out.println(e.getErr_msg());
	 * EmpControllerException ec = new EmpControllerException(e.getErr_msg(),
	 * e.getErr_code()); return new ResponseEntity<EmpControllerException>(ec,
	 * HttpStatus.BAD_REQUEST); }
	 * 
	 * }
	 * 
	 * @PostMapping("/save") public ResponseEntity<?> saveEmployee(@RequestBody
	 * Employee emp) { System.out.println("Saving Employee"); try { Employee
	 * savedEmployee = empService.saveEmployee(emp); return new
	 * ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED); } catch
	 * (EmpServiceException e) { EmpControllerException ce = new
	 * EmpControllerException(e.getErr_msg(), e.getErr_code()); return new
	 * ResponseEntity<EmpControllerException>(ce, HttpStatus.BAD_REQUEST); } catch
	 * (Exception e) { EmpControllerException ce = new
	 * EmpControllerException("Something went wrong " , "611"); return new
	 * ResponseEntity<EmpControllerException>(ce, HttpStatus.BAD_REQUEST); } }
	 * 
	 * @GetMapping("/listEmpById/{id}") public ResponseEntity<?>
	 * getEmpById(@PathVariable("id") Long id){
	 * System.out.println("Getting Employees ID"); Employee employee = null; try {
	 * employee = empService.getEmpById(id); return new
	 * ResponseEntity<Employee>(employee, HttpStatus.OK ) ; }
	 * 
	 * catch (EmpServiceException e) { EmpControllerException ec = new
	 * EmpControllerException(e.getErr_msg(), e.getErr_code()); return new
	 * ResponseEntity<EmpControllerException>(ec, HttpStatus.BAD_REQUEST); } }
	 * 
	 * @DeleteMapping("/deleteEmpById/{id}") public ResponseEntity<?>
	 * deleteEmpById(@PathVariable("id") Long id){
	 * System.out.println("Deleting Employee by ID");
	 * 
	 * Employee employee = null; try { empService.deleteEmpById(id); return new
	 * ResponseEntity<Void>(HttpStatus.ACCEPTED) ; }
	 * 
	 * catch (EmpServiceException e) { EmpControllerException ec = new
	 * EmpControllerException(e.getErr_msg(), e.getErr_code()); return new
	 * ResponseEntity<EmpControllerException>(ec, HttpStatus.BAD_REQUEST); }
	 * 
	 * }
	 * 
	 * @PutMapping("/updateEmp") public ResponseEntity<?> updateEmp(@RequestBody
	 * Employee emp){ System.out.println("Updating Employee"); Employee
	 * savedEmployee = null;
	 * 
	 * try { savedEmployee= empService.saveEmployee(emp); return new
	 * ResponseEntity<Employee>(savedEmployee, HttpStatus.OK); }
	 * 
	 * catch (EmpServiceException e) { EmpControllerException ec = new
	 * EmpControllerException(e.getErr_msg(), e.getErr_code()); return new
	 * ResponseEntity<EmpControllerException>(ec, HttpStatus.BAD_REQUEST); }
	 * 
	 * }
	 */
	/*
	 * @GetMapping("/") public String home() { return ("<h2>WelcomePage </h2>"); }
	 * 
	 * @GetMapping("/admin") public String Admin() { return
	 * ("<h2> Welcome Admin </h2>"); }
	 * 
	 * @GetMapping("/user") public String user() { return
	 * ("<h2> Welcome User </h2>"); }
	 */
	
	  @GetMapping("/listAll") public ResponseEntity<List<Employee>>
	  getAllEmployees(){ System.out.println("Getting all Employees");
	  List<Employee> employees = null;
	  
	  employees = empService.getAllEmployees(); return new
	  ResponseEntity<List<Employee>>(employees, HttpStatus.OK ) ; }
	  
	  @GetMapping("/listNames") public ResponseEntity<List<String>>
	  getAllEmployeeNames(){ System.out.println("Getting all Employee Names");
	  List<String> nameList = null;
	  
	  nameList = empService.getAllEmployeeNames(); return new
	  ResponseEntity<List<String>>(nameList, HttpStatus.CREATED);
	  
	  }
	  
	  @PostMapping("/save") public ResponseEntity<Employee>
	  saveEmployee(@RequestBody Employee emp) {
	  System.out.println("Saving Employee");
	  
	  Employee savedEmployee = empService.saveEmployee(emp); return new
	  ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED); }
	  
	  @GetMapping("/listEmpById/{id}") public ResponseEntity<Employee>
	  getEmpById(@PathVariable("id") Long id){
	  System.out.println("Getting Employees ID"); Employee employee = null;
	  
	  employee = empService.getEmpById(id); return new
	  ResponseEntity<Employee>(employee, HttpStatus.OK ) ; }
	  
	  @DeleteMapping("/deleteEmpById/{id}") public ResponseEntity<Void>
	  deleteEmpById(@PathVariable("id") Long id){
	  System.out.println("Deleting Employee by ID");
	  
	  empService.deleteEmpById(id); return new
	  ResponseEntity<Void>(HttpStatus.ACCEPTED) ; }
	  
	  @PutMapping("/updateEmp") public ResponseEntity<Employee>
	  updateEmp(@RequestBody Employee emp){
	  System.out.println("Updating Employee"); Employee savedEmployee = null;
	  
	  savedEmployee= empService.saveEmployee(emp); return new
	  ResponseEntity<Employee>(savedEmployee, HttpStatus.OK); }
	 
}
