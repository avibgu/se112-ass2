/**
 * 
 */
package domain;

/**
 * @author gshir
 *
 */
public class Message {

	private String body;
	private int	id;
	private String location;
	private String role;
	private String field;
	private String status;
	private String companyId;
	
	public Message( String body,String role,String field, String location, String companyId) {
		super();
		this.setBody(body);
		this.setField(field);
		this.setLocation(location);
		this.setRole(role);
		this.setStatus("OPEN");
		this.setCompanyId(companyId);
	}
	
	public String toString(){
		return getRole() + "\n" + getBody(); //TODO
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBody() {
		return body;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}


	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getField() {
		return field;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyId() {
		return companyId;
	}

	
}
