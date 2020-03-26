package kush.feeReport;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class AdminLogin extends JFrame {
	static AdminLogin frame;
	private JPanel contentPane;
	private JTextField adminNameText;
	private JPasswordField adminPassText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AdminLogin");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(156, 38, 169, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(97, 124, 96, 27);
		contentPane.add(lblNewLabel_1);
		
		adminNameText = new JTextField();
		adminNameText.setBounds(199, 129, 148, 20);
		contentPane.add(adminNameText);
		adminNameText.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblPassword.setBounds(97, 162, 96, 27);
		contentPane.add(lblPassword);
		
		adminPassText = new JPasswordField();
		adminPassText.setBounds(199, 167, 148, 20);
		contentPane.add(adminPassText);
		
		JButton btnLogin = new JButton("LogIn");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=adminNameText.getText();
				char[] ch=adminPassText.getPassword();
				String pass=String.valueOf(ch);
				if(name.equals("admin") && pass.equals("12345")) {
					AdminSection.main(new String[]{});
					frame.dispose();
				}
				else if(name.equals("") && pass.equals(""))
				{
					JOptionPane.showMessageDialog(AdminLogin.this, "Name and Password can't be empty..");
					adminNameText.setText("");
					adminPassText.setText("");
					adminNameText.setFocusable(true);
				}else {
					JOptionPane.showMessageDialog(AdminLogin.this, "Sorry, username or password error!");
					adminNameText.setText("");
					adminPassText.setText("");
					adminNameText.setFocusable(true);
				}
				
			}
		});
		btnLogin.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		btnLogin.setBounds(180, 228, 96, 27);
		contentPane.add(btnLogin);
	}
}
