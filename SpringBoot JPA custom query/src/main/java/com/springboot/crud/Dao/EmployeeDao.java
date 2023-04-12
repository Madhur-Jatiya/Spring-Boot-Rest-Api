package com.springboot.crud.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.springboot.crud.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	public List<Employee> findByMobile(String mobile);
	public List<Employee> findByName(String name);
	public List<Employee> findByAgeLessThan(int age);
	public List<Employee> findByNameAndCity(String name, String city);	
}
