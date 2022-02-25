package com.nps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nps.entity.EmployeeEntity;
import com.nps.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;
	
	public List<EmployeeEntity> getAllEmployees() {
		return empRepository.findAll();
	}
	
	public EmployeeEntity getEmployeeById(Integer empId) {
		return empRepository.getById(empId);
	}
	
	public EmployeeEntity saveEmployee(EmployeeEntity emp) {
		return empRepository.save(emp);
	}
	
	public List<EmployeeEntity> saveEmployees(List<EmployeeEntity> emps) {
		List<EmployeeEntity> savedEmps = empRepository.saveAll(emps);
		return savedEmps;
	}
	
	public EmployeeEntity updateEmployee(EmployeeEntity emp) {
		return empRepository.save(emp);
	}
	
	public EmployeeEntity deleteEmployeeById(Integer empId) {
		EmployeeEntity emp = empRepository.getById(empId);
		empRepository.deleteById(empId);
		return emp;
	}
}
