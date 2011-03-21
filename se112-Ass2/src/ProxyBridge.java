
import java.util.Vector;

public class ProxyBridge implements AssigningWebBridge {
	
	AssigningWebBridge real;
	
	private Vector<Vector<String>> messages;
	
	public ProxyBridge() {
		real = null;
		messages = new Vector<Vector<String>>();
	}
	
	@Override
	public boolean addMsg(int msgID, String title, String content) {
		
		if ((msgID > 10) || (title.equals("")) || (content.equals("")) || (title.length() >= 50) )
			return false;
		
		Vector<String> msg = new Vector<String>(3);
		
		msg.add(String.valueOf(msgID));
		msg.add(title);
		msg.add(content);
		
		messages.add(msg);
		
		return true;
	}

	@Override
	public boolean registerClient(int ID, int numOfMsg) {
		
		if (real != null) return real.registerClient(ID, numOfMsg);
		
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Vector<String> searchJobs(String location, String role, String field) {
		
		if (real != null) return real.searchJobs(location, role, field);
		
		Vector<String> ans = new Vector<String>();
		
		for (Vector<String> msg: messages){
			
			if (	msg.get(1).contains(role) &&
					msg.get(2).contains(location) &&
					msg.get(2).contains(field)	){
				
				ans.add(msg.get(0));
			}
		}

		return ans;
	}

}
