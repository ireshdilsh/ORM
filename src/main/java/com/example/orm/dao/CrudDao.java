package com.example.orm.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao <T> extends SuperDao{
    boolean save(T entity) throws Exception;
    boolean update(T t);
    boolean deleteByPK(int id) throws Exception;
    List<T> getAll();
    T findByPK(int id);
    Optional<String> getLastPK();
}
