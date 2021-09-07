package com.example.hr.application.business;

import java.util.Optional;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.domain.event.EmployeeFiredEvent;
import com.example.hr.domain.event.EmployeeHiredEvent;
import com.example.hr.infrastructure.EventPublisher;
import com.example.hr.repository.EmployeeRepository;

public class StandardHrApplication implements HrApplication {
	private EmployeeRepository empRepo;
	private EventPublisher publisher;

	public StandardHrApplication(EmployeeRepository empRepo, EventPublisher publisher) {
		this.empRepo = empRepo;
		this.publisher = publisher;
	}

	@Override
	public void hireEmployee(Employee employee) {
		var identity = employee.getIdentity();
		if (empRepo.exists(identity))
			throw new IllegalArgumentException("Employee already exists.");
		empRepo.save(employee);
		var domainEvent = new EmployeeHiredEvent(employee.getIdentity(), employee.getFullName());
		publisher.publish(domainEvent);
	}

	@Override
	public Optional<Employee> fireEmployee(TcKimlikNo identity) {
		Optional<Employee> employee = empRepo.findByIdentity(identity);
		if (employee.isEmpty())
			return Optional.empty();
		var emp = employee.get();
		empRepo.remove(emp);
		var domainEvent = new EmployeeFiredEvent(emp.getIdentity(), emp.getFullName());
		publisher.publish(domainEvent);
		return Optional.of(emp);
	}

}
