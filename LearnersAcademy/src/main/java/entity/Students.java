package entity;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Students {

	@Id
	@GeneratedValue
	private int s_id;
	
	@Column(name="s_name")
	private String s_name;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="c_id")
	private Classes classes;

	public Students(String s_name) {
		super();
		this.s_name = s_name;
	}

	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	
	
}
