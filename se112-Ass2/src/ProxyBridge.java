
public class ProxyBridge implements AssigningWebBridge {
	
	AssigningWebBridge real;
	
	@Override
	public boolean addMsg(int msgID, String title, String content) {
		if ((msgID > 10) || (title.equals("")) || (content.equals("")) )
			return false;
		return true;
	}

	@Override
	public boolean editMsg(int msgID, String title, String content) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean registerClient(int ID, int numOfMsg) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean searchJob(String location, String role, String field) {
		// TODO Auto-generated method stub
		return false;
	}
}
