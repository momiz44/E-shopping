package com.niit.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.OrderDao;
import com.niit.model.OrderDetail;

@Repository("orderDao")
@Transactional
public class OrderDaoImpl implements OrderDao
{
    @Autowired
    SessionFactory sessionFactory;
	
	public boolean saveOrder(OrderDetail orderDetail) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public boolean updateCart(String username) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update CartItem set paymentstatus='P' where username=:uname");
		query.setParameter("uname", username);
		int row_eff=query.executeUpdate();
		
		if(row_eff>0)
			return true;
		else		
		return false;
	}

}
