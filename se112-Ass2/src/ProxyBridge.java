import java.util.Vector;

public class ProxyBridge implements AssigningWebBridge {
	
	AssigningWebBridge real;
	
	public ProxyBridge() {
		real = null;
	}
	
	@Override
	public boolean addMsg(int msgID, String title, String content) {
		
		if ((msgID > 10) || (title.equals("")) || (content.equals("")) || (title.length() >= 50) )
			return false;
		
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
		
		// TODO Auto-generated method stub
		return new Vector<String>();
	}

}
