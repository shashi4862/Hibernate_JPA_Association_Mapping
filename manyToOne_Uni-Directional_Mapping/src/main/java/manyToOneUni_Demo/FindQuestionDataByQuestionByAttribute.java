package manyToOneUni_Demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindQuestionDataByQuestionByAttribute {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Question:- ");
		String ques = sc.next();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query qu = man.createQuery("Select q from QuestionData q where q.QuestionedBy = ?1");
		qu.setParameter(1, ques);
		
		List<QuestionData> l1 = qu.getResultList();
		if(l1.size() > 0) {
			for (QuestionData qd : l1) {
				System.out.println(qd);
			}
		}
		else {
			System.out.println("No Question Details Found...");
		}
	}
}
