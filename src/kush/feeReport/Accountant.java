package kush.feeReport;

public class Accountant {
	private int id;
	private String name,pass,email,contact;
	public Accountant() {}
	public Accountant(int id, String name, String pass, String email, String contact) {
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.contact = contact;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	

}
