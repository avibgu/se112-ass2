/**
 * 
 */
package domain;

import java.util.Vector;

/**
 * @author gshir
 *
 */
public class JobsController {

	private Vector<Message> messages;
	
	public JobsController() {
		this.setMessages(new Vector<Message>());
	}
	
	public void publishMessage(String title, String body){
		getMessages().add(new Message(title, body));
	}
	
	public Vector<Message> searchMessage(String location, String role, String field){
		
		Vector<Message> ans = new Vector<Message>();
		
		for (Message msg: messages){
			
			if (	msg.getTitle().contains(role) &&
					msg.getBody().contains(location) &&
					msg.getBody().contains(field)	){
				
				ans.add(msg);
			}
		}
		
		return ans;
	}

	public void setMessages(Vector<Message> messages) {
		this.messages = messages;
	}

	public Vector<Message> getMessages() {
		return messages;
	}
}
