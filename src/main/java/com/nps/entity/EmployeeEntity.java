package com.nps.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.UpdateTimestamp;

import io.swagger.annotations.ApiModel;

@Entity
@Table(name = "employee")
@XmlRootElement(name = "Employee")
@ApiModel(value = "Employee", description = "Details about the Employee")
@Proxy(lazy = false)
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String roles;
	private String department;
	private Long salary;
	
	@CreationTimestamp
	@Column(updatable=false)
	private LocalDate createdDate;

	@UpdateTimestamp
	@Column(insertable=false)
	private LocalDate updatedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return roles;
	}

	public void setRole(String roles) {
		this.roles = roles;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", name=" + name + ", roles=" + roles + ", department=" + department
				+ ", salary=" + salary + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
}
