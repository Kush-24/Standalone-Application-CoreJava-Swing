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

public class ViewStudent extends JFrame {

	static ViewStudent frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new ViewStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewStudent() {
		List<Student> list=new ArrayList<Student>();
		try{
			Connection con=DBUtil.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from StdInfo");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Student s=new Student();
				s.setStudentId(rs.getInt("StudentId"));
				s.setName(rs.getString("Name"));
				s.setEmail(rs.getString("Email"));
				s.setCourse(rs.getString("Course"));
				s.setFee(rs.getInt("fees"));
				s.setPaid(rs.getInt("Paid"));
				s.setDue(rs.getInt("Due"));
				s.setAddress(rs.getString("Address"));
				s.setCity(rs.getString("City"));
				s.setState(rs.getString("State"));
				s.setContactno(rs.getString("ContactNo"));
				list.add(s);
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		int size=list.size();
		String data[][]=new String[size][12];
		int row=0;
		for(Student s:list){
			data[row][0]=String.valueOf(s.getStudentId());
			data[row][1]=s.getName();
			data[row][2]=s.getEmail();
			data[row][3]=s.getCourse();
			data[row][4]=String.valueOf(s.getFee());
			data[row][5]=String.valueOf(s.getPaid());
			data[row][6]=String.valueOf(s.getDue());
			data[row][7]=s.getAddress();
			data[row][8]=s.getCity();
			data[row][9]=s.getState();
			data[row][11]=s.getContactno();
			
			row++;
		}
		String columnNames[]={"StudentId","Name","Email","Course","Fee","Paid","Due","Address","City","State","Contact No"};
		
		JTable jt=new JTable(data,columnNames);
		JScrollPane sp=new JScrollPane(jt);
		add(sp);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 400);
	}
}
