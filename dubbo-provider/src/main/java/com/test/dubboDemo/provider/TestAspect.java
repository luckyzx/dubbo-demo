package com.test.dubboDemo.provider;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component(value="testAspect")
public class TestAspect {
    @Pointcut("execution(* com.test.dubboDemo..*.*(..))")
    public void pointCut(){
        System.out.println("pointCut");
    }
    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("---执行前-----");
    }
    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("----执行后------");
    }
    @AfterReturning(value="pointCut()",returning = "returnVal")
    public Object afterReturn(JoinPoint joinPoint,Object returnVal){
        System.out.println("-----返回值后-------"+returnVal);
        returnVal = "返回值后";
        return returnVal;
    }
    @AfterThrowing(value="pointCut()",throwing = "error")
    public void afterThrow(JoinPoint joinPoint,Throwable error){
        System.out.println("------抛异常后------"+error);
    }
    @Around("pointCut()")
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
