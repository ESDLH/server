package com.ccsw.tutorial.loan.model;

import java.sql.Date;

import com.ccsw.tutorial.customers.model.CustomerDto;
import com.ccsw.tutorial.game.model.GameDto;

/**
 * Data Transfer Object de la clase Loan.
 * 
 * @author Francisco Sanz Pino
 *
 */
public class LoanDto {

    private Long id;

    private GameDto game;

    private CustomerDto customer;

    private Date loan_date;
    private Date end_date;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id new value of {@link #getId}
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return game
     */
    public GameDto getGame() {
        return game;
    }

    /**
     * @param game new value of {@link #getGame}
     */
    public void setGame(GameDto game) {
        this.game = game;
    }

    /**
     * @return customer
     */
    public CustomerDto getCustomer() {
        return customer;
    }

    /**
     * @param customer new value of {@link #getCustomer}
     */
    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    /**
     * @return loan_date
     */
    public Date getLoan_date() {
        return loan_date;
    }

    /**
     * @param loan_date new value of {@link #getLoan_date}
     */
    public void setLoan_date(Date loan_date) {
        this.loan_date = loan_date;
    }

    /**
     * @return end_date
     */
    public Date getEnd_date() {
        return end_date;
    }

    /**
     * @param end_date new value of {@link #getEnd_date}
     */
    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

}
