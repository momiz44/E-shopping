package com.niit.testcases;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierUnitTest {

	static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();	
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	@Ignore
	@Test
	public void addSupplierTest() 
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName("T-Shirt");
		supplier.setSupplierAddr("Round Neck T-Shirt of all Variety");		
		assertTrue("Problem in adding Supplier",supplierDAO.addSupplier(supplier));
	}
	@Ignore
	@Test
	public void deleteSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(1);
	assertTrue("Problem in Deleting Supplier:",supplierDAO.deleteSupplier(supplier));
	}
	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(2);
		supplier.setSupplierAddr("Pencil cut Jeans with Chain");
	assertTrue("Problem in Updating the Supplier",supplierDAO.updateSupplier(supplier));
	}
	@Ignore
	@Test
	public void listSuppliersTest()
	{
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		assertTrue("Problem in Listing Suppliers:",listSuppliers.size()>0);
		
		for(Supplier supplier:listSuppliers)
		{
			System.out.println("Supplier ID:"+supplier.getSupplierId());
			System.out.println("Supplier Name:"+supplier.getSupplierName());
			System.out.println("Supplier Desc:"+supplier.getSupplierAddr());
		}
}
	
}
