package com.yasmeen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yasmeen.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
