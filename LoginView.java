package com.uek.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {

	private JLabel jl1,jl2;
	private JTextField jtf;
	private JPasswordField jpf;
	private JButton jb1,jb2;
	
	public void init() {
		jl1 = new JLabel("用户名");
		jl2 = new JLabel("密    码");
		jtf = new JTextField(20);
		jpf = new JPasswordField(20);
		jb1 = new JButton("登录");
		jb2 = new JButton("注册");
		
		this.setTitle("登录界面");
		this.setLayout(new GridLayout(3,2));
		
		this.add(jl1);
		this.add(jtf);
		this.add(jl2);
		this.add(jpf);
		this.add(jb1);
		this.add(jb2);
		
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = jtf.getText();
				String pws = String.valueOf(jpf.getPassword());
				if("admin".equals(name) && "123456".equals(pws)) {
					LoginView.this.dispose();
					new IndexView().init();
				}else {
					JOptionPane.showMessageDialog(LoginView.this, "输入错误！");
				}
			}
		});
	}
	
}
