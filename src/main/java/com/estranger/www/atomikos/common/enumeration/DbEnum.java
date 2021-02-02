package com.estranger.www.atomikos.common.enumeration;

/**
 * Author：Estranger
 * Description：数据源枚举类
 * Date：2021/1/26
 */
public enum DbEnum {

    master("master"),slave("slave");

    private String value;

    public String getValue() {
        return value;
    }

    DbEnum(String value){
        this.value = value;
    }

}
