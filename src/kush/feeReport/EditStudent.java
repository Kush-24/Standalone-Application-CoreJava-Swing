package kush.feeReport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EditStudent extends JFrame {

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
	private JTextField txtStudentId;
	static EditStudent frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				 frame = new EditStudent();
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
	public EditStudent() {
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 612);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddStudent = new JLabel("Edit Student ");
		lblAddStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddStudent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblAddStudent.setBounds(142, 11, 144, 45);
		contentPane.add(lblAddStudent);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblName.setBounds(65, 171, 56, 22);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblEmail.setBounds(65, 210, 56, 22);
		contentPane.add(lblEmail);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblCourse.setBounds(65, 243, 56, 22);
		contentPane.add(lblCourse);
		
		JLabel lblFees = new JLabel("Fees:");
		lblFees.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblFees.setBounds(65, 276, 56, 22);
		contentPane.add(lblFees);
		
		JLabel lblPaid = new JLabel("Paid:");
		lblPaid.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblPaid.setBounds(65, 309, 56, 22);
		contentPane.add(lblPaid);
		
		JLabel lblDue = new JLabel("Due:");
		lblDue.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblDue.setBounds(65, 342, 56, 22);
		contentPane.add(lblDue);
		
		txtName = new JTextField();
		txtName.setBounds(151, 174, 135, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(151, 213, 135, 20);
		contentPane.add(txtEmail);
		
		txtCourse = new JTextField();
		txtCourse.setColumns(10);
		txtCourse.setBounds(151, 246, 135, 20);
		contentPane.add(txtCourse);
		
		txtFees = new JTextField();
		txtFees.setColumns(10);
		txtFees.setBounds(151, 279, 135, 20);
		contentPane.add(txtFees);
		
		txtPaid = new JTextField();
		txtPaid.setColumns(10);
		txtPaid.setBounds(151, 312, 135, 20);
		contentPane.add(txtPaid);
		
		txtDue = new JTextField();
		txtDue.setColumns(10);
		txtDue.setBounds(151, 345, 135, 20);
		contentPane.add(txtDue);
		
		lblAdress = new JLabel("Adress:");
		lblAdress.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblAdress.setBounds(65, 392, 56, 22);
		contentPane.add(lblAdress);
		
		JTextArea txtAdress = new JTextArea();
		txtAdress.setBounds(151, 376, 135, 51);
		contentPane.add(txtAdress);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblCity.setBounds(65, 435, 56, 22);
		contentPane.add(lblCity);
		
		JLabel lblState = new JLabel("State:");
		lblState.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblState.setBounds(65, 468, 56, 22);
		contentPane.add(lblState);
		
		JLabel lblContactno = new JLabel("ContactNo");
		lblContactno.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblContactno.setBounds(65, 501, 82, 22);
		contentPane.add(lblContactno);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(151, 438, 135, 20);
		contentPane.add(txtCity);
		
		txtState = new JTextField();
		txtState.setColumns(10);
		txtState.setBounds(151, 471, 135, 20);
		contentPane.add(txtState);
		
		txtContact = new JTextField();
		txtContact.setColumns(10);
		txtContact.setBounds(151, 502, 135, 20);
		contentPane.add(txtContact);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int id=Integer.parseInt(txtStudentId.getText());	
				try {
					Connection con=DBUtil.getConnection();
					String str="Update StdInfo set Name=?,Email=?,Course=?,Fees=?,Paid=?,Due=?,Address=?,City=?,State=?,ContactNo=? where StudentId=?";
					PreparedStatement ps=con.prepareStatement(str);
					ps.setString(1, txtName.getText());
					ps.setString(2, txtEmail.getText());
					ps.setString(3, txtCourse.getText());
					ps.setInt(4,Integer.parseInt(txtFees.getText()));
					ps.setInt(5,Integer.parseInt(txtPaid.getText()));
					ps.setInt(6,Integer.parseInt(txtDue.getText()));
					ps.setString(7, txtAdress.getText());
					ps.setString(8, txtCity.getText());
					ps.setString(9, txtState.getText());
					ps.setString(10, txtContact.getText());
					ps.setInt(11, id);
					if(ps.executeUpdate()==1) { 
						JOptionPane.showMessageDialog(EditStudent.this,"Student Information Updated..");
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
					} 
				catch (Exception e2) {System.out.println(e2.toString());}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(91, 541, 89, 23);
		contentPane.add(btnUpdate);
		
		JLabel lblStudentid = new JLabel("StudentId");
		lblStudentid.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblStudentid.setBounds(23, 77, 98, 22);
		contentPane.add(lblStudentid);
		
		txtStudentId = new JTextField();
		txtStudentId.setColumns(10);
		txtStudentId.setBounds(142, 79, 135, 20);
		contentPane.add(txtStudentId);
		
		JButton btnLoadResult = new JButton("Load Result");
		btnLoadResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(txtStudentId.getText());
				try {
				String str="Select * from StdInfo where StudentId=?";
				Connection con=DBUtil.getConnection();
				PreparedStatement ps=con.prepareStatement(str);
				ps.setInt(1,id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					txtName.setText(rs.getString(2));
					txtEmail.setText(rs.getString(3));
					txtCourse.setText(rs.getString(4));
					txtFees.setText(rs.getString(5));
					txtPaid.setText(rs.getString(6));
					txtDue.setText(rs.getString(7));
					txtAdress.setText(rs.getString(8));
					txtCity.setText(rs.getString(9));
					txtState.setText(rs.getString(10));
					txtContact.setText(rs.getString(11));
				}
				else {
					JOptionPane.showMessageDialog(EditStudent.this,"StudentId doesn't exist...");
					txtStudentId.setText("");
				}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnLoadResult.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoadResult.setBounds(317, 76, 121, 22);
		contentPane.add(btnLoadResult);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 129, 448, 22);
		contentPane.add(separator);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountantSection.main(new String[] {});
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(202, 541, 89, 23);
		contentPane.add(btnBack);
	}
}
