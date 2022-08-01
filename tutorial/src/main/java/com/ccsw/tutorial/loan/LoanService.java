package com.ccsw.tutorial.loan;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;

import com.ccsw.tutorial.loan.model.Loan;
import com.ccsw.tutorial.loan.model.LoanDto;
import com.ccsw.tutorial.loan.model.LoanSearchDto;

/**
 * @author Francisco Sanz Pino.
 */
public interface LoanService {

    /**
     * Método para recuperar un listado paginado de
     * {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param dto Data Transfer Object de Loan.
     * @return Listado paginado.
     */
    Page<Loan> findPage(Long customerId, Long gameId, Date searchDate, LoanSearchDto dto);

    /**
     * Comprueba las fechas de préstamo de un determinado juego y si coinciden con
     * la fecha de préstamo y la fecha de devolución solicitadas por el cliente.
     * 
     * @param game_id   Juego a consultar.
     * @param loan_date Fecha de préstamo.
     * @param end_date  Fecha de devolución.
     * @return Listado de juegos que coinciden con esas fechas.
     */
    List<Loan> findBorrowedGame(Long game_id, Date loan_date, Date end_date);

    /**
     * Comprueba los préstamos vigentes que tiene un cliente entre las fechas
     * solicitadas.
     * 
     * @param customer_id Cliente a consultar.
     * @param loan_date   Fecha de préstamo.
     * @param end_date    Fecha de devolución del préstamo.
     * @return Listado de préstamos.
     */
    List<Loan> findExistingLoans(Long customer_id, Date loan_date, Date end_date);

    /**
     * Método para crear o actualizar un {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param id   Id del préstamo a crear o actualizar.
     * @param data Objeto LoanDto.
     */
    int save(Long id, LoanDto data);

    /**
     * Método para borrar un {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param id Id del préstamo a borrar.
     */
    void delete(Long id);

}
