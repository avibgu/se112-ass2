package domain;

import java.util.Vector;



public class Company {
	static int companyId = 0;
	
	private int numOfMessages;
	private String username;
	private String pass;
	private int id;
	private Vector<Message> companyMsgs;
	
	public Company(String name, String user, String pass, int numOfAds) {
		this.setId(companyId++);
		this.numOfMessages = numOfAds;
		this.username = user;
		this.pass = pass;
	}

	public void setNumOfMessages(int numOfMessages) {
		this.numOfMessages = numOfMessages;
	}
	public int getNumOfMessages() {
		return numOfMessages;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPass() {
		return pass;
	}
	public void addCompanyMsgs(Message msg) {
		this.companyMsgs.add(msg);
	}
	public Vector<Message> getCompanyMsgs() {
		return companyMsgs;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
}
