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
	
	public void addCompany(String companyName, String username, String password, int numberOfMsg){
		Company newComp = new Company(companyName, username, password, numberOfMsg);
		getCompanies().add(newComp);
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
	public void publishMessage(String title, String body,String location,String role,String field){
		getMessages().add(new Message(title, body,role,field,location));
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

	
}
