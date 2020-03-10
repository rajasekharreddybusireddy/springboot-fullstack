package com.blogspot.javabyrajasekhar.springbootfullstack.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.blogspot.javabyrajasekhar.springbootfullstack.model.Employee;

@Service
public class EmployeeService {
	List<Employee> empList = new ArrayList<>();

	@PostConstruct
	public void prepareData() {
		empList.add(new Employee(1L, "busi", "rajasekhar", "busi@gmail.com"));
		empList.add(new Employee(2L, "thiruna", "narender", "thiruna@gmail.com"));
		empList.add(new Employee(3L, "vadalasetti", "manikanta", "vadalasetti@gmail.com"));
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void saveEmployee(Employee emp) {
		empList.add(emp);
	}

	public Employee getEmployeeById(Long long1) {
		return empList.stream().filter(e->e.getId()==long1).findFirst().get();
	}

	public void deleteEmployeeById(Long id) {
		Employee employee = empList.stream().filter(e->e.getId()==id).findFirst().get();
		empList.remove(employee);
	}
}
