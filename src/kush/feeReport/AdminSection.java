package kush.feeReport;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class AdminSection extends JFrame {

	private JPanel contentPane;
	static AdminSection frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminSection();
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
	public AdminSection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddAccountant = new JButton("Add Accountant");
		btnAddAccountant.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				AddAccountant aa=new AddAccountant();
				aa.setVisible(true);
				frame.dispose();
			}
		});
		btnAddAccountant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddAccountant.setBounds(141, 101, 146, 42);
		contentPane.add(btnAddAccountant);
		
		JButton btnViewAccountant = new JButton("View Accountant");
		btnViewAccountant.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				ViewAccountant.main(new String[] {});
			}
		});
		btnViewAccountant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnViewAccountant.setBounds(141, 154, 146, 43);
		contentPane.add(btnViewAccountant);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice=JOptionPane.showConfirmDialog(AdminSection.this,"Are you sure,You want to logout..");
				if(choice==0) {
					frame.dispose();
					FeesReport.main(new String[] {});
				}
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogout.setBounds(141, 208, 146, 42);
		contentPane.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("Admin Section");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(131, 22, 167, 42);
		contentPane.add(lblNewLabel);
	}

}
