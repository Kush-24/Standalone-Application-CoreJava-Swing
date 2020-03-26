package kush.feeReport;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddAccountant extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtContactNo;
	private JPasswordField txtPassword;
	static AddAccountant frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddAccountant();
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
	public AddAccountant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddAccountant = new JLabel("Add Accountant ");
		lblAddAccountant.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddAccountant.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAccountant.setBounds(133, 11, 160, 37);
		contentPane.add(lblAddAccountant);
		
		JLabel lblName = new JLabel("Name ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(79, 59, 58, 24);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(79, 94, 58, 24);
		contentPane.add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(79, 129, 58, 24);
		contentPane.add(lblEmail);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContactNo.setBounds(79, 164, 77, 24);
		contentPane.add(lblContactNo);
		
		txtName = new JTextField();
		txtName.setBounds(172, 63, 132, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(172, 133, 132, 20);
		contentPane.add(txtEmail);
		
		txtContactNo = new JTextField();
		txtContactNo.setColumns(10);
		txtContactNo.setBounds(172, 168, 132, 20);
		contentPane.add(txtContactNo);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(172, 98, 132, 20);
		contentPane.add(txtPassword);
		
		JButton btnAddAccountant = new JButton("Add");
		btnAddAccountant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=txtName.getText();
				char[] ch=txtPassword.getPassword();
				String pass=String.valueOf(ch);
				String email=txtEmail.getText();
				String contact=txtContactNo.getText();
				try {
				Connection con=DBUtil.getConnection();
				String str="insert into Accountant (Name,Password,Email,Contact) values (?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(str);
				ps.setString(1, name);
				ps.setString(2, pass);
				ps.setString(3, email);
				ps.setString(4, contact);
				if(ps.executeUpdate()==1){
				JOptionPane.showMessageDialog(AddAccountant.this,"Accountant Data Added..!");
				txtName.setText("");
				txtPassword.setText("");
				txtEmail.setText("");
				txtContactNo.setText("");
				txtName.setFocusable(true);
				}
				} catch (SQLException e1) {e1.printStackTrace();}
			}
		});
		btnAddAccountant.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddAccountant.setBounds(158, 213, 89, 37);
		contentPane.add(btnAddAccountant);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				AdminSection.main(new String[] {});
				frame.dispose();
			}
		});
		
		btnBack.setBounds(355, 221, 69, 24);
		contentPane.add(btnBack);
	}

}
