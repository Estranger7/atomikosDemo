package com.estranger.www.atomikos.mapper;


import com.estranger.www.atomikos.domain.UserAccount;

public interface UserAccountMapper {
    int insertSelective(UserAccount record);

}