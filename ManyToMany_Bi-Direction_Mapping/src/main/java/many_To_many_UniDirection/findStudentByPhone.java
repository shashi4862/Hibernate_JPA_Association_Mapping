package many_To_many_UniDirection;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class findStudentByPhone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Entere The Student Phone:- ");
		long sPhone = sc.nextLong();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select s from Student s where s.phone = ?1");
		q.setParameter(1, sPhone);
		
		Student s = (Student) q.getSingleResult();
		
		if(s!=null) {
			System.out.println(s);
		}
		else {
			System.err.println("Record not found...");
		}
	}
}
