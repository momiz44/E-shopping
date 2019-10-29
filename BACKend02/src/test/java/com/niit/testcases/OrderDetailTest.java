package com.niit.testcases;



import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.OrderDao;
import com.niit.model.OrderDetail;

public class OrderDetailTest {

static OrderDao orderDao;
    
    @BeforeClass    
    public static void executeFirst()
    {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	    
	    context.scan("com.niit");
	    context.refresh();
	    
	    orderDao=(OrderDao) context.getBean("orderDao");
    }
   
    @Ignore
	@Test
	public void saveOrdertest() 
	{
		OrderDetail orderDetail=new OrderDetail();
		
		orderDetail.setOrderDate(new java.util.Date());
		orderDetail.setCartId(101);
		orderDetail.setShippingAddr("Mumbai");
		orderDetail.setFinalAmount(2000);
		orderDetail.setTranType("COD");
		orderDetail.setUsername("Lucky");
		
		assertTrue("Problem in saving order",orderDao.saveOrder(orderDetail));
	}
	
	@Test
	public void updateCartTest()
	{
		assertTrue("Problem in updating Cart",orderDao.updateCart("Lucky"));
		
	}

	
}
