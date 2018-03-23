package com.ftd.rabbitmq;

import com.ftd.UnitTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 一句话描述这个类的作用
 *
 * @author liukl
 * @date 2018/3/21
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTest {
    @Autowired
    private UnitTest unitTest;

    @Before
    public void init(){
        System.out.println("初始化单元测试资源");
    }
    @Test
    public void hello(){
        unitTest.sys("单元测试");
    }

    @After
    public void close(){
        System.out.println("关闭单元测试资源");
    }


}
