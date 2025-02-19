package many_To_many_UniDirection;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class findStudentWhosePercIsInBetweenRange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("To Fetch the Student by Percentage...");
		System.out.print("Entere The first Range:- ");
		double perc1 = sc.nextInt();
		System.out.print("Entere The second Range:- ");
		double perc2 = sc.nextInt();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select s from Student s where perc between ?1 and ?2");
		q.setParameter(1, perc1);
		q.setParameter(2, perc2);
		
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
