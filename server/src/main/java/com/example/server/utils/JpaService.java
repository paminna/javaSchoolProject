package com.example.server.utils;

import com.example.server.person.PersonRepository;
import com.example.server.utils.Dao;
import com.example.server.utils.JpaUtil;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Getter
@Transactional
//@EnableJpaRepositories("com.example.server.*")
//@ComponentScan(basePackages = { "com.example.server.*" })
//@EntityScan("com.example.server.*")
public class JpaService<T, ID extends Serializable, R extends JpaUtil<T, ID>> implements Dao<T, ID> {
    private R dao;

    protected JpaService() {
    }


    @Override
    public List<T> findAll() {
        return dao.findAll();
    }


    @Override
    public Optional<T> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<T> getAll() {
        return getAll();
    }

    @Override
    public void save(T t) {
        dao.save(t);
    }

    @Override
    public void delete(T t) {
        dao.delete(t);
    }
}
