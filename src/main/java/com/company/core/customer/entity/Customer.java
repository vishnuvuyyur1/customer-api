package com.company.core.customer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder // for unit tests
@AllArgsConstructor// for unit tests
@NoArgsConstructor// used internally by jpa
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "CUSTOMER_SEQUENCE")
	@SequenceGenerator(name = "CUSTOMER_SEQUENCE", sequenceName = "CUSTOMER_SEQ", allocationSize = 1) // for flyway
	Long id;
	String firstName;
	String lastName;
	short age;
	String address;
}
