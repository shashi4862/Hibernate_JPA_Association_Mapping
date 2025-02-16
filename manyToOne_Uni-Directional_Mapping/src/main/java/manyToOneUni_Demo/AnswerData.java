package manyToOneUni_Demo;

import javax.persistence.*;

@Entity
public class AnswerData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String answer;
	private String answeredBy;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private QuestionData question;
	
	
	
	
	public QuestionData getQuestion() {
		return question;
	}
	public void setQuestion(QuestionData question) {
		this.question = question;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnsweredBy() {
		return answeredBy;
	}
	public void setAnsweredBy(String answeredBy) {
		this.answeredBy = answeredBy;
	}
	@Override
	public String toString() {
		return "AnswerData [id=" + id + ", answer=" + answer + ", answeredBy=" + answeredBy + "]";
	}
	
}
