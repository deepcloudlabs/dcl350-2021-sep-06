package com.example.hr.dto.request;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.hr.domain.Department;
import com.example.hr.domain.FiatCurrency;
import com.example.hr.domain.JobStyle;
import com.example.hr.dto.DataTransferObject;
import com.example.validation.Iban;
import com.example.validation.TcKimlikNo;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@DataTransferObject
public class HireEmployeeRequest {
	@TcKimlikNo
	private String identity;
	@Size(min=2)
	private String firstName;
	@Size(min=2)
	private String lastName;
	@Iban
	private String iban;
	@NotNull
	private FiatCurrency currency;
	@Min(3_000)
	private double salary;
	private String photo;
	@NotNull
	private JobStyle jobStyle;
	private List<Department> departments;

	public HireEmployeeRequest() {
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public FiatCurrency getCurrency() {
		return currency;
	}

	public void setCurrency(FiatCurrency currency) {
		this.currency = currency;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public JobStyle getJobStyle() {
		return jobStyle;
	}

	public void setJobStyle(JobStyle jobStyle) {
		this.jobStyle = jobStyle;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

}
