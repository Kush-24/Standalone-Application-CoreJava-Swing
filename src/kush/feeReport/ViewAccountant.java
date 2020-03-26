package kush.feeReport;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewAccountant extends JFrame{

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAccountant frame=new ViewAccountant();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewAccountant() {
		List<Accountant> list=new ArrayList<Accountant>();
		try {
			Connection con=DBUtil.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Accountant");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Accountant ac=new Accountant();
				ac.setId(rs.getInt("Id"));
				ac.setName(rs.getString("Name"));
				ac.setPass(rs.getString("Password"));
				ac.setEmail(rs.getString("Email"));
				ac.setContact(rs.getString("Contact"));
				list.add(ac);
			}
			con.close();
		}
		catch (Exception e) {
			System.out.println(e.toString());}
		
		int size=list.size();
		String data[][]=new String[size][5];
		int row=0;
		for(Accountant a:list) {
			data[row][0]=String.valueOf(a.getId());
			data[row][1]=a.getName();
			data[row][2]=a.getPass();
			data[row][3]=a.getEmail();
			data[row][4]=a.getContact();
			row++;
		}
		String colName[]= {"Id","Name","Password","Email","ContactNo"};
				JTable jt=new JTable(data,colName);
				JScrollPane sp=new JScrollPane(jt);
				add(sp);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(100, 100, 800, 400);
	}

}
