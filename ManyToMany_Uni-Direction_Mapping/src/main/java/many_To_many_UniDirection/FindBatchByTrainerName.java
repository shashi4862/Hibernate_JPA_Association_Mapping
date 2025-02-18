package many_To_many_UniDirection;
import java.util.List;
import java.util.Scanner;
import javax.persistence.*;
public class FindBatchByTrainerName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entere The Trainer Name:- ");
		String Tname = sc.next();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select b from Batch b where trainer = ?1");
		q.setParameter(1, Tname);
		
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
