package com.springboot.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.Dao.EmployeeDao;
import com.springboot.crud.entity.Employee;

@RestController
public class MyController {
	@Autowired
	EmployeeDao employeeDao;

	@GetMapping("/home")
	public String welcome() {
		return "Welcome to Spring Boot Crud";
	}
	
	//get all employees

	@GetMapping("/employees")
	public List<Employee> showAllEmployees() {
		return employeeDao.findAll();
	}

	//get employee by id
	
	@GetMapping("/employees/{id}")
	public Object getEmployeeById(@PathVariable int id) {
		try {
			Employee existingEmployee = employeeDao.findById(id).get();
			return existingEmployee;
		} catch (Exception e) {
			return "Employee id not found";
		}
	}

	//add new emoloyee
	
	@PostMapping("/employees")
	public String createNewEmployee(@RequestBody Employee employee) {
		employeeDao.save(employee);
		return "Employee Added successfully";
	}

	//update employee by id
	
	@PutMapping("/employees/{id}")
	public Object updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
		try {
			Employee existingEmployee = showAllEmployees().get(id - 1);
			existingEmployee.setAge(emp.getAge());
			existingEmployee.setCity(emp.getCity());
			existingEmployee.setEmail(emp.getEmail());
			existingEmployee.setMobile(emp.getMobile());
			existingEmployee.setName(emp.getName());
			existingEmployee.setSalary(emp.getSalary());
			employeeDao.save(existingEmployee);
			return existingEmployee;

		} catch (Exception e) {
			return "Employee id not found";
		}
	}
	
	//delete all employees

	@DeleteMapping("/employees")
	public String deleteEmployee() {
		employeeDao.deleteAll(employeeDao.findAll());
		return "All employees deleted";
	}

	//delete emloyee by id
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		try {
			employeeDao.delete(employeeDao.findById(id).get());
			return "employees deleted";
		} catch (Exception e) {
			return "Employee id not found";
		}
	}
	
	//get employee by mobile number

	@GetMapping("/employees/mobile/{mobile}")
	public Object findByMobile(@PathVariable String mobile) {
		if (!employeeDao.findByMobile(mobile).isEmpty()) {
			return employeeDao.findByMobile(mobile);
		} else {
			return "No mobile number present";
		}
	}

	//get employee by name
	
	@GetMapping("/employees/name/{name}")
	public Object findByName(@PathVariable String name) {
		if (!employeeDao.findByName(name).isEmpty()) {
			return employeeDao.findByName(name);
		} else {
			return "No name present";
		}
	}

	//get employee by agr less than
	
	@GetMapping("/employees/age/{age}")
	public Object findByName(@PathVariable int age) {
		if (!employeeDao.findByAgeLessThan(age).isEmpty()) {
			return employeeDao.findByAgeLessThan(age);
		} else {
			return "No data found";
		}
	}
	
	//get employee by city and name

	@GetMapping("/employees/find/{name}/{city}")
	public Object findByName(@PathVariable String name, @PathVariable String city) {
		if (!employeeDao.findByNameAndCity(name, city).isEmpty()) {
			return employeeDao.findByNameAndCity(name, city);
		} else {
			return "No data found";
		}
	}

	//delete employee by name
	
	@DeleteMapping("/employees/delete/{name}")
	public Object deleteByName(@PathVariable String name) {
		List<Employee> emp = new ArrayList<Employee>();
		for (Employee e : showAllEmployees()) {
			if (e.getName().equalsIgnoreCase(name)) {
				emp.add(e);
			}
		}
		if (!emp.isEmpty()) {
			employeeDao.deleteAll(emp);
			return "employee deleted";
		}
		return "emp not deleted";
	}
}
