package manyToOneUni_Demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAnswerDataByAnsAttribute {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Answer:- ");
		String ans = sc.nextLine();
		
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		Query qu = man.createQuery("Select a from AnswerData a where a.answer = ?1");
		qu.setParameter(1, ans);
		
		List<AnswerData> l1 = qu.getResultList();
		if(l1.size() > 0) {
			for (AnswerData qd : l1) {
				System.out.println(qd);
			}
		}
		else {
			System.out.println("No Answer Details Found...");
		}
	}
}
