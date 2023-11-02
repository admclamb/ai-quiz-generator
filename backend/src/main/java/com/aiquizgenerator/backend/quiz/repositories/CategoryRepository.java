package com.aiquizgenerator.backend.generator.repositories;

import com.aiquizgenerator.backend.data.entities.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findByName(String name);
}
