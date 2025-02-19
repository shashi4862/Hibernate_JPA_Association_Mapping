package many_To_many_UniDirection;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveBatchesAndStudent {
	public static void main(String[] args) {
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		EntityTransaction tran = man.getTransaction();
		
		tran.begin();
		
		Batch b1 = new Batch();
		b1.setBatch_code("java_B2");
		b1.setTrainer("Abhishek");
		b1.setSubject("Java");
		
		Batch b2 = new Batch();
		b2.setBatch_code("sql_A2");
		b2.setTrainer("Sarath");
		b2.setSubject("SQL");
		
		Student s1 = new Student();
		s1.setName("Shashi");
		s1.setPhone(7870877778l);
		s1.setPerc(79.7);
		
		Student s2 = new Student();
		s2.setName("Himanshu");
		s2.setPhone(7870877668l);
		s2.setPerc(80);
		
		Student s3 = new Student();
		s3.setName("Shivam");
		s3.setPhone(7870866778l);
		s3.setPerc(81.6);
		
		b1.setStudents(Arrays.asList(s1, s2, s3));
		b2.setStudents(Arrays.asList(s1, s2));
		
		s1.setBatches(Arrays.asList(b1, b2));
		s2.setBatches(Arrays.asList(b1, b2));
		s3.setBatches(Arrays.asList(b1));
		
		man.persist(b1);
		man.persist(b2);
		
		tran.commit();
	}
}
