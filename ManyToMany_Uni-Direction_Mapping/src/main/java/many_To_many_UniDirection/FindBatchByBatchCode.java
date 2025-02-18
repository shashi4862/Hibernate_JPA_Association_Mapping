package many_To_many_UniDirection;
import java.util.Scanner;
import javax.persistence.*;
public class FindBatchByBatchCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entere The Batch Code:- ");
		String Bcode = sc.next();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select b from Batch b where batch_code = ?1");
		q.setParameter(1, Bcode);
		
		Batch b = (Batch) q.getSingleResult();
		if(b != null) {
			System.out.println(b);
		}
		else {
			System.err.println("No Record Found...");
		}
	}
}
