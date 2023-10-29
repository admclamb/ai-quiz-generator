package com.aiquizgenerator.backend.generator.repositories;

import com.aiquizgenerator.backend.data.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findByName(String name);
}
