package com.uek.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.uek.dao.impe.IStudentImp;
import com.uek.entity.Student;

public class StudentDaoTest {

	IStudentImp isi;
	
	@Before
	public void init() {
		isi = new IStudentImp();
	}
	
	@Test
	public void deleteTest() {
		isi.delete(2);
		List<Student> list = isi.list();
		System.out.println(list);
	}
	
	@Test
	public void addTest() {
		isi.add(new Student(5,"10005","田七",23));
		List<Student> list = isi.list();
		System.out.println(list);
	}
	
	@After
	public void pro() {
		isi = null;
	}
}
