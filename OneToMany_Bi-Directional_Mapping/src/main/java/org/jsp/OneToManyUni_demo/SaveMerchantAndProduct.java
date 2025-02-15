package org.jsp.OneToManyUni_demo;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMerchantAndProduct {
	public static void main(String[] args) {
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		EntityTransaction tran = man.getTransaction();
		tran.begin();
		
		Merchant m = new Merchant();
		m.setName("Manish");
		m.setPhone(7899877890l);
		m.setGst_number("asdf1234f");
		m.setEmail("manish@gmail.com");
		m.setPassword("Manish@123");
		
		Product p1 = new Product();
		p1.setName("TV");
		p1.setBrand("Sony");
		p1.setCategory("Electronics");
		p1.setMerchant(m);

		Product p2 = new Product();
		p2.setName("fan");
		p2.setBrand("Usha");
		p2.setCategory("Electrical");
		p2.setMerchant(m);
		
		m.setProducts(Arrays.asList(p1, p2));
		
		man.persist(m);
		tran.commit();
	}
}
