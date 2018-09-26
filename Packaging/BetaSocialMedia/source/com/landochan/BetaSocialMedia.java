package com.landochan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.border.*;
public class BetaSocialMedia implements ActionListener{
	JFrame frame;
	JFrame frame1;
	JLabel label;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	JLabel label6;
	JLabel label7;
	JLabel label8;
	JLabel label9;
	JLabel label10;
	JLabel label11;

	JTextField textField;
	JTextField textField1;
	JTextField textField2;
	JTextField textField3;
	JTextField textField4;
	JTextField textField5;
	JTextField textField6;
	JTextField textField7;
	JTextField textField8;
	JTextField textField9;
	JButton button;

	public static void main(String[] args) {
		BetaSocialMedia app = new BetaSocialMedia();
		app.gogogo();
	}
	public void gogogo(){
		try{	
		frame = new JFrame("My First Real App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textField = new JTextField(20);
		Border line = BorderFactory.createLineBorder(Color.black);
		Border empty = new EmptyBorder(0,0,0,0);
		textField.setBorder(new CompoundBorder(line, empty));
		textField1 = new JTextField(20);
		textField1.setBorder(new CompoundBorder(line, empty));
		textField2 = new JTextField(20);
		textField2.setBorder(new CompoundBorder(line, empty));
		textField3 = new JTextField(20);
		textField3.setBorder(new CompoundBorder(line, empty));
		textField4 = new JTextField(20);
		textField4.setBorder(new CompoundBorder(line, empty));
		textField5 = new JTextField(20);
		textField5.setBorder(new CompoundBorder(line, empty));
		textField6 = new JTextField(20);
		textField6.setBorder(new CompoundBorder(line, empty));
		textField7 = new JTextField(20);
		textField7.setBorder(new CompoundBorder(line, empty));
		textField8 = new JTextField(20);
		textField8.setBorder(new CompoundBorder(line, empty));
		textField9 = new JTextField(20);
		textField9.setBorder(new CompoundBorder(line, empty));
		int s = 30;
		textField.setFont(new Font("Arial", Font.BOLD, s));
		textField1.setFont(new Font("Arial", Font.BOLD, s));
		textField2.setFont(new Font("Arial", Font.BOLD, s));
		textField3.setFont(new Font("Arial", Font.BOLD, s));
		textField4.setFont(new Font("Arial", Font.BOLD, s));
		textField5.setFont(new Font("Arial", Font.BOLD, s));
		textField6.setFont(new Font("Arial", Font.BOLD, s));
		textField7.setFont(new Font("Arial", Font.BOLD, s));
		textField8.setFont(new Font("Arial", Font.BOLD, s));
		textField9.setFont(new Font("Arial", Font.BOLD, s));
		button = new JButton("Finish");
		button.setFont(new Font("Arial",Font.PLAIN, 17));
		button.addActionListener(this);
		label2= new JLabel("Fullname");
		label2.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		label3= new JLabel("Age");
		label3.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		label4= new JLabel("Nationality");
		label4.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		label5= new JLabel("Sex");
		label5.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		label6= new JLabel("Attracted to");
		label6.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		label7= new JLabel("Address");
		label7.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		label8= new JLabel("Hobby");
		label8.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		label9= new JLabel("Favorite food");
		label9.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		label10= new JLabel("Fav Movie");
		label10.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		label11= new JLabel("Fav PLace");
		label11.setFont(new Font("Arial", Font.BOLD, 24));
		label2.setFont(new Font("Arial", Font.BOLD, 24));
		label3.setFont(new Font("Arial", Font.BOLD, 24));
		label4.setFont(new Font("Arial", Font.BOLD, 24));
		label5.setFont(new Font("Arial", Font.BOLD, 24));
		label6.setFont(new Font("Arial", Font.BOLD, 24));
		label7.setFont(new Font("Arial", Font.BOLD, 24));
		label8.setFont(new Font("Arial", Font.BOLD, 24));
		label9.setFont(new Font("Arial", Font.BOLD, 24));
		label10.setFont(new Font("Arial", Font.BOLD, 24));


		label1 = new JLabel("Registration",JLabel.CENTER);
		label1.setFont(new Font("Arial", Font.PLAIN, 28));
		label1.setForeground(new Color(255,255,255));
		label = new JLabel("Social Media Beta Version @LandoChan", JLabel.CENTER);
		label.setFont(new Font("Arial",Font.BOLD,35));
		label.setForeground(Color.white);
		drawing panel1 = new drawing();
		drawing3 panel2 = new drawing3();
		drawing panel3 = new drawing();
		drawing panel4 = new drawing();
		drawing3 panel5 =  new drawing3();
		drawing panel6 = new drawing();
		drawing2 panel15 = new drawing2();
		drawing4 panel16 = new drawing4();
		panel1.add(panel5);
		frame.getContentPane().add(BorderLayout.SOUTH, panel2);
		panel2.setBorder(BorderFactory.createEmptyBorder(0,0,30,0));
		panel2.add(button);
		panel4.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
		frame.getContentPane().add(BorderLayout.NORTH,panel4);
		frame.getContentPane().setBackground(Color.white);
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
		panel4.add(panel15);
		panel4.add(panel16);
		panel15.add(label);
		panel16.add(label1);
		
		panel6.setLayout(new BoxLayout(panel6, BoxLayout.Y_AXIS));
		panel5.add(panel3);
		panel5.add(panel6);
		panel6.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
		panel5.setBorder(BorderFactory.createEmptyBorder(0,30,0,0));
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		frame.getContentPane().add(BorderLayout.WEST, panel1);
		panel3.add(label2);
		panel3.add(label3);
		panel3.add(label4);
		panel3.add(label5);
		panel3.add(label6);
		panel3.add(label7);
		panel3.add(label8);
		panel3.add(label9);
		panel3.add(label10);
		panel3.add(label11);
		panel6.add(textField);
		panel6.add(textField1);
		panel6.add(textField2);
		panel6.add(textField3);
		panel6.add(textField4);
		panel6.add(textField5);
		panel6.add(textField6);
		panel6.add(textField7);
		panel6.add(textField8);
		panel6.add(textField9);
		
		Dimension screensz = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screensz.width,screensz.height);
		frame.setVisible(true);
		} catch (Exception ex){
		}
	}
	class drawing extends JPanel {
		public void paintComponent(Graphics g){
			
		}
	}
	class drawing2 extends JPanel {
		public void paintComponent(Graphics g){
			g.setColor(Color.black);
			g.fillRect(0,0,this.getWidth(), this.getHeight());
		}
	}
	class drawing3 extends JPanel {
		public void paintComponent(Graphics g){
			g.setColor(Color.white);
			g.fillRect(0,0,this.getWidth(), this.getHeight());
		}
	}
	class drawing1 extends JPanel {
		public void paint(Graphics g){
			g.setFont(new Font("Arial", Font.PLAIN, 30));
			g.drawString("Thanks for your patience. Now your data has been succesfully confirmed to our center.", this.getWidth()/2-800, this.getHeight()/2);
		}
	}
	class drawing4 extends JPanel {
		public void paintComponent(Graphics g){
			g.setColor(new Color(50,50,200));
			g.fillRect(0,0,this.getWidth(), this.getHeight());
		}
	}
	JLabel labelx;
	public void actionPerformed(ActionEvent event){
		frame.setVisible(false);
		frame1 = new JFrame();
		label = new JLabel("Social Media Beta Version @LandoChan", JLabel.CENTER);
		label.setFont(new Font("Arial",Font.BOLD,35));
		label.setOpaque(true);
		label.setBackground(Color.black);
		label.setForeground(Color.white);
		labelx = new JLabel("Thank you for your patience. Your data has been succesfully received in our global server", JLabel.CENTER);
		labelx.setFont(new Font ("Arial", Font.PLAIN, 25));
		
		frame1.getContentPane().add(BorderLayout.CENTER,labelx);
		
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame1.getContentPane().add(BorderLayout.NORTH, label);
		Dimension screensz = Toolkit.getDefaultToolkit().getScreenSize();
		frame1.setSize(screensz.width,screensz.height);
		frame1.setVisible(true);
	}
}
			
