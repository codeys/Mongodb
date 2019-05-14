package com.mongodb.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.dao.DepartmentMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringTest {
	
	@Autowired
    DepartmentMapper deptMapper;
	
	
	@Test
	public void test() {
		// 1.创建Spring IOC 容器
		//ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		// 2.获取bean
		//DepartmentMapper deptMapper = context.getBean(DepartmentMapper.class);
		System.out.println(deptMapper);
	}

}
