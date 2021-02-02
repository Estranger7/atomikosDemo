package com.estranger.www.atomikos.service.impl;

import com.estranger.www.atomikos.dao.UserDao;
import com.estranger.www.atomikos.domain.User;
import com.estranger.www.atomikos.domain.UserAccount;
import com.estranger.www.atomikos.mapper.UserAccountMapper;
import com.estranger.www.atomikos.service.MerchantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigDecimal;

/**
 * Author：Estranger
 * Description：
 * Date：2021/2/2
 */
@Service("MerchantInfoService")
public class MerchantInfoServiceImpl implements MerchantInfoService {

    @Autowired
    private UserAccountMapper userAccountMapper;
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void test() {
        UserAccount userAccount = new UserAccount();
        userAccount.setBalancePrice(BigDecimal.ZERO);
        userAccount.setUid("39605382");
        userAccount.setWithdrawalPrice(BigDecimal.ZERO);
        userAccountMapper.insertSelective(userAccount);

        int i = 10/0;
        User user = new User();
        user.setName("123");
        user.setAge(1);
        userDao.insert(user);

    }
}