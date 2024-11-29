package com.springboot.EmployeeSpringBootApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.EmployeeSpringBootApplication.dao.EmployeeDao;
import com.springboot.EmployeeSpringBootApplication.entity.Employee2;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao dao;
	
	public List<Employee2> fetchAllEmployees() {
		List<Employee2> ll = dao.fetchAllEmployees();
		return ll;
	}

	public String addEmployee(Employee2 emp) {
		String msg = dao.addEmployee(emp);
		return msg;
	}

	public List<Employee2> FetchActiveEmployee(String status) {
		List<Employee2> ll= dao.FetchActiveEmployee(status);
		return ll;
	}

	public Employee2 FetchById(int id) {
		Employee2 e = dao.FetchById(id);
		return e;
	}

	public List<Employee2> FetchEmployeeByName(String empname) {
		
		List<Employee2> ll= dao.FetchEmployeeByName(empname);
		return ll;
	}

	public String updatePhoneNo(Employee2 emp) {
		String msg = dao.updatePhoneNo(emp);
		return msg;
	}

	public String deleteEmpById(int id) {
		String msg = dao.deleteEmpById(id);
		return msg;
	}

}
