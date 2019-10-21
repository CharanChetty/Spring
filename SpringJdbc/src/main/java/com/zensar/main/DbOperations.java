package com.zensar.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.entities.Product;
import com.zensar.services.ProductService;

public class DbOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("dbconfig.xml");
		ProductService productService = ctx.getBean("productServiceImpl", ProductService.class);
		List<Product> products = productService.findallProduct();
		for (Product p : products) {
			System.out.println(p);
		}
		/*
		 * Product p= productService.findProductsById(20); if(p!=null) {
		 * p.setName("Tv"); p.setBrand("LG"); p.setPrice(34000);
		 * productService.updateProduct(p); } else {
		 * System.out.println("product not found"); }
		 */

		// System.out.println(p);

		/*
		 * Product product=new Product(35,"Laptop","HP",35000);
		 * productService.addproduct(product);
		 */
		Product p = productService.findProductsById(20);
		if (p != null) {

			productService.removeProduct(p);
		} else {

			System.out.println("product not found");
		}

	}

}