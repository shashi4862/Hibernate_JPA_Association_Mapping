package oneToOneUni_Demo;
import java.util.Scanner;
import javax.persistence.*;
public class findPersonById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Id:- ");
		int pid = sc.nextInt();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		person p = man.find(person.class, pid);
		if(p != null)
			System.out.println(p);
		else
			System.err.println("No Person Info FOund...");
	}
}
