package manyToOneBi_Demo;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class saveData {
	public static void main(String[] args) {
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		EntityTransaction tran = man.getTransaction();
		tran.begin();
		
		Merchant m = new Merchant();
		m.setName("shashi");
		m.setPhone(7870877778l);
		m.setGst_number("asd1234");
		m.setEmail("ranjanshashi4862@gmail.com");
		m.setPassword("shashi1234");
		
		Product p1 = new Product();
		p1.setName("TV");
		p1.setBrand("Sony");
		p1.setCategory("Electrics");
		p1.setMerchant(m);

		Product p2 = new Product();
		p2.setName("fan");
		p2.setBrand("Usha");
		p2.setCategory("Electrical");
		p2.setMerchant(m);
		
		m.setProduct(Arrays.asList(p1, p2));
		
		man.persist(m);
		tran.commit();
		
	}
}
