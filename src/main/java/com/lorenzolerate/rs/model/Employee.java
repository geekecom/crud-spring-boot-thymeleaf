package com.lorenzolerate.rs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String lastName;
	private byte[] photo;
	@ManyToMany
	@JoinTable(name = "employee_technology", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "technology_id"))
	Set<Technology> technologies;
	@OneToOne
	Office office;

	public Employee() {
		super();
	}

	public Employee(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String photoToString() {
		if (photo != null)
			return new String(photo);
		else
			return "";
	}

	public Set<Technology> getTechnologies() {
		if (technologies == null)
			technologies = new HashSet<Technology>();
		return technologies;
	}

	public void setTechnologies(Set<Technology> technologies) {
		this.technologies = technologies;
	}

	public String technologiesToString() {
		String result = "";
		for (Technology technology : this.technologies) {
			result += technology.getName() + ", ";
		}
		if (result.length() >= 2)
			result = result.substring(0, result.length() - 2);

		return result;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

}
