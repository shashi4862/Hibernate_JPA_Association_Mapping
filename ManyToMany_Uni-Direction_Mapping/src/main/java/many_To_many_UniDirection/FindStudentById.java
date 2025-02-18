package many_To_many_UniDirection;
import java.util.Scanner;
import javax.persistence.*;
public class FindStudentById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student Id");
		int sid = sc.nextInt();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Student s = man.find(Student.class, sid);
		if(s != null) {
			System.out.println(s);
		}
		else {
			System.out.println("No Batch info found...");
		}
	}
}
