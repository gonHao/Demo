package com.gh.Demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}
//	@Test
//	public void testDao(){
//		AbstractApplicationContext ac =
//				new ClassPathXmlApplicationContext("application.yml");
//		TestMapper iTestMapper = ac.getBean("iTestMapper",TestMapper.class);
//		iTestMapper.selectByUsername("abc");
//	}

}
