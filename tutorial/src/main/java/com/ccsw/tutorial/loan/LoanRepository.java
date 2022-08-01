package com.ccsw.tutorial.loan;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ccsw.tutorial.loan.model.Loan;

public interface LoanRepository extends CrudRepository<Loan, Long> {

    /**
     * Método para recuperar un listado paginado de
     * {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param pageable
     * @return
     */
    @Query("select l from Loan l where (:customer is null or l.customer.id = :customer) and (:game is null or l.game.id = :game) and (:date is null or :date between l.loan_date and l.end_date)")
    Page<Loan> find(@Param("customer") Long customer, @Param("game") Long game, @Param("date") Date date,
            Pageable pageable);

    /**
     * Método para recuperar un listado filtado por juego y por fechas de inicio y
     * fin.
     * 
     * @param game      Juego a buscar
     * @param loan_date Fecha de inicio del préstamo
     * @param end_date  Fecha de devolución del préstamo
     * 
     * @return Devuelve si un juego ha sido prestado en el rango de fechas dado por
     *         loan_date y end_date.
     */
    @Query("select l from Loan l where (l.game.id = :game) and ((l.loan_date between :loan_date and :end_date) or (l.end_date between :loan_date and :end_date) or (:loan_date between l.loan_date and l.end_date) or (:end_date between l.loan_date and l.end_date))")
    List<Loan> findBorrowedGame(@Param("game") Long game, @Param("loan_date") Date loan_date,
            @Param("end_date") Date end_date);

    /**
     * Método para recuperar un listado filtrado por cliente, fecha de inicio y fin.
     * Permite determinar si UN cliente tiene DOS o más juegos prestados en el rango
     * de fechas indicado.
     * 
     * @param customer  Cliente a consultar
     * @param loan_date Fecha de inicio de préstamo
     * @param end_date  Fecha de devolución del préstamo
     * 
     * @return Devuelve si un cliente tiene un préstamo pendiente entre las fechas
     *         indicadas como parámetros loan_date y end_date.
     */
    @Query("select l from Loan l where (l.customer.id = :customer) and ((l.loan_date between :loan_date and :end_date) or (l.end_date between :loan_date and :end_date) or (:loan_date between l.loan_date and l.end_date) or (:end_date between l.loan_date and l.end_date))")
    List<Loan> findNumberOfLoans(@Param("customer") Long customer, @Param("loan_date") Date loan_date,
            @Param("end_date") Date end_date);

}
