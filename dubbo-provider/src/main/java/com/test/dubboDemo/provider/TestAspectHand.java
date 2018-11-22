package com.test.dubboDemo.provider;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class TestAspectHand {

    public void pointCut(){
        System.out.println("pointCut");
    }

    public void doBefore(JoinPoint joinPoint){
        System.out.println("---执行前-----");
    }

    public void doAfter(JoinPoint joinPoint){
        System.out.println("----执行后------");
    }

    public Object afterReturn(JoinPoint joinPoint,Object returnVal){
        System.out.println("-----返回值后-------"+returnVal);
        returnVal = "返回值后";
        return returnVal;
    }

    public void afterThrow(JoinPoint joinPoint,Throwable error){
        System.out.println("------抛异常后------"+error);
    }

    public Object arround(ProceedingJoinPoint pjp){
        System.out.println("------arround before-----");
        Object returnVal = null;
        try {
            returnVal = pjp.proceed();
            System.out.println("返回值：---"+returnVal);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("------arround after-----");
        returnVal = "修改后";
        return returnVal;
    }
}
