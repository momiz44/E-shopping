package com.niit.testcases;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;
import com.niit.model.UserInfo;

public class UserInfoTest {

static UserDao userDao;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.niit");
	    context.refresh();
	    
	    userDao=(UserDao)context.getBean("userDao");
	}
	
	@Test
	public void registerUserTest() 
	{
		UserInfo user=new UserInfo();
		
		user.setUsername("Rahul");
		user.setPassword("P369");
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		user.setCustomerName("Rahul Singh");
		user.setCustomerAddr("Delhi");
		
		assertTrue("Problem in adding User:",userDao.registerUser(user));
	}

	
}
