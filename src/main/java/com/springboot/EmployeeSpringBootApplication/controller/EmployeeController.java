package com.springboot.EmployeeSpringBootApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.EmployeeSpringBootApplication.entity.Employee2;
import com.springboot.EmployeeSpringBootApplication.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	// 1
	@GetMapping("/showallEmployee")
	public List<Employee2> fetchAllEmployees() {

		List<Employee2> ll = service.fetchAllEmployees();
		return ll;

	}

	// 2
	@PostMapping("/addemployee")
	public String addEmployee(@RequestBody Employee2 emp) {

		String msg = service.addEmployee(emp);
		return msg;

	}

	// 3
	@GetMapping("/status/{status}")
	public List<Employee2> FetchActiveEmployee(@PathVariable String status) {

		List<Employee2> ll = service.FetchActiveEmployee(status);
		return ll;

	}

	// 4
	@GetMapping("/{id}")
	public Employee2 FetchById(@PathVariable int id) {

		Employee2 e = service.FetchById(id);
		return e;

	}

	// 5
	@GetMapping("/showEmployeesByName/{empname}")
	public List<Employee2> FetchEmployeeByName(@PathVariable String empname) {

		List<Employee2> ll = service.FetchEmployeeByName(empname);
		return ll;

	}

	// 6
	@PutMapping("/updatePhoneNo")
	public String updatePhoneNo(@RequestBody Employee2 emp) {

		String msg = service.updatePhoneNo(emp);
		return msg;

	}

	// 6
	@DeleteMapping("/deleteEmpById/{id}")
	public String deleteEmpById(@PathVariable int id) {

		String msg = service.deleteEmpById(id);
		return msg;

	}

}
