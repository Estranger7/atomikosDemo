package com.estranger.www.atomikos.domain;

import java.math.BigDecimal;
import java.util.Date;

public class UserAccount {
    private Integer id;

    private String uid;

    private BigDecimal balancePrice;

    private BigDecimal withdrawalPrice;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public BigDecimal getBalancePrice() {
        return balancePrice;
    }

    public void setBalancePrice(BigDecimal balancePrice) {
        this.balancePrice = balancePrice;
    }

    public BigDecimal getWithdrawalPrice() {
        return withdrawalPrice;
    }

    public void setWithdrawalPrice(BigDecimal withdrawalPrice) {
        this.withdrawalPrice = withdrawalPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}