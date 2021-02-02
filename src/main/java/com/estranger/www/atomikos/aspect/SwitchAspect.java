package com.estranger.www.atomikos.aspect;

import com.estranger.www.atomikos.config.DbContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * Author：Estranger
 * Description：切换数据源通知类
 * Date：2020/7/24
 */
@Component
@Aspect
@Order(value = -10)
public class SwitchAspect {

   @Pointcut("@annotation(com.estranger.www.atomikos.aspect.SwitchDs)")
    public void dsPointCut(){

   }

   @Around("dsPointCut()")
    public Object around(ProceedingJoinPoint joinPoint){
       MethodSignature signature = (MethodSignature) joinPoint.getSignature();
       Method method = signature.getMethod();
       SwitchDs annotation = method.getAnnotation(SwitchDs.class);

       if(annotation != null){//定义了切点，则取切点上定义的数据源进行切换
           DbContextHolder.setDbType(annotation.name().getValue());
       }
       Object proceed = null;
       try {
           proceed = joinPoint.proceed();
       } catch (Throwable throwable) {
           throwable.printStackTrace();
       }finally {
           DbContextHolder.clearDbType();//清除数据源
       }
       return proceed;
   }
}
