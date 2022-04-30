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
@Table(name = "teachers")
public class Teachers {
	@Id
	@GeneratedValue
	private int t_id;
	
	@Column(name = "t_name")
	private String t_name;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="teachers")
	private List<Subjects> subjects;

	public Teachers(String t_name) {
		super();
		this.t_name = t_name;
	}

	public Teachers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getT_name() {
		return t_name;
	}

	public void setT_name(String t_name) {
		this.t_name = t_name;
	}

	public List<Subjects> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subjects> subjects) {
		this.subjects = subjects;
	}
	
	
}
