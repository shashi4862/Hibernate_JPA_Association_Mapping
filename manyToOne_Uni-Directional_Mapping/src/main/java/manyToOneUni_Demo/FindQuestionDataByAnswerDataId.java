package manyToOneUni_Demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindQuestionDataByAnswerDataId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Question:- ");
		int ques = sc.nextInt();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query qu = man.createQuery("Select a.question from AnswerData a where a.id = ?1");
		qu.setParameter(1, ques);
		
		QuestionData qd=(QuestionData) qu.getSingleResult();
		if(qd != null) {
			System.out.println(qd);
		}
		else {
			System.out.println("No Question Found...");
		}
		
	}
}
