package com.uek.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.uek.dao.impe.IStudentImp;
import com.uek.dao.inter.IStudentDao;
import com.uek.entity.Student;
import com.uek.utils.ViewUtil;

public class AddStudent extends JFrame {

	private JLabel jl1,jl2,jl3,jl4;
	private JTextField jtf1,jtf2,jtf3,jtf4;
	private JButton jb1,jb2;
	
	private IStudentDao studentDao = new IStudentImp();
	
	public void init() {
		jl1 = new JLabel("id");
		jl2 = new JLabel("学号");
		jl3 = new JLabel("姓名");
		jl4 = new JLabel("年龄");
		jtf1 = new JTextField(20);
		jtf2 = new JTextField(20);
		jtf3 = new JTextField(20);
		jtf4 = new JTextField(20);
		jb1 = new JButton("重置");
		jb2 = new JButton("提交");
		
		this.add(jl1);
		this.add(jtf1);
		this.add(jl2);
		this.add(jtf2);
		this.add(jl3);
		this.add(jtf3);
		this.add(jl4);
		this.add(jtf4);
		this.add(jb1);
		this.add(jb2);
		
		this.setLayout(new GridLayout(5,2));
		this.setTitle("添加学生");
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String id = jtf1.getText();
				String stuId = jtf2.getText();
				String name = jtf3.getText();
				String age = jtf4.getText();
				
				Student student = new Student(Integer.parseInt(id),stuId,name,Integer.parseInt(age));
				studentDao.add(student);
				
				AddStudent.this.dispose();
				
				IndexView indexView = (IndexView)ViewUtil.indexView;
				
				JTable jt = new IndexView().getTable();
				JScrollPane jsp = new JScrollPane(jt);
				
				indexView.getJp().removeAll();
				indexView.getJp().add(jsp);
				indexView.getJp().updateUI();
				
			}
		});
		
		
	}
	
	public static void main(String[] args) {
		new AddStudent().init();
	}
}
