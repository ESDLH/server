package com.ccsw.tutorial.loan;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ccsw.tutorial.customers.CustomerService;
import com.ccsw.tutorial.game.GameService;
import com.ccsw.tutorial.loan.model.Loan;
import com.ccsw.tutorial.loan.model.LoanDto;
import com.ccsw.tutorial.loan.model.LoanSearchDto;

@Service
@Transactional
public class LoanServiceImpl implements LoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    GameService gameService;

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Loan> findPage(Long customerId, Long gameId, Date searchDate, LoanSearchDto dto) {

        return this.loanRepository.find(customerId, gameId, searchDate, dto.getPageable());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Loan> findBorrowedGame(Long game_id, Date loan_date, Date end_date) {

        return this.loanRepository.findBorrowedGame(game_id, loan_date, end_date);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Loan> findExistingLoans(Long customer_id, Date loan_date, Date end_date) {

        return this.loanRepository.findNumberOfLoans(customer_id, loan_date, end_date);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int save(Long id, LoanDto data) {

        Loan loan = null;

        if (gameIsBorrowed(data) == true) {
            return 100;
        } else if (customerIsTwoOrMoreLoans(data) == true) {
            return 200;
        } else {
            loan = new Loan();

            BeanUtils.copyProperties(data, loan, "id", "customer", "game");

            loan.setCustomer(customerService.get(data.getCustomer().getId()));
            loan.setGame(gameService.get(data.getGame().getId()));

            this.loanRepository.save(loan);

            return 0;
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {

        this.loanRepository.deleteById(id);
    }

    /**
     * Comprueba si el juego ya ha sido prestado.
     * 
     * @param dto Préstamo que se quiere validar antes de guardarlo.
     * 
     * @return Boolean. True si el juego ya ha sido prestado.
     */
    private boolean gameIsBorrowed(LoanDto dto) {

        boolean result = false;

        List<Loan> loans = (List<Loan>) this.findBorrowedGame(dto.getGame().getId(), dto.getLoan_date(),
                dto.getEnd_date());

        if (loans.size() == 0)
            result = false;
        else
            result = true;

        return result;
    }

    /**
     * Comprueba si un cliente tiene dos o más préstamos en una misma fecha.
     * 
     * @param dto Préstamo que se desea validar antes de guardar.
     * 
     * @return Boolean. True si un cliente tiene dos o más préstamos.
     */
    private boolean customerIsTwoOrMoreLoans(LoanDto dto) {

        boolean result = false;

        List<Loan> loans = (List<Loan>) this.findExistingLoans(dto.getCustomer().getId(), dto.getLoan_date(),
                dto.getEnd_date());

        if (loans.size() == 2)
            result = true;
        else
            result = false;

        return result;
    }
}
