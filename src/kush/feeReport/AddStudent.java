package kush.feeReport;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class AddStudent extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtCourse;
	private JTextField txtFees;
	private JTextField txtPaid;
	private JTextField txtDue;
	private JLabel lblAdress;
	private JTextField txtCity;
	private JTextField txtState;
	private JTextField txtContact;
	static AddStudent frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new AddStudent();
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
	public AddStudent() {
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 542);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddStudent = new JLabel("Add Student ");
		lblAddStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddStudent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblAddStudent.setBounds(142, 11, 144, 45);
		contentPane.add(lblAddStudent);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblName.setBounds(65, 64, 56, 22);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblEmail.setBounds(65, 97, 56, 22);
		contentPane.add(lblEmail);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblCourse.setBounds(65, 131, 56, 22);
		contentPane.add(lblCourse);
		
		JLabel lblFees = new JLabel("Fees:");
		lblFees.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblFees.setBounds(65, 164, 56, 22);
		contentPane.add(lblFees);
		
		JLabel lblPaid = new JLabel("Paid:");
		lblPaid.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblPaid.setBounds(65, 197, 56, 22);
		contentPane.add(lblPaid);
		
		JLabel lblDue = new JLabel("Due:");
		lblDue.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblDue.setBounds(65, 230, 56, 22);
		contentPane.add(lblDue);
		
		txtName = new JTextField();
		txtName.setBounds(151, 67, 135, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(151, 100, 135, 20);
		contentPane.add(txtEmail);
		
		txtCourse = new JTextField();
		txtCourse.setColumns(10);
		txtCourse.setBounds(151, 134, 135, 20);
		contentPane.add(txtCourse);
		
		txtFees = new JTextField();
		txtFees.setColumns(10);
		txtFees.setBounds(151, 167, 135, 20);
		contentPane.add(txtFees);
		
		txtPaid = new JTextField();
		txtPaid.setColumns(10);
		txtPaid.setBounds(151, 200, 135, 20);
		contentPane.add(txtPaid);
		
		txtDue = new JTextField();
		txtDue.setColumns(10);
		txtDue.setBounds(151, 233, 135, 20);
		contentPane.add(txtDue);
		
		lblAdress = new JLabel("Adress:");
		lblAdress.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblAdress.setBounds(65, 275, 56, 22);
		contentPane.add(lblAdress);
		
		JTextArea txtAdress = new JTextArea();
		txtAdress.setBounds(151, 276, 135, 51);
		contentPane.add(txtAdress);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblCity.setBounds(65, 356, 56, 22);
		contentPane.add(lblCity);
		
		JLabel lblState = new JLabel("State:");
		lblState.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblState.setBounds(65, 389, 56, 22);
		contentPane.add(lblState);
		
		JLabel lblContactno = new JLabel("ContactNo");
		lblContactno.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblContactno.setBounds(65, 422, 82, 22);
		contentPane.add(lblContactno);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(151, 359, 135, 20);
		contentPane.add(txtCity);
		
		txtState = new JTextField();
		txtState.setColumns(10);
		txtState.setBounds(151, 392, 135, 20);
		contentPane.add(txtState);
		
		txtContact = new JTextField();
		txtContact.setColumns(10);
		txtContact.setBounds(151, 425, 135, 20);
		contentPane.add(txtContact);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
				Connection con=DBUtil.getConnection();
				String str="Insert into StdInfo (Name,Email,Course,Fees,Paid,Due,Address,City,State,ContactNo) values (?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(str);
				ps.setString(1,txtName.getText());
				ps.setString(2,txtEmail.getText());
				ps.setString(3,txtCourse.getText());
				ps.setString(4, txtFees.getText());
				ps.setString(5,txtPaid.getText());
				ps.setString(6,txtDue.getText());
				ps.setString(7,txtAdress.getText());
				ps.setString(8,txtCity.getText());
				ps.setString(9,txtState.getText());
				ps.setString(10,txtContact.getText());
				if(ps.executeUpdate()==1) {
					JOptionPane.showMessageDialog(AddStudent.this, "Student Added Succesfully..");
					txtName.setText("");
					txtEmail.setText("");
					txtCourse.setText("");
					txtFees.setText("");
					txtPaid.setText("");
					txtAdress.setText("");
					txtDue.setText("");
					txtCity.setText("");
					txtState.setText("");
					txtContact.setText("");
					txtName.setFocusable(true);
					con.close();
					ps.close();
				}
					
					
				} catch (Exception e2){
					System.out.println(e.toString());
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(143, 461, 96, 31);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AccountantSection.main(new String[] {});
					frame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(349, 469, 89, 23);
		contentPane.add(btnBack);
	}
}
