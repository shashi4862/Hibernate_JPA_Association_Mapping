package oneToOneBi_Demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class saveUserAndAadharCard {
	public static void main(String[] args) {
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		EntityTransaction tran = man.getTransaction();
		tran.begin();
		
		User u = new User();
		u.setName("Shashi");
		u.setPhone(7870876678l);
		
		AadharCard a=new AadharCard();
		a.setNumber(820202015078l);
		a.setAddress("Dhanbad");
		
		u.setCard(a);
		a.setUser(u);
		man.persist(u);
		
		tran.commit();
		
	}
}
