package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subjects {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int s_id;
	
	@Column(name = "s_name")
	private String s_name;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="t_id")
	private Teachers teachers;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="class_id")
	private Classes classes;

	
	public Subjects(String s_name) {
		super();
		this.s_name = s_name;
	}

	
	public Subjects() {
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


	public Teachers getTeachers() {
		return teachers;
	}


	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}


	public Classes getClasses() {
		return classes;
	}


	public void setClasses(Classes classes) {
		this.classes = classes;
	}

}
