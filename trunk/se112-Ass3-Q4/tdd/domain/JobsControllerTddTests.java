package domain;

import java.util.Vector;

import junit.framework.TestCase;

public class JobsControllerTddTests extends TestCase {

	JobsController _controller;
	
	protected void setUp() throws Exception {
		super.setUp();
		_controller = new JobsController();
		getcontroller().addCompany("comp1", "c1", "c1234", 10);
		getcontroller().addCompany("comp2", "c2", "c1234", 100);
		getcontroller().addField("field1");
		getcontroller().addField("field2");
		getcontroller().addField("field3");
		getcontroller().addLocation("loc1");
		getcontroller().addLocation("loc2");
		getcontroller().addLocation("loc3");
		getcontroller().addRole("role1");
		getcontroller().addRole("role2");
		getcontroller().addRole("role3");
	}
	
	public void testSearchMessageWithNullMessage(){
		
		publish();
		
		Vector<Message> ans;
		ans = getcontroller().searchMessage(null, "role1", "field1");
		assertNotNull(ans);
		assertEquals(1, ans.size());
		ans = getcontroller().searchMessage("loc1", null, "field1");
		assertNotNull(ans);
		assertEquals(1, ans.size());
		ans = getcontroller().searchMessage("loc1", "role1", null);
		assertNotNull(ans);
		assertEquals(1, ans.size());
	}

	public void testSearchMessageWithEmptyString(){

		publish();
		
		Vector<Message> ans;
		ans = getcontroller().searchMessage("", "role1", "field1");
		assertNull(ans);
		ans = getcontroller().searchMessage("loc1", "", "field1");
		assertNull(ans);
		ans = getcontroller().searchMessage("loc1", "role1", "");
		assertNull(ans);
	}
	
	public void testSearchUnpublishedMessage(){
		
		publish();
		
		Vector<Message> ans;
		ans = getcontroller().searchMessage("loc2", "role1", "field1");
		assertNotNull(ans);
		assertEquals(0, ans.size());
		ans = getcontroller().searchMessage("loc1", "role2", "field1");
		assertNotNull(ans);
		assertEquals(0, ans.size());
		ans = getcontroller().searchMessage("loc1", "role1", "field2");
		assertNotNull(ans);
		assertEquals(0, ans.size());
	}
	
	public void testSearchLegitimateMessage(){

		publish();
		
		Vector<Message> ans;
		ans = getcontroller().searchMessage("loc1", "role1", "field1");
		assertNotNull(ans);
		assertEquals(1, ans.size());
		ans = getcontroller().searchMessage("loc2", "role2", "field2");
		assertNotNull(ans);
		assertEquals(1, ans.size());
	}

	public void testCloseLigitimateAd(){
		
		Integer[] ans = publish();
		
		assertTrue( getcontroller().closeAd("c1", "c1234", ans[0]) );
		assertTrue( getcontroller().closeAd("c2", "c1234", ans[1]) );
		assertTrue( getcontroller().closeAd("c1", "c1234", ans[2]) );
	}
	
	public void testCloseUnligitimateAd(){

		Integer[] ans = publish();
		
		assertFalse( getcontroller().closeAd("c2", "c1234", ans[0]) );
		assertFalse( getcontroller().closeAd("c1", "c1234", ans[1]) );
		assertFalse( getcontroller().closeAd("c2", "c1234", ans[2]) );
		
		assertFalse( getcontroller().closeAd("c1", "c1234", new Integer(200)) );
	}

	public void setcontroller(JobsController _controller) {
		this._controller = _controller;
	}

	public JobsController getcontroller() {
		return _controller;
	}
	
	private Integer[] publish() {
		
		Integer[] ans = new Integer[3];

		ans[0] = getcontroller().publishMessage("some body..", "loc1", "role1", "field1", "c1");
		ans[1] = getcontroller().publishMessage("some body..", "loc2", "role2", "field2", "c2");
		ans[2] = getcontroller().publishMessage("some body..", "loc3", "role3", "field3", "c1");
		
		return ans;
	}
}
