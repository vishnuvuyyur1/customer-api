package com.company.api.customer;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.company.core.customer.entity.Customer;
import com.company.core.customer.service.CustomerService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerService customerService;
	
	/** will respond to all GET
	 *  1. /customers
	 *  2. /customers?firstName=hello
	 *  3. /customers?lastName=world
	 *  4. /customers?firstName=hello&lastName=world
	 */
	@GetMapping
	public List<Customer> getCustomers(@RequestParam Map<String, String> paramsMap) {
		return customerService.getCustomers(paramsMap);
	}

	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable(value = "id") Long customerId) {
		return customerService.getCustomerById(customerId);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}

	// for the assignment the scope for address is a string
	@PutMapping("/{id}/address")
	public Customer updateCustomerAddress(@PathVariable(value = "id") Long customerId, @RequestBody String address) {
		return customerService.updateCustomerAddress(customerId, address);
	}
}
