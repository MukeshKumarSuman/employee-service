package com.nps.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nps.entity.EmployeeEntity;
import com.nps.repository.EmployeeRepository;
import com.nps.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private EmployeeRepository empRepository;

	@ApiOperation(value = "Get all employee details", notes = "All Employee Details", response = EmployeeEntity.class, responseContainer = "List")
	@GetMapping(value = "/employees", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<EmployeeEntity>> getAllEmployee() {
		List<EmployeeEntity> allEmployees = empService.getAllEmployees();
		return new ResponseEntity<List<EmployeeEntity>>(allEmployees, HttpStatus.OK);
	}

	@GetMapping(value = "/employee/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Integer empId) {
		EmployeeEntity emp = empService.getEmployeeById(empId);
		return new ResponseEntity<EmployeeEntity>(emp, HttpStatus.OK);
	}

	@ApiOperation(value = "Save Employee details", notes = "Save Employee", response = EmployeeEntity.class)

	@PostMapping(value = "/employee", produces = { "application/json", "application/xml" }, consumes = {
			"application/xml", "application/json" })
	public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody EmployeeEntity emp) {
		EmployeeEntity savedEmp = empService.saveEmployee(emp);
		return new ResponseEntity<EmployeeEntity>(savedEmp, HttpStatus.OK);
	}

	@PostMapping(value = "/employees", produces = { "application/json", "application/xml" }, consumes = {
			"application/xml", "application/json" })
	public ResponseEntity<List<EmployeeEntity>> saveEmployee(@RequestBody List<EmployeeEntity> emps) {
		List<EmployeeEntity> saveEmployees = empService.saveEmployees(emps);
		return new ResponseEntity<List<EmployeeEntity>>(saveEmployees, HttpStatus.OK);
	}

	@PutMapping(value = "/employee", produces = { "application/json", "application/xml" }, consumes = {
			"application/xml", "application/json" })
	public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeEntity emp) {
		EmployeeEntity updatedEmployee = empService.updateEmployee(emp);
		return new ResponseEntity<EmployeeEntity>(updatedEmployee, HttpStatus.OK);
	}

	@DeleteMapping(value = "/employee/{empId}", produces = { "application/json", "application/xml" })
	public ResponseEntity<EmployeeEntity> deleteEmployeeById(@PathVariable Integer empId) {
		EmployeeEntity deletedEmployee = empService.deleteEmployeeById(empId);
		return new ResponseEntity<EmployeeEntity>(deletedEmployee, HttpStatus.OK);
	}

}
