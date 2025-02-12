package oneToOneUni_Demo;

import javax.persistence.*;

public class savePersonAndPancard 
{
	public static void main(String[] args) {
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		EntityTransaction tran = man.getTransaction();
		
		tran.begin();
		
		person p = new person();
		p.setName("Shashi");
		p.setPhone(7870877778l);
		
		panCard card = new panCard();
		card.setNumber("asdf1234g");
		card.setPinCode(567890);
		
		p.setCard(card);
		
		man.persist(p);
		man.persist(card);
		tran.commit();	}

}
