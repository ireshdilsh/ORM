package com.example.orm.service.custom;

import com.example.orm.dto.AdminDto;
import com.example.orm.service.SuperService;

public interface AdminService extends SuperService{

    boolean saveAdmin(AdminDto adminDto) throws Exception;

}
