package org.jsp.OneToManyUni_demo;
import java.util.List;

import javax.persistence.*;
@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String location;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Employee> lemps;
	
	public List<Employee> getLemps() {
		return lemps;
	}
	public void setLemps(List<Employee> lemps) {
		this.lemps = lemps;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	
	
}
