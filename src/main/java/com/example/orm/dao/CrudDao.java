package com.example.orm.dao;

public interface CrudDao <T> extends SuperDao{
    boolean save(T entity) throws Exception;
}
