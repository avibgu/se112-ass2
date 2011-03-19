import junit.framework.TestCase;


public class assigningWebTest extends TestCase {
	
	private AssigningWebBridge _bridge;
	
	protected void setUp() throws Exception {
		super.setUp();
		this._bridge = Driver.getBridge();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public boolean addMessage(int msgID,String title,String content){
		return _bridge.addMsg(msgID, title, content);
	}
	
	public boolean register(int ID, int numOfMsg){
		
		return _bridge.registerClient(ID, numOfMsg);

	}
	
	public boolean editMessage(int msgID,String title,String content){
		
		return _bridge.editMsg(msgID, title, content);
	}
	
	

}
