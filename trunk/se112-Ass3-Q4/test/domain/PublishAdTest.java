package domain;

public class PublishAdTest extends DrushimTests {

	public void testUpdateNumAd() {
		String user99="intel";
		String pass99="0inside";
		this.bridge.addNewAd(user99, pass99, "Software","DBA team leader","Minimum 5 years experience as Oracle DBA.","Tel-aviv");
		assertEquals(this.bridge.getMyCredit(user99, pass99),99);

		this.bridge.addNewAd(user99, pass99,"","","","");
		assertEquals(this.bridge.getMyCredit(user99, pass99),99);

		String user0="google";
		String pass0="goog1234";

		this.bridge.addNewAd(user0, pass0, "Software","DBA team leader","Minimum 5 years experience as Oracle DBA.","Tel-aviv");
		assertEquals(this.bridge.getMyCredit(user0, pass0),0);
	}	

	public void testPublishAd(){
		String user99="intel";
		String pass99="0inside";
		String id;
		id=this.bridge.addNewAd(user99, pass99, "Software","DBA team leader","Minimum 5 years experience as Oracle DBA.","Tel-aviv");
		assertNotNull(id); // got id for add
		assertEquals(this.bridge.getMyAdsIds(user99, pass99).length,1); // have only one ad
	}	

	public void testPublishAdMissingArgs() {
		String user100="ebits";
		String pass100="bitsNbytes";
		String id;
		
		id=this.bridge.addNewAd(user100, pass100, "","DBA team leader","Minimum 5 years experience as Oracle DBA.","Tel-aviv");
		assertNull(id);
		assertEquals(this.bridge.getMyAdsIds(user100, pass100).length,0);
		assertEquals(this.bridge.getMyCredit(user100, pass100),100);
		
		id=this.bridge.addNewAd(user100, pass100, "Software","DBA team leader","Minimum 5 years experience as Oracle DBA.","");
		assertNull(id);
		assertEquals(this.bridge.getMyAdsIds(user100, pass100).length,0);
		assertEquals(this.bridge.getMyCredit(user100, pass100),100);
		
		id=this.bridge.addNewAd(user100, pass100, "Software","DBA team leader","","Tel-aviv");
		assertNull(id);
		assertEquals(this.bridge.getMyAdsIds(user100, pass100).length,0);
		assertEquals(this.bridge.getMyCredit(user100, pass100),100);
		
		id=this.bridge.addNewAd(user100, pass100, "Software","","Reallly","Tel-aviv");
		assertNull(id);
		assertEquals(this.bridge.getMyAdsIds(user100, pass100).length,0);		
		assertEquals(this.bridge.getMyCredit(user100, pass100),100);
	}

	public void testPublishAdBadValueArgs() {
		String user100="ebits";
		String pass100="bitsNbytes";
		String id;

		// bad Location
		id=this.bridge.addNewAd(user100, pass100, "Software","DBA team leader","Minimum 5 years experience as Oracle DBA.","Tokyo");
		assertNull(id);
		assertEquals(this.bridge.getMyAdsIds(user100, pass100).length,0);
		assertEquals(this.bridge.getMyCredit(user100, pass100),100);

		// bad domain
		id=this.bridge.addNewAd(user100, pass100, "Hi-Tech","DBA team leader","Minimum 5 years experience as Oracle DBA.","Haifa");
		assertNull(id);
		assertEquals(this.bridge.getMyAdsIds(user100, pass100).length,0);
		assertEquals(this.bridge.getMyCredit(user100, pass100),100);

		// bad role
		id=this.bridge.addNewAd(user100, pass100, "Software","Janitor","Minimum 5 years experience as janitor.","Tel-Aviv");
		assertNull(id);
		assertEquals(this.bridge.getMyAdsIds(user100, pass100).length,0);
		assertEquals(this.bridge.getMyCredit(user100, pass100),100);
	}
	
	
	public void testPublishAdNoCredit() {
		String user0="google";
		String pass0="goog1234";

		String id=this.bridge.addNewAd(user0, pass0, "Software","DBA team leader","Minimum 5 years experience as Oracle DBA.","Tel-aviv");
		assertNull(id);
		assertEquals(this.bridge.getMyAdsIds(user0, pass0).length,0);
	}
	
}
