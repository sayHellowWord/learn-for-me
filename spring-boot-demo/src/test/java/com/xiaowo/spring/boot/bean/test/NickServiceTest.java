package com.xiaowo.spring.boot.bean.test;


import com.xiaowo.spring.boot.bean.INickService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by nick on 2019/6/4.
 *
 * @author nick
 * @date 2019/6/4
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NickServiceTest {

    @Before
    public void init() {
        System.out.println("开始测试-----------------");
    }

    @After
    public void after() {
        System.out.println("测试结束-----------------");
    }

    @Autowired
    INickService nickService;

    @Test
    public void test() {
        Assert.assertSame("账户id有误", "nick", nickService.test("nick"));
    }

}
