package domain;

import java.util.Date;
import java.util.Vector;

public class Company {
	static int companyId = 0;
	static long oneYear = new Date("4 Jan 2011").getTime() - new Date("4 Jan 2010").getTime();
	
	private int numOfMessages;
	private String username;
	private String pass;
	private int id;
	private Vector<Message> companyMsgs;
	private long validFrom;
	
	public Company(String name, String user, String pass, int numOfAds) {
		this.setId(companyId++);
		this.numOfMessages = numOfAds;
		this.username = user;
		this.pass = pass;
		this.validFrom = new Date().getTime();
		companyMsgs = new Vector<Message>();
	}
	
	public  boolean canAddAnotherAd(){

		if (	validFrom - new Date().getTime() > oneYear ||
				getNumOfMessages() == 0)
			return false;
		
		if (getNumOfMessages() == -1)	// unlimited messages
			return true;
		
		return true;
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
		setNumOfMessages(getNumOfMessages()-1);
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
	public long getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(long valid) {
		this.validFrom = valid;
	}
}
