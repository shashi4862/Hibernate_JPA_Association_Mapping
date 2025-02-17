package manyToOneBi_Demo;

import java.util.Scanner;

import javax.persistence.*;

public class findMercantById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Merchant Id:- ");
		int mid = sc.nextInt();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Merchant m = man.find(Merchant.class, mid);
		
		if(m != null) {
			System.out.println(m);
		}
		else {
			System.out.println("No Merchant Found...!!");
		}
	}
}
