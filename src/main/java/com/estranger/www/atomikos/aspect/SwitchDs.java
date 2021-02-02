package com.estranger.www.atomikos.aspect;




import com.estranger.www.atomikos.common.enumeration.DbEnum;

import java.lang.annotation.*;


/**
 * Author：Estranger
 * Description：自定义注解，用于切换数据源
 * Date：2020/7/24
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SwitchDs {

    DbEnum name();

}
