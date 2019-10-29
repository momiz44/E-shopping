package com.niit.dao;

import java.util.List;

import com.niit.model.CartItem;

public interface CartDao 
{
	public boolean addCartItem(CartItem cartItem);
    public boolean deleteCartItem(CartItem cartItem);
    public boolean updateCartItem(CartItem cartItem);
    public CartItem getCartItem(int cartItemId);
	
    public List<CartItem> listCartItems(String username);
	
}
