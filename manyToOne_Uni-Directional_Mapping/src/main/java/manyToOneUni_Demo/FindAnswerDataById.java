package manyToOneUni_Demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAnswerDataById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Answer Id:- ");
		int aid = sc.nextInt();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		AnswerData ad = man.find(AnswerData.class, aid);
		
		if(ad != null) {
			System.out.println(ad);
		}
		else {
			System.err.println("No Question found with this id...");
		}
	}
}
