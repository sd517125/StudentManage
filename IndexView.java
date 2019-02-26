package com.uek.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.uek.dao.impe.IStudentImp;
import com.uek.entity.Student;
import com.uek.utils.ViewUtil;

public class IndexView extends JFrame {

	private JMenuBar jmb;
	private JMenu jm1,jm2;
	private JMenuItem jmi1_1,jmi1_2,jmi1_3,jmi1_4,jmi1_5,jmi2_1;
	private JPanel jp;
	private JTable jt;
	
	public JPanel getJp() {
		return jp;
	}

	public void setJp(JPanel jp) {
		this.jp = jp;
	}

	public void init() {
		jmb = new JMenuBar();
		jm1 = new JMenu("学生管理");
		jm2 = new JMenu("个人中心");
		jmi1_1 = new JMenuItem("添加");
		jmi1_2 = new JMenuItem("修改");
		jmi1_3 = new JMenuItem("删除");
		jmi1_4 = new JMenuItem("查单个");
		jmi1_5 = new JMenuItem("查所有");
		jmi2_1 = new JMenuItem("退出");
		jp = new JPanel();
		
		jm1.add(jmi1_1);
		jm1.add(jmi1_2);
		jm1.add(jmi1_3);
		jm1.add(jmi1_4);
		jm1.add(jmi1_5);
		
		jm2.add(jmi2_1);
		
		jmb.add(jm1);
		jmb.add(jm2);
		
		ViewUtil.indexView = this;
		
		this.setJMenuBar(jmb);
		this.add(jp);
		this.setTitle("欢迎登录");
		this.setVisible(true);
		this.setResizable(false);
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		jmi2_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				IndexView.this.dispose();
				new LoginView().init();
			}
		});
		
		jmi1_5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jt = getTable();
				
				JScrollPane jsp = new JScrollPane(jt);
				IndexView.this.jp.add(jsp);
				IndexView.this.jp.updateUI();;
			}
		});
		
		jmi1_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String id = JOptionPane.showInputDialog("请输入要查询的学生id");
				
				Student s = new IStudentImp().load(Integer.parseInt(id));
				
				// TODO Auto-generated method stub
				Vector<String> columnNames = new Vector<String>();
				columnNames.add("序号");
				columnNames.add("学号");
				columnNames.add("姓名");
				columnNames.add("年龄");
				
				Vector<Vector<String>> rows = new Vector<Vector<String>>();
				Vector<String> row = new Vector<String>();
				row.add(String.valueOf(s.getId()));
				row.add(s.getStuId());
				row.add(s.getName());
				row.add(String.valueOf(s.getAge()));
				rows.add(row);
				
				jt = new JTable(rows, columnNames);
				JScrollPane jsp = new JScrollPane(jt);
				
				IndexView.this.jp.removeAll();
				IndexView.this.jp.add(jsp);
				IndexView.this.jp.updateUI();
			}
		});
		
		jmi1_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = jt.getSelectedRow();
				if(index == -1) {
					JOptionPane.showMessageDialog(IndexView.this,"请选择要删除的行");
				}else {
					int id = Integer.parseInt(jt.getValueAt(index, 0)+"");
					new IStudentImp().delete(id);
					
					jt = getTable();
					JScrollPane jsp = new JScrollPane(jt);
					
					IndexView.this.jp.removeAll();
					IndexView.this.jp.add(jsp);
					IndexView.this.jp.updateUI();
				}
			}
		});
		
		jmi1_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new UpdateStudent().init();
			}
		});
		
		jmi1_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AddStudent().init();
			}
		});
		
		
	}
	
	public JTable getTable() {
		JTable jt = null;
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("序号");
		columnNames.add("学号");
		columnNames.add("姓名");
		columnNames.add("年龄");
		
		List<Student> students = new IStudentImp().list();
		
		Vector<Vector<String>> rows = new Vector<Vector<String>>();
		for(Student s : students) {
			Vector<String> row = new Vector<String>();
			row.add(String.valueOf(s.getId()));
			row.add(s.getStuId());
			row.add(s.getName());
			row.add(String.valueOf(s.getAge()));
			
			rows.add(row);
		}
		
		jt = new JTable(rows, columnNames);
		return jt;
	}
}
