package many_To_many_UniDirection;

import java.util.List;

import javax.persistence.*;

public class findStudentWhosePercIsGreaterThan85 {
	public static void main(String[] args) {
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query q = man.createQuery("select s from Student s where perc > 85");
		
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
