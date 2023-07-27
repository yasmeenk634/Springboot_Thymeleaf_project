package com.yasmeen.service;

import java.util.List;

import com.yasmeen.model.Employee;
import com.yasmeen.request.RequestEmployee;

public interface EmployeeService {
	List<Employee> getAllEmployees();

	String addEmployee(RequestEmployee request);
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);

}
