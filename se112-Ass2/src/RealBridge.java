import java.util.Vector;


public class RealBridge implements AssigningWebBridge {
	
	public static final boolean _implement=false;

	@Override
	public boolean addMsg(int msgID, String title, String content) {
		// TODO Auto-generated method stub
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
	public Vector<String> searchJobs(String location, String role, String field) {
		// TODO Auto-generated method stub
		return new Vector<String>();
	}


}
