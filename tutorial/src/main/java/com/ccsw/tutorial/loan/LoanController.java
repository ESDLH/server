package com.ccsw.tutorial.loan;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ccsw.tutorial.config.mapper.BeanMapper;
import com.ccsw.tutorial.loan.model.LoanDto;
import com.ccsw.tutorial.loan.model.LoanSearchDto;

/**
 * Controlador de la clase Loan.
 * 
 * @author Francisco Sanz Pino.
 *
 */
@RequestMapping(value = "/loan")
@RestController
@CrossOrigin(origins = "*")
public class LoanController {

    @Autowired
    LoanService loanService;

    @Autowired
    BeanMapper beanMapper;

    /**
     * Método para recuperar un listado paginado de
     * {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param dto Data Transfer Object de Loan.
     * @return Listado paginado.
     */
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Page<LoanDto> findPage(@RequestParam(value = "customerId", required = false) Long customerId,
            @RequestParam(value = "gameId", required = false) Long gameId,
            @RequestParam(value = "searchDate", required = false) Date searchDate, @RequestBody LoanSearchDto dto) {

        return this.beanMapper.mapPage(this.loanService.findPage(customerId, gameId, searchDate, dto), LoanDto.class);
    }

    /**
     * Método para crear o actualizar un {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param id   Id del préstamo a crear o actualizar.
     * @param data Objeto LoanDto.
     * @return int. 0 si se ha guardado correctamente. 100 si el juego está
     *         prestado. 200 si el cliente tiene dos o más juegos prestados en un
     *         determinado día.
     */
    @ResponseBody
    @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
    public int save(@PathVariable(name = "id", required = false) Long id, @RequestBody LoanDto data) {

        return this.loanService.save(id, data);
    }

    /**
     * Método para borrar un {@link com.ccsw.tutorial.loan.model.Loan}
     * 
     * @param id Id del préstamo a borrar.
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {

        this.loanService.delete(id);

    }

}
