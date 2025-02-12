package oneToOneUni_Demo;

import javax.persistence.*;

@Entity
public class person 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long phone;
	

	@OneToOne
	private panCard card;
	
	public panCard getCard() {
		return card;
	}
	public void setCard(panCard card) {
		this.card = card;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "person [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	
	

}
