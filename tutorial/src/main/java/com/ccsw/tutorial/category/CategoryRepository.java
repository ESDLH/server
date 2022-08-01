package com.ccsw.tutorial.category;

import org.springframework.data.repository.CrudRepository;

import com.ccsw.tutorial.category.model.Category;

/**
 * Repositorio de acceso a Category.
 * 
 * @author Francisco Sanz Pino.
 *
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
