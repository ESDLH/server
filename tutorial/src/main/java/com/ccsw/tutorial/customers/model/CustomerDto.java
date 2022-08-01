package com.ccsw.tutorial.customers.model;

/**
 * Objeto DTO de la clase Customer.
 * 
 * @author Francisco Sanz Pino.
 *
 */
public class CustomerDto {

    private Long id;
    private String name;

    /**
     * @return id
     */
    public Long getId() {

        return this.id;
    }

    /**
     * @param id new value of {@link #getId}
     */
    public void setId(Long id) {

        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {

        return this.name;
    }

    /**
     * @param name new value of {@ling #getName}
     */
    public void setName(String name) {

        this.name = name;
    }

}
