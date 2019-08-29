package com.ly.spring;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerApplication.class)
public class SpringBootBaseTest {
	@Before
	public void init() {
		System.out.println("开始smart单元测试");
	}
	
	@After
	public void after() {
		System.out.println("结束smart单元测试");
	}

}
