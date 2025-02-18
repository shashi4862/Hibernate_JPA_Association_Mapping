package many_To_many_UniDirection;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindBatchBySubject {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entere The Subject:- ");
		String sub = sc.next();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select b from Batch b where subject = ?1");
		q.setParameter(1, sub);
		
		List<Batch> list =  q.getResultList();
		if(list.size() > 0) {
			for (Batch batch : list) {
				System.out.println(batch);
			}
		}
		else {
			System.err.println("No Recourd Found...");
		}
		
		
	}
}
