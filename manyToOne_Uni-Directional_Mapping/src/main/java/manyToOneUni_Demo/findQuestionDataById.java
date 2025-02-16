package manyToOneUni_Demo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class findQuestionDataById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Question Id:- ");
		int qid = sc.nextInt();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		QuestionData qd = man.find(QuestionData.class, qid);
		
		if(qd != null) {
			System.out.println(qd);
		}
		else {
			System.err.println("No Question found with this id...");
		}
	}
}
