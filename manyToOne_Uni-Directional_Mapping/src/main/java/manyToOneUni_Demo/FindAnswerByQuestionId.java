package manyToOneUni_Demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class FindAnswerByQuestionId {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Question:- ");
		int qid = sc.nextInt();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query qu = man.createQuery("Select a from AnswerData a where a.question.id = ?1");
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
