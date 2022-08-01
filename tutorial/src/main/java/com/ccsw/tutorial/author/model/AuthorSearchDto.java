package com.ccsw.tutorial.author.model;

import org.springframework.data.domain.Pageable;

/**
 * Dto de búsqueda sobre autores.
 * 
 * @author Francisco Sanz Pino.
 *
 */
public class AuthorSearchDto {

    private Pageable pageable;

    /**
     * @return pageable
     */
    public Pageable getPageable() {

        return this.pageable;
    }

    /**
     * @param pageable new value of {@link #getPageable}
     */
    public void setPageable(Pageable pageable) {

        this.pageable = pageable;
    }
}