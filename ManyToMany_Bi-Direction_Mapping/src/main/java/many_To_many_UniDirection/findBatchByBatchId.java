package many_To_many_UniDirection;

import java.util.Scanner;

import javax.persistence.*;

public class findBatchByBatchId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Batch Id");
		int bid = sc.nextInt();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Batch b = man.find(Batch.class, bid);
		if(b != null) {
			System.out.println(b);
		}
		else {
			System.out.println("No Batch info found...");
		}
	}
}
