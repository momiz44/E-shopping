package com.niit.dao;

import java.util.List;


import com.niit.model.OrderDetail;

public interface OrderDao 
{
	public boolean saveOrder(OrderDetail orderDetail);
    public boolean updateCart(String username);
    
}
