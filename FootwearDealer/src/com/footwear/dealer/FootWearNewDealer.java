package com.footwear.dealer;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FootWearNewDealer extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FootWearNewDealer frame = new FootWearNewDealer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FootWearNewDealer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Dealer Details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNewLabel.setBounds(139, 69, 137, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dealer Name:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 93, 86, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 124, 73, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 151, 73, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 182, 73, 17);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(175, 93, 86, 17);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 125, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(175, 151, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(175, 180, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		btnNewButton = new JButton("Save");
		btnNewButton.setBounds(41, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener((ActionListener) this);
		
		btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBounds(201, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener((ActionListener)this);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("G:\\extra things\\Knowledge\\practice\\JavaP\\FootwearDealer\\resource\\3.jpg"));
		lblNewLabel_5.setBounds(286, 69, 138, 130);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("G:\\extra things\\Knowledge\\practice\\JavaP\\FootwearDealer\\resource\\3_1.jpg"));
		lblNewLabel_6.setBounds(41, 11, 377, 47);
		contentPane.add(lblNewLabel_6);
		
	}
	
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == btnNewButton) {
			try {
				Connection con;
				JLabel last = new JLabel("Data Inserted Successfully");
				Class.forName("oracle.jdbc.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@hp:1521:XE","PRASHANT","batman7");
				
				
				PreparedStatement ps =con.prepareStatement("insert into dealer_registration (DEALER_NAME,DEALER_ADDRESS,DEALER_PHONE,DEALER_EMAIL) VALUES(?,?,?,?)");
				
						
			    String d_name = textField.getText();
				
				String d_address = textField_1.getText();
				
				String d_phone = textField_2.getText();
				
				String d_email = textField_3.getText();
				
				ps.setString(1,d_name);
				
				ps.setString(2, d_address);
				
				ps.setString(3, d_phone);
				
				ps.setString(4, d_email);
				
				ps.executeUpdate();
				
				con.close();
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				
				contentPane.add(last);
				
			}catch(Exception e) {
				System.out.println("ERROR "+e);
			}
		}	
		if(ev.getSource() == btnNewButton_1) {
			System.exit(0);
		}
	}
	
	protected ImageIcon createImageIcon(String path, String description) {
		// TODO Auto-generated method stub
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
	        return new ImageIcon(imgURL, description);
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	 }
}
