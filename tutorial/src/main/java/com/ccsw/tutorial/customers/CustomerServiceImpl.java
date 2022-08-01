package com.ccsw.tutorial.customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.customers.model.Customer;
import com.ccsw.tutorial.customers.model.CustomerDto;

/**
 * Implementación CustomerService
 * 
 * @author Francisco Sanz Pino.
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Customer get(Long id) {

        return this.customerRepository.findById(id).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Customer> findAll() {

        return (List<Customer>) this.customerRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Long id, CustomerDto dto) {

        Customer customer = null;

        if (id == null)
            customer = new Customer();
        else
            customer = this.customerRepository.findById(id).orElse(null);

        customer.setName(dto.getName());

        this.customerRepository.save(customer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {

        this.customerRepository.deleteById(id);
    }

}
