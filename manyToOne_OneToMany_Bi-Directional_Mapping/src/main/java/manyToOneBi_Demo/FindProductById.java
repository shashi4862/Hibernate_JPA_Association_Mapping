package manyToOneBi_Demo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindProductById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Product Id:- ");
		int mid = sc.nextInt();
		sc.close();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		
		Product p = man.find(Product.class, mid);
		
		if(p != null) {
			System.out.println(p);
		}
		else {
			System.out.println("No Product Found...!!");
		}
	}
}
