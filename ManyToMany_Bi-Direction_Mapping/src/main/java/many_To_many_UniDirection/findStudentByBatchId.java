package many_To_many_UniDirection;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class findStudentByBatchId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entere The Batch id:- ");
		int bid = sc.nextInt();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select b.Students from Batch b where b.id = ?1");
		q.setParameter(1, bid);
		
		List<Student> list = q.getResultList();
		if(list.size() > 0) {
			for (Student student : list) {
				System.out.println(student);
			}
		}
		else {
			System.err.println("NO Recourd Found...");
		}
	}
}
