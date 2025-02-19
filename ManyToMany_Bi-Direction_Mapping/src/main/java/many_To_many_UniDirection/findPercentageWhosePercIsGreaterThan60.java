package many_To_many_UniDirection;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class findPercentageWhosePercIsGreaterThan60 {
	public static void main(String[] args) {
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select s from Student s where perc > 60");
		
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
