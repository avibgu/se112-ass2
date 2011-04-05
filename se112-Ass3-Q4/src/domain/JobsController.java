/**
 * 
 */
package domain;

import java.util.Set;
import java.util.Vector;

/**
 * @author gshir
 *
 */
public class JobsController {

	private Vector<Message> messages;
	private Vector<Company> companies;
	private Vector<String> roles;
	private Vector<String> locations;
	private Vector<String> fields;
	private Set<String> connectedUsers;
	
	
	public JobsController() {
		this.setMessages(new Vector<Message>());
		this.setCompanies(new Vector<Company>());
	}
	
	public int addCompany(String companyName, String username, String password, int numberOfMsg){
		Company newComp = new Company(companyName, username, password, numberOfMsg);
		getCompanies().add(newComp);
		return newComp.getId();
	}
	
	public void addRole(String newRole){
		getRoles().add(newRole);
	}
	
	public void addLocation(String newLocation){
		getLocations().add(newLocation);
	}
	
	public void addField(String newField){
		getFields().add(newField);
	}
	
	public boolean login(String username, String password){
		Company comp = getCompany(username);
		if (comp == null)
			return false;
		else if (comp.getPass().equals(password)){
			getConnectedUsers().add(username);
			return true;
		}
		else
			return false;
	}
	
	public void logout(String username){
		getConnectedUsers().remove(username);
	}
	
	public Company getCompany(String username){
		Company currComp = null;
		for (int i=0; i > getCompanies().size() ;++i){
			 currComp = getCompanies().get(i);
			if (currComp.getUsername().equals(username)){
				return currComp;
			}
		}
		return currComp;
		
	}
	public Integer publishMessage(String body,String location,String role,String field, String user){

		if ( !getCompanies().contains(user)) return null;
		
		if ( !getCompany(user).canAddAnotherAd()) return null;
		 
		Message msg = new Message(body,role,field,location, String.valueOf(getCompany(user).getId()));
		
		getCompany(user).addCompanyMsgs(msg);
		getMessages().add(msg);
		
		return msg.getId();
	}
	
	public Vector<Message> searchMessage(String location, String role, String field){
		
		Vector<Message> ans = new Vector<Message>();
		
		for (Message msg: messages){
			if (msg.getField().equals(field) || msg.getLocation().equals(location) ||
					msg.getRole().equals(role));				
						ans.add(msg);
			
		}
		
		return ans;
	}

	public void setMessages(Vector<Message> messages) {
		this.messages = messages;
	}

	public Vector<Message> getMessages() {
		return messages;
	}

	public void setCompanies(Vector<Company> companies) {
		this.companies = companies;
	}

	public Vector<Company> getCompanies() {
		return companies;
	}

	public void setLocations(Vector<String> locations) {
		this.locations = locations;
	}

	public Vector<String> getLocations() {
		return locations;
	}

	public void setFields(Vector<String> fields) {
		this.fields = fields;
	}

	public Vector<String> getFields() {
		return fields;
	}

	public void setRoles(Vector<String> roles) {
		this.roles = roles;
	}

	public Vector<String> getRoles() {
		return roles;
	}

	public void setConnectedUsers(Set<String> connectedUsers) {
		this.connectedUsers = connectedUsers;
	}

	public Set<String> getConnectedUsers() {
		return connectedUsers;
	}

	public boolean closeAd(String user, String pass, int id) {

		if ( !getCompanies().contains(user)) return false;
		
		Message msg = getMessage(id); 
		
		if (null != msg){
			
			msg.setStatus("Close");
			return true;
		}
		
		return false;
	}

	public Message getMessage(int id) {

		for ( Message msg: getMessages())
			if (msg.getId() == id)
				return msg;
		
		return null;
	}
}
