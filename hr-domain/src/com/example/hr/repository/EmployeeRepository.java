package com.example.hr.repository;

import java.util.Optional;

import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;

@Repository
public interface EmployeeRepository {

	boolean exists(TcKimlikNo identity);

	void save(Employee employee);

	Optional<Employee> findByIdentity(TcKimlikNo identity);

	void remove(Employee emp);

}
