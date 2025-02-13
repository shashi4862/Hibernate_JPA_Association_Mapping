package oneToOneBi_Demo;
import java.util.Scanner;

import javax.persistence.*;
public class findUserById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the User ID:- ");
		int uid = sc.nextInt();
		sc.close();
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		User u = man.find(User.class, uid);
		
		if(u != null) {
			System.out.println(u);
		}
		else {
			System.err.println("No User found...");
		}
	}
}
