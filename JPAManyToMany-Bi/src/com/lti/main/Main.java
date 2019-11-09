package com.lti.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.lti.model.Order;
import com.lti.model.Product;



public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA_PU");
		EntityManager entityManager = factory.createEntityManager();
		
		//Define Products
		Product elecProduct = new Product();
		elecProduct.setProductId(1);
		elecProduct.setProductName("LED TV");
		elecProduct.setProductPrice(45000);
		
		Product beautyProduct = new Product();
		beautyProduct.setProductId(2);
		beautyProduct.setProductName("Face Wash");
		beautyProduct.setProductPrice(80);
		
		Product babyProduct = new Product();
		babyProduct.setProductId(3);
		babyProduct.setProductName("Pampers");
		babyProduct.setProductPrice(15);
		
		Product eleProduct = new Product();
		eleProduct.setProductId(4);
		eleProduct.setProductName("CFL Bulb");
		eleProduct.setProductPrice(250);
		
		//Define first order and add few products
		Order firstOrder = new Order();
		firstOrder.setOrderId(1000);
		firstOrder.setPurchaseDate(new Date());
		
		firstOrder.addProduct(babyProduct);
		firstOrder.addProduct(elecProduct);
		firstOrder.addProduct(beautyProduct);
		
		//Define second order and add few products
		Order secondOrder = new Order();
		secondOrder.setOrderId(1001);
		secondOrder.setPurchaseDate(new Date());
		
		secondOrder.addProduct(babyProduct);
		secondOrder.addProduct(elecProduct);
		secondOrder.addProduct(eleProduct);
		
		
		//save orders using entity manager
		entityManager.getTransaction().begin();
		entityManager.persist(firstOrder);
		entityManager.persist(secondOrder);
		entityManager.getTransaction().commit();
		
		
	}

}
