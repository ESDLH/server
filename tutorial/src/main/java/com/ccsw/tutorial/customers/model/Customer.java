package com.ccsw.tutorial.customers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase Entity de Customer.
 * 
 * Contiene los atributos y métodos de un Customer.
 * 
 * @author Francisco Sanz Pino.
 *
 */
@Entity
@Table(name = "Customer")
public class Customer {

    @Id // Identificador de un cliente.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    /**
     * 
     * Devuelve el id del cliente.
     * 
     * @return id
     */
    public Long getId() {

        return this.id;
    }

    /**
     * Establece el id de un cliente.
     * 
     * @param id Long Identificador del cliente.
     */
    public void setId(Long id) {

        this.id = id;
    }

    /**
     * Devuelve el nombre de un cliente.
     * 
     * @return name
     */
    public String getName() {

        return this.name;
    }

    /**
     * Establece el nombre de un cliente.
     * 
     * @param name String Nombre completo del cliente.
     */
    public void setName(String name) {

        this.name = name;
    }

}
