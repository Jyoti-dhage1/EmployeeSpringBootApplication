package com.springboot.EmployeeSpringBootApplication.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.EmployeeSpringBootApplication.entity.Employee2;

@Repository
public class EmployeeDao {

	@Autowired
	SessionFactory factory;
	
	public List<Employee2> fetchAllEmployees() {
		
		Session ss = factory.openSession();
		
		HibernateCriteriaBuilder cb = ss.getCriteriaBuilder();
		JpaCriteriaQuery<Employee2> cq= cb.createQuery(Employee2.class);
		JpaRoot<Employee2> root = cq.from(Employee2.class);
		cq.select(root);
		
		Query<Employee2> query = ss.createQuery(cq);
		List<Employee2> ll = query.getResultList();
		return ll;		
	}

	public String addEmployee(Employee2 emp) {
		Session ss = factory.openSession();
		Transaction tx = ss.beginTransaction();
		
		ss.persist(emp);
		tx.commit();
		ss.close();
		return "Employee has been added";
	}

	public List<Employee2> FetchActiveEmployee(String status) {
		Session ss = factory.openSession();

		String hqlQuery = "from Employee2 where status=:status";
		Query<Employee2> query = ss.createQuery(hqlQuery, Employee2.class);

		query.setParameter("status", status);
		List<Employee2> ll = query.getResultList();
		
		return ll;
	}

	public Employee2 FetchById(int id) {
		Session ss = factory.openSession();
		Employee2 e = ss.get(Employee2.class, id);
		return e;
	}

	public List<Employee2> FetchEmployeeByName(String empname) {
		Session ss = factory.openSession();

		String hqlQuery = "from Employee2 where name=:empname";
		Query<Employee2> query = ss.createQuery(hqlQuery, Employee2.class);

		query.setParameter("empname", empname);
		List<Employee2> ll = query.getResultList();
		
		return ll;
	}

	public String updatePhoneNo(Employee2 emp) {
		Session ss = factory.openSession();
		Transaction tx = ss.beginTransaction();
		
		Employee2 e = ss.get(Employee2.class, emp.getId());
		e.setPhoneno(emp.getPhoneno());
		ss.merge(e);
		tx.commit();
		ss.close();
		return "Employee Phone Number has been updated";
	}

	public String deleteEmpById(int id) {
		Session ss = factory.openSession();
		Transaction tx = ss.beginTransaction();
		Employee2 e = ss.get(Employee2.class, id);

		ss.remove(e);
		tx.commit();
		ss.close();
		return "Employee has been deleted";
	}

	

}
