package com.uek.db;

import java.util.ArrayList;
import java.util.List;

import com.uek.entity.Student;

public class StudentDB {

	public static List<Student> list = new ArrayList<Student>();
	
	static {
		list.add(new Student(1,"10001","张三",23));
		list.add(new Student(2,"10002","李四",26));
		list.add(new Student(3,"10003","王五",21));
		list.add(new Student(4,"10004","赵六",22));
	}
	
}
