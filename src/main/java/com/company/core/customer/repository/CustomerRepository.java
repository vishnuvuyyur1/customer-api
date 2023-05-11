package com.company.core.customer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.core.customer.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByFirstName(String firstName);

	List<Customer> findByLastName(String lastName);

	List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
}