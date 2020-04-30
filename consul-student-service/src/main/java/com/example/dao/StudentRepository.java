package com.example.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.model.Student;

@Repository(value="studnetRepository")
@EnableTransactionManagement
public interface StudentRepository extends CrudRepository<Student, Integer> {

	@Query
	public Iterable<Student> findBySchoolName(String schoolName);
}
