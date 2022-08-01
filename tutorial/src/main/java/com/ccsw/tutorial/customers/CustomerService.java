package com.ccsw.tutorial.customers;

import java.util.List;

import com.ccsw.tutorial.customers.model.Customer;
import com.ccsw.tutorial.customers.model.CustomerDto;

/**
 * Service de la clase Customer.
 * 
 * @author Francisco Sanz Pino.
 *
 */
public interface CustomerService {

    /**
     * Recupera un {@link com.ccsw.tutorial.author.model.Customer} a través de su ID
     * 
     * @param id
     * @return
     */
    Customer get(Long id);

    /**
     * Método para recuperar todos los
     * {@link com.ccsw.tutorial.customers.model.Customer }
     * 
     * @return
     */
    List<Customer> findAll();

    /**
     * Método para crear o actualizar un
     * {@link com.ccsw.tutorial.customers.model.Customer }
     * 
     * @param dto
     */
    void save(Long id, CustomerDto dto);

    /**
     * Método para borrar un {@link com.ccsw.tutorial.customers.model.Customer }
     * 
     * @param id
     */
    void delete(Long id);

}
