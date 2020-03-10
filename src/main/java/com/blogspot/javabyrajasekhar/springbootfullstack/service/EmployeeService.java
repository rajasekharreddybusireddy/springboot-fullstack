package com.blogspot.javabyrajasekhar.springbootfullstack.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogspot.javabyrajasekhar.springbootfullstack.model.Employee;
import com.blogspot.javabyrajasekhar.springbootfullstack.repository.EmployeeRepository;

@Service
public class EmployeeService {
	List<Employee> empList = new ArrayList<>();
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostConstruct
	public void prepareData() {
		
		
		empList.add(new Employee(1L, "busi", "rajasekhar", "busi@gmail.com"));
		empList.add(new Employee(2L, "thiruna", "narender", "thiruna@gmail.com"));
		empList.add(new Employee(3L, "vadalasetti", "manikanta", "vadalasetti@gmail.com"));
		empList.stream().forEach(e->employeeRepository.save(e));
	}

	public List<Employee> getEmpList() {
		return employeeRepository.findAll();
	}

	public void saveEmployee(Employee emp) {
		employeeRepository.save(emp);
		//empList.add(emp);
	}

	public Employee getEmployeeById(Long long1) {
		List<Employee> findAll = employeeRepository.findAll();
		return findAll.stream().filter(e->e.getId()==long1).findFirst().get();
	}

	public void deleteEmployeeById(Long id) {
		List<Employee> findAll = employeeRepository.findAll();
		Employee employee = findAll.stream().filter(e->e.getId()==id).findFirst().get();
		employeeRepository.delete(employee);
		//empList.remove(employee);
	}
}
