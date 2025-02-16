package manyToOneUni_Demo;
import javax.persistence.*;
public class SaveAnswerAndQuestion {
	public static void main(String[] args) {
		EntityManagerFactory fac = Persistence.createEntityManagerFactory("dev");
		EntityManager man = fac.createEntityManager();
		EntityTransaction tran = man.getTransaction();
		tran.begin();
		
		QuestionData qdata = new QuestionData();
		qdata.setQuestion("What is the important thing in your life?");
		qdata.setQuestionedBy("Guru");
		
		AnswerData adata1 = new AnswerData();
		adata1.setAnswer("Job and Family");
		adata1.setAnsweredBy("Shashi");
		adata1.setQuestion(qdata);
		
		AnswerData adata2 = new AnswerData();
		adata2.setAnswer("Food and Traviling");
		adata2.setAnsweredBy("Vamshi");
		adata2.setQuestion(qdata);
		
		man.persist(adata1);
		man.persist(adata2);
		
		tran.commit();
	}

}
