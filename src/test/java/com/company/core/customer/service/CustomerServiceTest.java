package com.company.core.customer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.company.api.customer.TestData;
import com.company.api.exception.CustomerApiException;
import com.company.core.customer.entity.Customer;
import com.company.core.customer.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

	@InjectMocks
	private CustomerService customerService;

	@Mock
	private CustomerRepository customerRepository;

	private TestData testData;

	@BeforeEach
	void setUp() {
		testData = new TestData();
	}

	@Test
	void given_getCustomers_when_calledWithNullParams_expect_allCustomersData() {
		given(customerRepository.findAll()).willReturn(testData.getCustomers());
		List<Customer> response = customerService.getCustomers(null);
		assertEquals(3, response.size());
	}

	@Test
	void given_getCustomers_when_calledWithEmptyParams_expect_allCustomersData() {
		given(customerRepository.findAll()).willReturn(testData.getCustomers());
		List<Customer> response = customerService.getCustomers(new HashMap<>());
		assertEquals(3, response.size());
	}

	@Test
	void given_getCustomers_when_calledWithFirstNameParams_expect_customersData() {
		given(customerRepository.findByFirstName(Mockito.anyString())).willReturn(testData.getCustomers());
		List<Customer> response = customerService.getCustomers(Map.of("firstName", "hello"));
		assertEquals(3, response.size());
	}

	@Test
	void given_getCustomers_when_calledWithLastNameParams_expect_customersData() {
		given(customerRepository.findByLastName(Mockito.anyString())).willReturn(testData.getCustomers());
		List<Customer> response = customerService.getCustomers(Map.of("lastName", "world"));
		assertEquals(3, response.size());
	}

	@Test
	void given_getCustomers_when_calledWithFirstNameAndLastNameParams_expect_customersData() {
		given(customerRepository.findByFirstNameAndLastName(Mockito.anyString(), Mockito.anyString()))
				.willReturn(testData.getCustomers());
		List<Customer> response = customerService.getCustomers(Map.of("firstName", "hello", "lastName", "world"));
		assertEquals(3, response.size());
	}

	@Test
	void given_getCustomerById_when_calledWithId_expect_customersData() {
		Long id = 1L;
		given(customerRepository.findById(id)).willReturn(Optional.of(testData.getCustomer()));
		Customer response = customerService.getCustomerById(id);
		assertEquals("firstName", response.getFirstName());
	}

	@Test
	void given_addCustomer_when_calledWithData_expect_ok() {
		Customer cus = testData.getCustomer();
		given(customerRepository.save(Mockito.any(Customer.class))).willReturn(testData.getCustomer());
		customerService.addCustomer(cus);
		;
		Mockito.verify(customerRepository, Mockito.times(1)).save(cus);
	}

	@Test
	void given_updateCustomerAddress_when_calledWithIdAndAddress_expect_dataUpdated() {
		Long id = 1L;
		given(customerRepository.save(Mockito.any(Customer.class))).willReturn(testData.getCustomer());
		given(customerRepository.findById(id)).willReturn(Optional.of(testData.getCustomer()));
		Customer response = customerService.updateCustomerAddress(id, "address");
		assertEquals("address", response.getAddress());
	}

	@Test
	void given_updateCustomerAddress_when_calledWithInvalidId_expect_exception() {
		Long id = 1L;
		CustomerApiException thrown = assertThrows(CustomerApiException.class,
				() -> customerService.updateCustomerAddress(id, "address"));

		assertTrue(thrown.getMessage().contentEquals("Customer not found"));
	}
}
