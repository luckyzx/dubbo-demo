/**
 * Copyright (C), 2018-2018, XXX有限公司
 * FileName: TestDubboImp
 * Author:   Administrator
 * Date:     2018/11/20 15:09
 * Description: dubbo服务提供者测试类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.test.dubboDemo.provider;

import com.alibaba.dubbo.rpc.RpcContext;
import com.test.dubboDemo.api.ITestDubbo;

/**
 * 〈一句话功能简述〉<br>
 * 〈dubbo服务提供者测试类〉
 *
 * @author Administrator
 * @create 2018/11/20
 * @since 1.0.0
 */
public class TestDubboImp implements ITestDubbo<String> {
    @Override
    public String sayHello(String name) {
        System.out.println("**"+ RpcContext.getContext().getRemoteAddressString());
        return "Hello" + name;
    }
}
