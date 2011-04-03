/**
 * 
 */
package domain;

/**
 * @author gshir
 *
 */
public class Message {

	private String title;
	private String body;
	private int	id;
	private String location;
	private String role;
	private String field;
	
	public Message(String title, String body,String role,String field, String location) {
		super();
		this.setTitle(title);
		this.setBody(body);
		this.setField(field);
		this.setLocation(location);
		this.setRole(role);
	}
	
	public String toString(){
		return getTitle() + "\n" + getBody();
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
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

	
}
