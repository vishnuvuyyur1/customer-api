package com.company.core.customer.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.api.exception.CustomerApiException;
import com.company.core.customer.entity.Customer;
import com.company.core.customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService {

	private static final String LOOKUP_PARAM_FIRST_NAME = "firstName";
	private static final String LOOKUP_PARAM_LAST_NAME = "lastName";

	private final CustomerRepository customerRepository;

	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public Customer getCustomerById(Long id) {
		return getCustomer(id);
	}

	public Customer updateCustomerAddress(Long customerId, String newAddress) {
		Customer existingCustomer = getCustomer(customerId);
		existingCustomer.setAddress(newAddress);
		return customerRepository.save(existingCustomer);
	}

	public List<Customer> getCustomers(Map<String, String> paramsMap) {
		return paramsMap == null || paramsMap.isEmpty() ? (List<Customer>) customerRepository.findAll()
				: getCustomersByLookUpParam(paramsMap);
	}

	private List<Customer> getCustomersByLookUpParam(Map<String, String> paramsMap) {
		String firstName = paramsMap.get(LOOKUP_PARAM_FIRST_NAME);
		String lastName = paramsMap.get(LOOKUP_PARAM_LAST_NAME);
		if (firstName != null && lastName != null) {
			return customerRepository.findByFirstNameAndLastName(firstName, lastName);
		} else if (firstName != null) {
			return customerRepository.findByFirstName(firstName);
		} else {
			return customerRepository.findByLastName(lastName);
		}
	}

	private Customer getCustomer(Long id) {
		return customerRepository.findById(id).orElseThrow(() -> new CustomerApiException("Customer not found"));
	}

}
