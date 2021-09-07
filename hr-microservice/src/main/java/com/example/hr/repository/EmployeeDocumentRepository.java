package com.example.hr.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.hr.domain.JobStyle;
import com.example.hr.entity.EmployeeDocument;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public interface EmployeeDocumentRepository extends MongoRepository<EmployeeDocument, String> {
	List<EmployeeDocument> findByJobStyle(JobStyle style);
	List<EmployeeDocument> findByJobStyleAndSalaryBetween(JobStyle style,double minSalary,double maxSalary);
	@Query("{$and : [ {jobStyle: {$eq: ?0}}, {salary: {$gte: ?1}}, {salary: {$lte: ?2}}]}")
	List<EmployeeDocument> getir(JobStyle style,double minSalary,double maxSalary);
}
