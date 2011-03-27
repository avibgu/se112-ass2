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
	
	public Message(String title, String body) {
		super();
		this.setTitle(title);
		this.setBody(body);
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
}
