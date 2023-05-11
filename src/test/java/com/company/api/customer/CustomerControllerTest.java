package com.company.api.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.company.core.customer.entity.Customer;
import com.company.core.customer.service.CustomerService;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

	@InjectMocks
	private CustomerController customerController;

	@Mock
	private CustomerService customerService;

	private TestData testData;

	@BeforeEach
	void setUp() {
		testData = new TestData();
	}

	@Test
	void given_getAllCustomers_when_called_expect_customers_data() {
		given(customerService.getCustomers(Mockito.any())).willReturn(testData.getCustomers());
		List<Customer> customers = customerController.getCustomers(new HashMap<>());
		assertEquals(3, customers.size());
	}

	@Test
	void given_getCustomerById_when_calledWithId_expect_customer_data() {
		given(customerService.getCustomerById(Mockito.anyLong())).willReturn(testData.getCustomer());
		Customer customer = customerController.getCustomerById(1L);
		assertEquals("firstName", customer.getFirstName());
	}

	@Test
	void given_createCustomer_when_calledWithData_expect_status_ok() {
		Customer cus = testData.getCustomer();
		doNothing().when(customerService).addCustomer(Mockito.any(Customer.class));
		customerController.createCustomer(cus);
		Mockito.verify(customerService, Mockito.times(1)).addCustomer(cus);
	}

	@Test
	void given_updateCustomerAddress_when_calledWithAddress_expect_data_updated() {
		given(customerService.updateCustomerAddress(Mockito.anyLong(), Mockito.anyString()))
				.willReturn(testData.getCustomer());
		Customer customer = customerController.updateCustomerAddress(1L, "address");
		assertEquals("address", customer.getAddress());
	}

}
