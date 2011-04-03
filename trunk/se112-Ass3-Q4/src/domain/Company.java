package domain;



public class Company {
	static int companyId = 0;
	
	private int numOfMessages;
	private String username;
	private String pass;
	private int id;
	
	public Company(String name, String user, String pass, int numOfAds) {
		this.id = companyId++;
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
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public int getCompanyId() {
		return companyId;
	}
}
