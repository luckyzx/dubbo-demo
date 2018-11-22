/**
 * Copyright (C), 2018-2018, XXX有限公司
 * FileName: DubboCustomer
 * Author:   Administrator
 * Date:     2018/11/20 16:15
 * Description: dubbo客户端
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.test.dubboDemo.customer;

import com.test.dubboDemo.api.ITestDubbo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 〈一句话功能简述〉<br> 
 * 〈dubbo客户端〉
 *
 * @author Administrator
 * @create 2018/11/20
 * @since 1.0.0
 */
public class DubboCustomer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF.spring/dubbo-customer.xml"});
        context.start();
        ITestDubbo service = (ITestDubbo)context.getBean("testDubbo");
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println(service.sayHello("word"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
