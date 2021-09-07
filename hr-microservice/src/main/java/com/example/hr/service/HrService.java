package com.example.hr.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.hr.application.HrApplication;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.dto.request.HireEmployeeRequest;
import com.example.hr.dto.response.FireEmployeeResponse;
import com.example.hr.dto.response.HireEmployeeResponse;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@Service
@AntiCorruptionLayer
public class HrService {
	private HrApplication hrApp;
	private ModelMapper mapper;
	
	public HrService(HrApplication hrApp, ModelMapper mapper) {
		this.hrApp = hrApp;
		this.mapper = mapper;
	}

	public HireEmployeeResponse hireEmployee(HireEmployeeRequest request) {
		hrApp.hireEmployee(mapper.map(request, Employee.class));
		return new HireEmployeeResponse("success");
	}

	public FireEmployeeResponse fireEmployee(String identity) {
		var employee = hrApp.fireEmployee(TcKimlikNo.valueOf(identity));
		if (employee.isEmpty())
			return new FireEmployeeResponse("fail");
		return new FireEmployeeResponse("success");
	}

}
