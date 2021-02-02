package com.estranger.www.atomikos.controller;

import com.estranger.www.atomikos.service.MerchantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by：Estranger
 * Description：
 * Date：2021/1/29 9:55
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private MerchantInfoService merchantInfoService;

    @RequestMapping("/mockHomePage")
    public void selectMockDetail() {
        merchantInfoService.test();
    }
}
