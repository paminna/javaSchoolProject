package com.example.server.utils;

import com.example.server.person.Person;
import com.example.server.person.PersonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Getter
@Transactional
public class JpaService<T, ID extends Serializable, R extends JpaUtil<T, ID>, D> implements Dao<T, ID> {

    private R dao;

    private final Class<R> daoClass;
    private final Class<T> entityClass;
    private final Class<D> dtoClass;

//    @Autowired
//    ModelMapper modelMapper;

//    public D toDto(T entity) {
//            D dto = modelMapper.map(entity, dtoClass);
//            return dto;
//    }

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    @PostConstruct
    private void initial()
    {
        dao = beanFactory.getBean(daoClass);
    }

    protected JpaService(Class<R> daoClass, Class<T> entityClass, Class<D> dtoClass)
    {
        this.daoClass = daoClass;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    public R getDao()
    {
        return dao;
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
