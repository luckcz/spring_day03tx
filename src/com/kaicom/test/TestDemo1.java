package com.kaicom.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kaicom.service.AccountService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestDemo1 {
	@Resource(name = "accountService")
	private AccountService service ;
	@Test
	public void fun1(){
		service.transfer(1, 2, 30d);
		System.out.println("×ªÕË³É¹¦£¡£¡£¡");
	}
}
