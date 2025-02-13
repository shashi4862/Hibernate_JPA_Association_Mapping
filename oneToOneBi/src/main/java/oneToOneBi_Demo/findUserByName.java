package oneToOneBi_Demo;
import java.util.List;
import java.util.Scanner;

import javax.persistence.*;
public class findUserByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the User Name:- ");
		String nm = sc.next();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Query q = man.createQuery("select u from User u where u.name=?1");
		q.setParameter(1, nm);
		
		List<User> l1 = q.getResultList();
		if(l1.size() > 0) {
			for(User u:l1)
				System.out.println(u);
		}
		else {
			System.err.println("No User found...");
		}
	}
}
