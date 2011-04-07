package main;

import domain.JobsController;
import junit.framework.TestCase;

public class tetsts1 extends TestCase {

	private JobsController _controller;

	
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
	
	
	public void setcontroller(JobsController _controller) {
		this._controller = _controller;
	}

	public JobsController getcontroller() {
		return _controller;
	} 
	
}
