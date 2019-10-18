package model;

import java.util.Date;

public class Person implements Comparable<Object>{
	private String name;
	private String lastName;
	private String id;
	private String email;
	private String gender;
	private String contry;
	private String photo;
	private Date birthday;

	public Person(String name, String lastName, String id, String email, String gender, String contry, String photo,
			Date birthday) {
		this.name = name;
		this.lastName = lastName;
		this.id = id;
		this.email = email;
		this.gender = gender;
		this.contry = contry;
		this.photo = photo;
		this.birthday = birthday;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContry() {
		return contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public int compareTo(Object o) {
		Person ot = (Person) o;
		int i = getId().compareToIgnoreCase(ot.getId());
		if(i<0) {
			i = -1;
		}if(i>0) {
			i = 1;
		}
		return i;
	}
}
