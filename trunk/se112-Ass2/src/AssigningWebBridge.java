import java.util.Vector;


public interface AssigningWebBridge {

	public boolean addMsg(int msgID,String title,String content);
	
	public boolean registerClient(int ID, int numOfMsg);
	
	public Vector<String> searchJobs(String location, String role, String field);
	

}
