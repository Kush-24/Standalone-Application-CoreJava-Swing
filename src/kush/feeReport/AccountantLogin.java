package kush.feeReport;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class AccountantLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JPasswordField txtPass;
	static  AccountantLogin frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					  frame = new AccountantLogin();
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
	public AccountantLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountantLogin = new JLabel("Accountant Login");
		lblAccountantLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblAccountantLogin.setBounds(112, 21, 187, 42);
		contentPane.add(lblAccountantLogin);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblName.setBounds(79, 104, 90, 24);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(79, 146, 90, 24);
		contentPane.add(lblPassword);
		
		txtName = new JTextField();
		txtName.setBounds(179, 108, 120, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(179, 150, 120, 20);
		contentPane.add(txtPass);
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				String name=txtName.getText();
				char ch[]=txtPass.getPassword();
				String pass=String.valueOf(ch);				
				try {
				Connection con=DBUtil.getConnection();
				String str="Select * from Accountant where Name=? and Password=?";
				PreparedStatement ps=con.prepareStatement(str);
				ps.setString(1,name);
				ps.setString(2,pass);
				ResultSet rs=ps.executeQuery();
				boolean status=rs.next();
				if(status==true) {
					frame.dispose();
					AccountantSection.main(new String[]{});	
				}
				else {
					JOptionPane.showMessageDialog(AccountantLogin.this, "Password and Username mismatch..", "Login Error", JOptionPane.ERROR_MESSAGE);
					txtName.setText("");
					txtPass.setText("");
					txtName.setFocusable(true);
				}
			
				}
				catch (SQLException e1) {
					e1.printStackTrace();
					}	
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnNewButton.setBounds(157, 207, 95, 30);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				FeesReport.main(new String[] {});
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnBack.setBounds(345, 225, 79, 25);
		contentPane.add(btnBack);
	}

}
