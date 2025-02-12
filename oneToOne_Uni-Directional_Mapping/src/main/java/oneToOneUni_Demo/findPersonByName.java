package oneToOneUni_Demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;
public class findPersonByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Id:- ");
		String pname = sc.next();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select p from person p where p.name=?1");
		q.setParameter(1, pname);
		List<person> l1 = q.getResultList();
		if(l1.size() > 0) {
			for (person p : l1) {
				System.out.println(p);
			}
		}
		else {
			System.err.println("NO Person Info Found...");
		}
	}
}
