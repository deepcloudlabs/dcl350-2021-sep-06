package com.example.hr.exercise;

import com.example.hr.domain.Department;
import com.example.hr.domain.Employee;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
@SuppressWarnings("unused")
public class Exercise1 {

	public static void main(String[] args) {
		var jack = new Employee.Builder("11111111110") // Flow API
				               .fullName("jack", "bauer")
				               .iban("tr1")
				               .salary(100_000)
				               .departments(Department.IT, Department.SALES)
				               .photo("")
				               .jobStyle("PART_TIME")
				               .build(); // business rule 
	}

}
