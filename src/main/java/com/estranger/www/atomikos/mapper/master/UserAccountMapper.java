package com.estranger.www.atomikos.mapper.master;


import com.estranger.www.atomikos.domain.UserAccount;

public interface UserAccountMapper {
    int insertSelective(UserAccount record);

}