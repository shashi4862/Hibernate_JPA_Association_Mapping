package oneToOneUni_Demo;

import javax.persistence.*;

@Entity
public class panCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String number;
	private int PinCode;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getPinCode() {
		return PinCode;
	}
	public void setPinCode(int pinCode) {
		PinCode = pinCode;
	}
	@Override
	public String toString() {
		return "panCard [id=" + id + ", number=" + number + ", PinCode=" + PinCode + "]";
	}
	
}
