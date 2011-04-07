package domain;

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
		assertNotNull("not yet implemented..");
	}
	
	public void testSearchMessageWithEmptyString(){
		assertNotNull("not yet implemented..");
	}
	
	public void testSearchUnpublishedMessage(){
		assertNotNull("not yet implemented..");
	}
	
	public void testSearchLegitimateMessage(){
		assertNotNull("not yet implemented..");
	}

	public void testCloseLigitimateAd(){
		assertNotNull("not yet implemented..");
	}
	
	public void testCloseUnligitimateAd(){
		assertNotNull("not yet implemented..");
	}
		
	public void setcontroller(JobsController _controller) {
		this._controller = _controller;
	}

	public JobsController getcontroller() {
		return _controller;
	} 

}
