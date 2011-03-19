
public interface AssigningWebBridge {

	public boolean addMsg(int msgID,String title,String content);
	
	public boolean registerClient(int ID, int numOfMsg);
	
	public boolean editMsg(int msgID,String title,String content);

	public boolean searchJob(String location, String role, String field);	
}
