package com.example.server.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import java.io.Serializable;

/**
 * универсальный репозиторий для запросов в базу данных
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface JpaUtil<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}
