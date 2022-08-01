package com.ccsw.tutorial.customers;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.tutorial.customers.model.Customer;

/**
 * Repository de Customer.
 * 
 * @author Francisco Sanz Pino.
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
