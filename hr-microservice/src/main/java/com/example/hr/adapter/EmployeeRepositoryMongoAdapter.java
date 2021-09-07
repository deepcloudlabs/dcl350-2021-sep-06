package com.example.hr.adapter;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.entity.EmployeeDocument;
import com.example.hr.repository.EmployeeDocumentRepository;
import com.example.hr.repository.EmployeeRepository;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Repository
@Adapter // GoF Object Adapter
public class EmployeeRepositoryMongoAdapter implements EmployeeRepository {
	// delegates Spring Data Mongo
	private EmployeeDocumentRepository empDocRepo;
	private ModelMapper mapper;

	public EmployeeRepositoryMongoAdapter(EmployeeDocumentRepository empDocRepo, ModelMapper mapper) {
		this.empDocRepo = empDocRepo;
		this.mapper = mapper;
	}

	@Override
	public boolean exists(TcKimlikNo identity) {
		return empDocRepo.existsById(identity.getValue());
	}

	@Override
	public void save(Employee employee) {
		empDocRepo.insert(mapper.map(employee, EmployeeDocument.class));
	}

	@Override
	public Optional<Employee> findByIdentity(TcKimlikNo identity) {
		Optional<EmployeeDocument> empDoc = empDocRepo.findById(identity.getValue());
		if (empDoc.isEmpty())
			return Optional.empty();
		return Optional.of(mapper.map(empDoc.get(), Employee.class));
	}

	@Override
	public void remove(Employee emp) {
		empDocRepo.deleteById(emp.getIdentity().getValue());
	}

}
