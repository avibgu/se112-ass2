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

	/*
	 * Test correct login.
	 */
	public void testSuccessfullLogin(){
		assertTrue(_controller.login("c1","c1234" ));
	}
	
	/*
	 * Test incorrect login.
	 */
	public void testUnsuccessfullLogin(){
		assertFalse(_controller.login("c1","c123456" ));
	}
	
	/*
	 * Test login with user that doesn't exist.
	 */
	public void testloginUserNotExist(){
		assertFalse(_controller.login("c6","c123456" ));
	}
	
	/**
	 * Test publishing one message when the user exist, there is a credit and the parameters are correct.
	 */
	public void testPublishCorrectMsg(){
		Integer num = getcontroller().publishMessage("body1", "loc1", "role1", "field1","c1" );
		assertNotNull(num);
	}
	

	/**
	 * Test publishing one message when the user doesn't exist
	 */
	public void testPublishMsgUserNotExist(){
		getcontroller().publishMessage("body1", "loc1", "role1", "field1","c7" );
	}
	
	/**
	 * Test publishing messages when the user exist, but there is no credit.
	 */
	public void testPublishMsgNoCredit(){
		getcontroller().publishMessage("body1", "loc1", "role1", "field1","c1" );
		getcontroller().publishMessage("body1", "loc1", "role1", "field1","c1" );
		getcontroller().publishMessage("body1", "loc1", "role1", "field1","c1" );
		getcontroller().publishMessage("body1", "loc1", "role1", "field1","c1" );
		getcontroller().publishMessage("body1", "loc1", "role1", "field1","c1" );
		getcontroller().publishMessage("body1", "loc1", "role1", "field1","c1" );
		getcontroller().publishMessage("body1", "loc1", "role1", "field1","c1" );
		getcontroller().publishMessage("body1", "loc1", "role1", "field1","c1" );
		getcontroller().publishMessage("body1", "loc1", "role1", "field1","c1" );
		getcontroller().publishMessage("body1", "loc1", "role1", "field1","c1" );
		Integer num = getcontroller().publishMessage("body1", "loc1", "role1", "field1","c1" );
		assertNull(num);
	}
	
	/**
	 * Test publishing message when the user exist, there is a credit and the role field is not exist.
	 */
	public void testPublishMsgWrongRole(){
		Integer num = getcontroller().publishMessage("body1", "loc1", "blabla", "field1","c1" );
		assertNull(num);
		num = getcontroller().publishMessage("body1", "loc1", null, "field1","c1" );
		assertNull(num);
	}
	
	/**
	 * Test publishing message when the user exist, there is a credit and the location field is not exist.
	 */
	public void testPublishMsgWrongLocation(){
		Integer num = getcontroller().publishMessage("body1", "bla", "role1", "field1","c1" );
		assertNull(num);
		getcontroller().publishMessage("body1", null, "role1", "field1","c1" );
		assertNull(num);
	}
	
	/**
	 * Test publishing message when the user exist, there is a credit and the field is not exist.
	 */
	public void testPublishMsgWrongField(){
		Integer num = getcontroller().publishMessage("body1", "loc1", "role1", "bla","c1" );
		assertNull(num);
		getcontroller().publishMessage("body1", "loc1", "role1", null,"c1" );
		assertNull(num);
	}
	
	/**
	 * Test publishing message when the user exist, there is a credit and the field is not exist.
	 */
	public void testPublishMsgNoBody(){
		Integer num = getcontroller().publishMessage("", "loc1", "role1", "field1","c1" );
		assertNull(num);
		num = getcontroller().publishMessage(null, "loc1", "role1", "field1","c1" );
		assertNull(num);
	}
	
	/**
	 * Test that the users' credit is decreased after publishing message.
	 */
	public void testCreditAfterPublish(){
		getcontroller().publishMessage("body2", "loc2", "role1", "field2","c2" );
		assertEquals(99, getcontroller().getCompany("c2").getNumOfMessages());
		getcontroller().publishMessage("body2", "loc2", "role2", "field2","c2" );
		assertEquals(98, getcontroller().getCompany("c2").getNumOfMessages());
	}
	
	/**
	 * Test publishing message when the user exist, there is a credit but the params are empty.
	 */
	public void testPublishMsgEmptyParams(){
		Integer num = getcontroller().publishMessage("", "loc1", "role1", "field1","c1" );
		assertNull(num);
		num = getcontroller().publishMessage("body1", "", "role1", "field1","c1" );
		assertNull(num);
		num = getcontroller().publishMessage("body1", "loc1", "", "field1","c1" );
		assertNull(num);
		num = getcontroller().publishMessage("body1", "loc1", "role1", "","c1" );
		assertNull(num);
		getcontroller().publishMessage("body1", "loc1", "role1", "field1","" );
		assertNull(num);
	}
	
	/**
	 * Test that searching messages when sending null as parameter is ok  
	 */
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

	/**
	 * Test that searching messages when sending "" as parameter is NOT ok
	 * (because there is no such location\role\field) 
	 */
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
	
	/**
	 * Test that searching messages that wasn't published will return empty vector
	 */
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
	
	/**
	 * Test that searching messages that published will return those messages
	 */
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

	/**
	 * Test that user can close his messages
	 */
	public void testCloseLigitimateAd(){
		
		Integer[] ans = publish();
		
		assertTrue( getcontroller().closeAd("c1", "c1234", ans[0]) );
		assertTrue( getcontroller().closeAd("c2", "c1234", ans[1]) );
		assertTrue( getcontroller().closeAd("c1", "c1234", ans[2]) );
	}
	
	/**
	 * Test that user can't close messages that not his
	 */
	public void testCloseUnligitimateAd(){

		Integer[] ans = publish();
		
		assertFalse( getcontroller().closeAd("c2", "c1234", ans[0]) );
		assertFalse( getcontroller().closeAd("c1", "c1234", ans[1]) );
		assertFalse( getcontroller().closeAd("c2", "c1234", ans[2]) );
		
		assertFalse( getcontroller().closeAd("c1", "c1234", new Integer(200)) );
	}
	
	// this method only publish messages that the search tests will use
	private Integer[] publish() {
		
		Integer[] ans = new Integer[3];

		ans[0] = getcontroller().publishMessage("some body..", "loc1", "role1", "field1", "c1");
		ans[1] = getcontroller().publishMessage("some body..", "loc2", "role2", "field2", "c2");
		ans[2] = getcontroller().publishMessage("some body..", "loc3", "role3", "field3", "c1");
		
		return ans;
	}

	// setter
	public void setcontroller(JobsController _controller) {
		this._controller = _controller;
	}

	// getter
	public JobsController getcontroller() {
		return _controller;
	}
}
