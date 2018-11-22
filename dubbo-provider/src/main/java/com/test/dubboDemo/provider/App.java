package com.test.dubboDemo.provider;

import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void print(String... str){
        System.out.println("---测试--"+str);
    }
    public static void main( String[] args ) throws Exception
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF.spring/dubbo-provider.xml"});
        System.out.println("----------生产者开始启动-------------"+ RpcContext.getContext().getLocalAddressString());
        context.start();
        System.out.println("----------生产者启动完成------------------");
        System.in.read();
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring.xml"});
        ITestDubbo testDubbo = (ITestDubbo)context.getBean("testDubbo");
        System.out.println("原方法----"+testDubbo.sayHello("ffff"));*/
    }
}
