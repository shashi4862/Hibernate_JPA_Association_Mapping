package oneToOneUni_Demo;
import java.util.Scanner;
import javax.persistence.*;
public class findPanCardById 
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Id:- ");
		int pc = sc.nextInt();
		sc.close();
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		panCard p = man.find(panCard.class, pc);
		
		if(p!=null) {
			System.out.println(p);
		}
		else {
			System.err.println("PanCard not found...");
		}
	}
}
