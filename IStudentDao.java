package com.uek.dao.inter;

import java.util.List;

import com.uek.entity.Student;

public interface IStudentDao {

	void add(Student student);
	void delete(int id);
	void update(Student student);
	Student load(int id);
	List<Student> list();
}
