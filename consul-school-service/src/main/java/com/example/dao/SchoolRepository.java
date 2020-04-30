package com.example.dao;

import org.springframework.data.repository.CrudRepository;import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.model.School;

@Repository(value="schoolRepository")
@EnableTransactionManagement
public interface SchoolRepository extends CrudRepository<School, Integer> {

}
