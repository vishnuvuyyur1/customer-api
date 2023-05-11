package com.company.api.customer;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.company.core.customer.entity.Customer;

@Component
public class TestData {

	public Customer getCustomer() {
		return Customer.builder().firstName("firstName").lastName("lastName").age((short) 10).address("address")
				.build();
	}

	public List<Customer> getCustomers() {
		return Arrays.asList(
				Customer.builder().firstName("firstName").lastName("lastName").age((short) 10).address("address")
						.build(),
				Customer.builder().firstName("firstName1").lastName("lastName1").age((short) 11).address("address1")
						.build(),
				Customer.builder().firstName("firstName2").lastName("lastName2").age((short) 12).address("address2")
						.build());
	}
}
