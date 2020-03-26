package kush.feeReport;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AccountantSection extends JFrame {

	private JPanel contentPane;
	static AccountantSection frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AccountantSection();
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
	public AccountantSection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddStudent.main(new String[] {});
			}
		});
		btnAddStudent.setBounds(56, 81, 112, 31);
		contentPane.add(btnAddStudent);
		
		JLabel lblAccountantSection = new JLabel("Accountant Section");
		lblAccountantSection.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAccountantSection.setBounds(121, 11, 166, 39);
		contentPane.add(lblAccountantSection);
		
		JButton btnEditStudent = new JButton("Edit Student");
		btnEditStudent.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							frame.dispose();
							EditStudent.main(new String[] {});
			}
		});
		btnEditStudent.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnEditStudent.setBounds(56, 144, 112, 31);
		contentPane.add(btnEditStudent);
		
		JButton btnViewStudent = new JButton("View Student");
		btnViewStudent.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				ViewStudent.main(new String[] {});
			}

		});
		btnViewStudent.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnViewStudent.setBounds(228, 81, 125, 31);
		contentPane.add(btnViewStudent);
		
		JButton btnDueFees = new JButton("Due Fees");
		btnDueFees.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				ViewDue.main(new String[] {});
			}
		});
		btnDueFees.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnDueFees.setBounds(228, 144, 125, 31);
		contentPane.add(btnDueFees);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				int choice=JOptionPane.showConfirmDialog(frame,"Are you sure,you want to logout..");
				if(choice==0) {
				frame.dispose();
				AccountantLogin.main(new String[] {});
				}
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.ITALIC, 14));
		btnLogout.setBounds(147, 205, 112, 31);
		contentPane.add(btnLogout);
	}

}
