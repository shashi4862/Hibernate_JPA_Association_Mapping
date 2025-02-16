package manyToOneUni_Demo;

import javax.persistence.*;

@Entity
public class QuestionData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String question;
	private String QuestionedBy;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestionedBy() {
		return QuestionedBy;
	}
	public void setQuestionedBy(String questionedBy) {
		QuestionedBy = questionedBy;
	}
	@Override
	public String toString() {
		return "QuestionData [id=" + id + ", question=" + question + ", QuestionedBy=" + QuestionedBy + "]";
	}
	
	
}
