package com.uek.entity;

public class Student {

	private int id;
	private String stuId;
	private String name;
	private int age;
	public Student(int id, String stuId, String name, int age) {
		super();
		this.id = id;
		this.stuId = stuId;
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
	}
	public Student(String stuId, String name, int age) {
		super();
		this.stuId = stuId;
		this.name = name;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", stuId=" + stuId + ", name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((stuId == null) ? 0 : stuId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (stuId == null) {
			if (other.stuId != null)
				return false;
		} else if (!stuId.equals(other.stuId))
			return false;
		return true;
	}
	
	
	
}
