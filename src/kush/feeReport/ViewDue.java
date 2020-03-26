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

public class ViewDue extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDue frame = new ViewDue();
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
	public ViewDue() {
		List<Student> list=new ArrayList<Student>();
		try {
			Connection con=DBUtil.getConnection();
			String str="select * from stdinfo where due>0";
			PreparedStatement ps=con.prepareStatement(str);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Student s=new Student();
				s.setName(rs.getString("Name"));
				s.setStudentId(rs.getInt("StudentId"));
				s.setCourse(rs.getString("Course"));
				s.setPaid(rs.getInt("Paid"));
				s.setDue(rs.getInt("Due"));
				s.setContactno(rs.getString("ContactNo"));
				list.add(s);
			}	
		} catch (Exception e2) {
			System.out.println(e2.toString());
		}
		int size=list.size();
		String data[][]=new String[size][6];
		int row=0;
		for(Student s:list) {
			data[row][0]=String.valueOf(s.getStudentId());
			data[row][1]=s.getName();
			data[row][2]=s.getCourse();
			data[row][3]=String.valueOf(s.getPaid());
			data[row][4]=String.valueOf(s.getDue());
			data[row][5]=s.getContactno();
			row++;
		}
		String colName[]= {"StudentId","Name","Course","Paid","Due","ContactNo"};
		JTable jt=new JTable(data,colName);
		JScrollPane sp=new JScrollPane(jt);
		add(sp);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
	}

}
