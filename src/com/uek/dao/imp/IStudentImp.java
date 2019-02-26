package com.uek.dao.impe;

import java.util.List;

import com.uek.dao.inter.IStudentDao;
import com.uek.db.StudentDB;
import com.uek.entity.Student;

public class IStudentImp implements IStudentDao {

	@Override
	public void add(Student student) {
		// TODO Auto-generated method stub
		List<Student> list = list();
		list.add(student);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		List<Student> students = list();
		for(int i=0;i<students.size();i++) {
			if(students.get(i).getId() == id) {
				students.remove(students.get(i));
			}
		}
	}

	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		List<Student> students = list();
		for(int i=0;i<students.size();i++) {
			Student s = students.get(i);
			if(s.getId() == student.getId()) {
				students.set(i, student);
			}
		}
	}

	@Override
	public Student load(int id) {
		// TODO Auto-generated method stub
		Student student = null;
		List<Student> students = list();
		for(int i=0;i<students.size();i++) {
			if(students.get(i).getId() == id) {
				student =  students.get(i);
			}
		}
		return student;
	}

	@Override
	public List<Student> list() {
		// TODO Auto-generated method stub
		return StudentDB.list;
	}

	
}
