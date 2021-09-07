package com.example.hr.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;
import com.example.hr.domain.FullName;
import com.example.hr.domain.Money;
import com.example.hr.dto.request.HireEmployeeRequest;
import com.example.hr.entity.EmployeeDocument;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Configuration
public class ModelMapperConfig {

	private static final Converter<HireEmployeeRequest,Employee> hireEmployeeRequest2EmployeeConverter= context -> {
		var request = context.getSource();
		return new Employee.Builder(request.getIdentity())
				           .fullName(request.getFirstName(), request.getLastName())
				           .salary(request.getSalary(), request.getCurrency())
				           .iban(request.getIban())
				           .photo(request.getPhoto())
				           .jobStyle(request.getJobStyle().name())
				           .departments(request.getDepartments().toArray(new Department[0]))
				           .build();
	};
	
	private static final Converter<EmployeeDocument,Employee> employeeDocument2EmployeeConverter = context -> {
		var empDoc = context.getSource();
		return new Employee.Builder(empDoc.getIdentity())
				.fullName(empDoc.getFirstName(), empDoc.getLastName())
				.salary(empDoc.getSalary(), empDoc.getCurrency())
				.iban(empDoc.getIban())
				.photo(empDoc.getPhoto())
				.jobStyle(empDoc.getJobStyle().name())
				.departments(empDoc.getDepartments().toArray(new Department[0]))
				.build();
	};
	
	private static final Converter<Employee,EmployeeDocument> employee2EmployeeDocumentConverter= context -> {
		var employee = context.getSource();
		var employeeDocument = new EmployeeDocument();
		FullName fullName = employee.getFullName();
		Money salary = employee.getSalary();
		employeeDocument.setIdentity(employee.getIdentity().getValue());
		employeeDocument.setFirstName(fullName.getFirst());
		employeeDocument.setLastName(fullName.getLast());
		employeeDocument.setIban(employee.getIban().getValue());
		employeeDocument.setSalary(salary.getValue());
		employeeDocument.setCurrency(salary.getCurrency());
		employeeDocument.setDepartments(employee.getDepartments());
		employeeDocument.setJobStyle(employee.getJobStyle());
		employeeDocument.setPhoto(employee.getPhoto().getBase64Values());
		return employeeDocument;
	};

	@Bean
	public ModelMapper modelMapper() {
		var mapper = new ModelMapper();
		mapper.addConverter(hireEmployeeRequest2EmployeeConverter, HireEmployeeRequest.class, Employee.class);
		mapper.addConverter(employee2EmployeeDocumentConverter, Employee.class, EmployeeDocument.class);
		mapper.addConverter(employeeDocument2EmployeeConverter, EmployeeDocument.class, Employee.class);
		return mapper;
	}
}
