package kush.feeReport;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FeesReport extends JFrame {
	static FeesReport frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new FeesReport();
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
	public FeesReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fees Report");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setBounds(109, 26, 180, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnAccountantLogin = new JButton("Accountant Login");
		btnAccountantLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountantLogin.main(new String[]{});
				frame.dispose();
//				AccountantLogin al=new AccountantLogin();
//				al.setVisible(true);
//			    frame.dispose();  
			}
		});
		btnAccountantLogin.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 16));
		btnAccountantLogin.setBounds(109, 183, 166, 47);
		contentPane.add(btnAccountantLogin);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.main(new String[]{});
				frame.dispose();				
			}
		});
		btnAdminLogin.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 16));
		btnAdminLogin.setBounds(109, 102, 166, 47);
		contentPane.add(btnAdminLogin);
	}
}
