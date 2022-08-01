package com.ccsw.tutorial.author;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.ccsw.tutorial.author.model.Author;

/**
 * Clase Repositorio de Author.
 * 
 * @author Francisco Sanz Pino.
 *
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

    /**
     * Recuperar listado paginado de {@link com.ccsw.tutorial.author.model.Author}
     */
    Page<Author> findAll(Pageable pageable);
}
