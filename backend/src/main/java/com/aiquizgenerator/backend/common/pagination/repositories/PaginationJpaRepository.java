package com.aiquizgenerator.backend.common.pagination.repositories;

import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
@NonNullApi
public interface PaginationJpaRepository<T, ID> extends JpaRepository<T, ID> {
//    Page<T> findAll(Pageable pageable);
}
