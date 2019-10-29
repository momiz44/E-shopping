package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

public class ProductController {


    @Autowired
    ProductDAO productDao;
	
	
	@RequestMapping("/category")
	public String showCategory(Model m)
	{
		List<Product> listProducts=productDao.listProducts();
		m.addAttribute("listProducts",listProducts);
		m.addAttribute("pageinfo","Manage Product");
		return "Product";
	}
	@RequestMapping(value="/AddProduct",method=RequestMethod.POST)
	public String addProduct(Model m,@RequestParam("cName")String productName,@RequestParam("cDesc")String productDesc)
	{
		Product product=new Product();
		product.setProductName(productName);
		product.setProductDesc(productDesc);
		productDao.addProduct(product);
		
		List<Product> listProducts=productDao.listProducts();
		m.addAttribute("listProducts", listProducts);
		
		m.addAttribute("pageinfo","Manage Product");
		return "Product";
	}
	
	@RequestMapping(value="/deleteProduct/{ProductId}")
	public String deleteProduct(Model m,@PathVariable("productId")int productId)
	{
		Product product=productDao.getProduct(productId);
		productDao.deleteProduct(product);
		
		m.addAttribute("pageinfo","Manage Product");
		return "Product";
	}
		@RequestMapping(value="/UpdateProduct",method=RequestMethod.POST)
	public String updateProduct(Model m,@RequestParam("cId")int productId,@RequestParam("cName")String productName,@RequestParam("cDesc")String productDesc)
	{
			Product product=productDao.getProduct(productId);
			product.setProductName(productName);
			product.setProductDesc(productDesc);
			productDao.updateProduct(product);
		
		List<Product> listProducts=productDao.listProducts();
		m.addAttribute("listProducts", listProducts);
		
		m.addAttribute("pageinfo","Manage Product");
		return "Product";
	}
		@RequestMapping(value="/editProduct/{ProductId}")
		public String editProduct(Model m,@PathVariable("productId")int productId)
		{
			Product product=productDao.getProduct(productId);
			
			m.addAttribute("product",product);
			m.addAttribute("pageinfo","Manage Product");
			return "UpdateProduct";
		}

	
}
