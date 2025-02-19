package many_To_many_UniDirection;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class findBatchByStudentIdAndName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Student Id:- ");
		int sid = sc.nextInt();
		System.out.print("Enter The Student Name:-");
		String sname = sc.next();
		sc.close();
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select s.batches from Student s where s.id = ?1 and s.name=?2");
		q.setParameter(1, sid);
		q.setParameter(2, sname);		
		
		List<Batch> list = q.getResultList();
		if(list.size() > 0) {
			for (Batch batch : list) {
				System.out.println(batch);
			}
		}
		else {
			System.err.println("NO Recourd Found...");
		}
	}
}
