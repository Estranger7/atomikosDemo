package com.estranger.www.atomikos.service.impl;

import com.estranger.www.atomikos.domain.User;
import com.estranger.www.atomikos.domain.UserAccount;
import com.estranger.www.atomikos.mapper.master.UserAccountMapper;
import com.estranger.www.atomikos.mapper.slave.UserMapper;
import com.estranger.www.atomikos.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

/**
 * Author：Estranger
 * Description：
 * Date：2021/2/2
 */
@Service("TestService")
public class TestServiceImpl implements TestService {

    @Autowired
    private UserAccountMapper userAccountMapper;
    @Autowired
    private UserMapper userMapper;


    @Transactional
    @Override
    public void test() {
        UserAccount userAccount = new UserAccount();
        userAccount.setBalancePrice(BigDecimal.ZERO);
        userAccount.setUid("39605382");
        userAccount.setWithdrawalPrice(BigDecimal.ZERO);
        userAccountMapper.insertSelective(userAccount);

        int j = 10/0;
        User user = new User();
        user.setName("123");
        user.setAge(1);
        userMapper.insert(user);
    }

}