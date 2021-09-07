package com.example.hr.domain;

import java.util.List;

// Problem Space -> Domain -- divide/conquer? --> Sub-domain / Department/Role
// Solution Space -> Design
// DDD:  I) Bounded-Context (Solution space) --> Sub-domain (HR)(Problem Space)
//      II) Ubiquitous Language -> Model Stakeholder -> Employee, TcKimlikNo, FullName, Money, Iban, Department, Photo, ...   
// 1) Entity Class -> i) Persist ii) Identity iii) Mutable
// 2) Value Object -> i) stores value ii) does not have an identity iii) immutable
// 3) Aggregate -> Entity Root -> Sub-domain information 
//    enforce Validation/Business Rule/Pre-/Post-condition/invariants 
//    transaction boundary
@Entity(identity = "identity")
@Aggregate
public class Employee {
	private final TcKimlikNo identity;
	private FullName fullName;
	private Money salary;
	private Iban iban;
	private List<Department> departments;
	private BiometricPhoto photo;
	private JobStyle jobStyle;

	public Employee(TcKimlikNo identity, FullName fullName, Money salary, Iban iban, List<Department> departments,
			BiometricPhoto photo, JobStyle jobStyle) {
		this.identity = identity;
		this.fullName = fullName;
		this.salary = salary;
		this.iban = iban;
		this.departments = departments;
		this.photo = photo;
		this.jobStyle = jobStyle;
	}

	public Employee(Builder builder) {
		this.identity = builder.identity;
		this.fullName = builder.fullName;
		this.salary = builder.salary;
		this.iban = builder.iban;
		this.departments = builder.departments;
		this.photo = builder.photo;
		this.jobStyle = builder.jobStyle;
	}

	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}

	public Money getSalary() {
		return salary;
	}

	public void setSalary(Money salary) {
		this.salary = salary;
	}

	public Iban getIban() {
		return iban;
	}

	public void setIban(Iban iban) {
		this.iban = iban;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public BiometricPhoto getPhoto() {
		return photo;
	}

	public void setPhoto(BiometricPhoto photo) {
		this.photo = photo;
	}

	public JobStyle getJobStyle() {
		return jobStyle;
	}

	public void setJobStyle(JobStyle jobStyle) {
		this.jobStyle = jobStyle;
	}

	public TcKimlikNo getIdentity() {
		return identity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identity == null) ? 0 : identity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [identity=" + identity + ", fullName=" + fullName + ", salary=" + salary + ", iban=" + iban
				+ ", departments=" + departments + ", jobStyle=" + jobStyle + "]";
	}


	// Builder (Effective Java Ed.3 Joshuo Bloch)
	public static class Builder {
		private TcKimlikNo identity;
		private FullName fullName;
		private Money salary;
		private Iban iban;
		private List<Department> departments;
		private BiometricPhoto photo;
		private JobStyle jobStyle;

		public Builder(String value) {
			this.identity = TcKimlikNo.valueOf(value);
		}

		public Builder fullName(String first, String last) {
			this.fullName = FullName.of(first, last);
			return this;
		}

		public Builder salary(double value, FiatCurrency currency) {
			this.salary = Money.valueOf(value, currency);
			return this;
		}

		public Builder salary(double value) {
			return salary(value, FiatCurrency.TL);
		}

		public Builder iban(String value) {
			this.iban = Iban.of(value);
			return this;
		}

		public Builder departments(Department... departments) {
			this.departments = List.of(departments);
			return this;
		}

		public Builder photo(byte[] values) {
			this.photo = BiometricPhoto.valueOf(values);
			return this;
		}

		public Builder photo(String values) {
			this.photo = BiometricPhoto.valueOf(values);
			return this;
		}

		public Builder jobStyle(String value) {
			this.jobStyle = JobStyle.valueOf(value);
			return this;
		}

		public Employee build() {
			// validation/business rule/invariants/...
			if (this.jobStyle == JobStyle.PART_TIME && this.salary.getValue()>8_000) // business rule
				throw new IllegalStateException("Part-time employees cannot have salary larger than 8000.");
			return new Employee(this);	
		}
	}

}
