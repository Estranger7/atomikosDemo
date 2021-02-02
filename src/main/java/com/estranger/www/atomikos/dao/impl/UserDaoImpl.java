package com.estranger.www.atomikos.dao.impl;


import com.estranger.www.atomikos.aspect.SwitchDs;
import com.estranger.www.atomikos.common.enumeration.DbEnum;
import com.estranger.www.atomikos.dao.UserDao;
import com.estranger.www.atomikos.domain.User;
import com.estranger.www.atomikos.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by：Estranger
 * Description：
 * Date：2021/1/29 10:14
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;


    @SwitchDs(name = DbEnum.slave)
    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }
}
