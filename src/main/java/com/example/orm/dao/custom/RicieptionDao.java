package com.example.orm.dao.custom;

import com.example.orm.dao.CrudDao;
import com.example.orm.entity.Ricieption;

public interface RicieptionDao extends CrudDao<Ricieption>{

    boolean authLogin(String email, String password);

}
