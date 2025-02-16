package manyToOneUni_Demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAnswerByQuestionByAttribute {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Question:- ");
		String qid = sc.next();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query qu = man.createQuery("Select a from AnswerData a where a.question.QuestionedBy = ?1");
		qu.setParameter(1, qid);
		
		List<AnswerData> l1 = qu.getResultList();
		if(l1.size() > 0) {
			for (AnswerData qd : l1) {
				System.out.println(qd);
			}
		}
		else {
			System.out.println("No Question Details Found...");
		}
	}
}
