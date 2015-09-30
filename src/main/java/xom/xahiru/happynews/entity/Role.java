package xom.xahiru.happynews.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

@Entity
public class Role {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=3, message="invalid name, should be more than 3 chars")
	private String name;
	
	@ManyToMany(mappedBy="roles")
	private List<User> users;
	
	

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
