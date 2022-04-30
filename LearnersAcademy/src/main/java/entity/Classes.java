package entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "classes")
public class Classes {
	@Id
	@GeneratedValue
	private int c_id;
	
	@Column(name = "c_name")
	private String c_name;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="classes")
	private List<Students> students;
	
	@OneToMany(cascade= CascadeType.ALL, mappedBy="classes")
	private List<Subjects> subjects;
	
	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Classes(String c_name) {
		super();
		this.c_name = c_name;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}
	
	

}
