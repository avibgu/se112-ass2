public class SearchJobTest extends DrushimTests{
	
	private String[] ids;
	/**
	 * Set Up method
	 */
	protected void setUp() throws Exception {
		super.setUp();
		ids=new String[4];
		String intelUsr="intel";
		String intelPass="0inside";
		ids[0]=this.bridge.addNewAd(intelUsr, intelPass, "Internet","DBA team leader","Minimum 5 years experience as Oracle DBA.","Tel-aviv");
		ids[2]=this.bridge.addNewAd(intelUsr, intelPass, "Internet","PHP developer","Minimum 99 years experience as Web Dev.","Haifa");
		String elbitUsr="ebits";
		String elbitPass="bitsNbytes";
		ids[1]=this.bridge.addNewAd(elbitUsr, elbitPass, "Other","Secretary","Any experience is advantage.","Jerusalem");
		ids[3]=this.bridge.addNewAd(elbitUsr, elbitPass, "Software","PHP developer","At least 10 years old.","Tel-aviv");
		String closeId=this.bridge.addNewAd(intelUsr, intelPass, "Software","Secretary","don't care","Haifa");
		this.bridge.closeAd(intelUsr, intelPass, closeId);
	}

	private boolean containsIds(String id, String[] ary) {
		for(int i=0; i<ary.length; i++)
			if(ary[i].equals(id))
				return true;
		return false;
	}

	public void testSearchByArea(){
		String[] adsids;
		adsids = this.bridge.getAds(null, null, "Tel-aviv");
		assertEquals(adsids.length, 2);
		assertTrue(containsIds(ids[0],adsids));
		assertTrue(containsIds(ids[3],adsids));

		adsids = this.bridge.getAds(null, null, "Jerusalem");
		assertEquals(adsids.length, 1);
		assertTrue(containsIds(ids[1],adsids));
		
		adsids = this.bridge.getAds(null, null, "Beer-Sheva");
		assertEquals(adsids.length, 0);
	}

	public void testSearchByRole(){
		String[] adsids;
		adsids = this.bridge.getAds(null,"PHP developer",null);
		assertEquals(adsids.length, 2);
		assertTrue(containsIds(ids[2],adsids));
		assertTrue(containsIds(ids[3],adsids));

		adsids = this.bridge.getAds(null, "DBA team leader", null);
		assertEquals(adsids.length, 1);
		assertTrue(containsIds(ids[0],adsids));
		
		adsids = this.bridge.getAds(null, "QA", null);
		assertEquals(adsids.length, 0);
	}

	public void testSearchByDomain(){
		String[] adsids;
		adsids = this.bridge.getAds("Internet",null,null);
		assertEquals(adsids.length, 2);
		assertTrue(containsIds(ids[0],adsids));
		assertTrue(containsIds(ids[2],adsids));

		adsids = this.bridge.getAds("Other",null, null);
		assertEquals(adsids.length, 1);
		assertTrue(containsIds(ids[1],adsids));
		
		adsids = this.bridge.getAds("QA", null, null);
		assertEquals(adsids.length, 0);
	}

	public void testSearchOpenOnly() {
		String[] adsids;

		adsids = this.bridge.getAds("Software",null, null);
		assertEquals(adsids.length, 1);
		assertTrue(containsIds(ids[3],adsids));
		
		adsids = this.bridge.getAds(null,"Secretary", null);
		assertEquals(adsids.length, 1);
		assertTrue(containsIds(ids[1],adsids));
		
		adsids = this.bridge.getAds(null,null, "Haifa");
		assertEquals(adsids.length, 1);
		assertTrue(containsIds(ids[2],adsids));
		
		adsids = this.bridge.getAds(null,null, null);
		assertEquals(adsids.length, 4);
		assertTrue(containsIds(ids[0],adsids));
		assertTrue(containsIds(ids[1],adsids));
		assertTrue(containsIds(ids[2],adsids));
		assertTrue(containsIds(ids[3],adsids));
	}

	public void testSearchByTwo() {
		String[] adsids;
		adsids = this.bridge.getAds(null,"PHP developer","Tel-aviv");
		assertEquals(adsids.length, 1);
		assertTrue(containsIds(ids[3],adsids));		

		adsids = this.bridge.getAds(null,"Secretary","Tel-aviv");
		assertEquals(adsids.length, 0);
	
		adsids = this.bridge.getAds("Internet","PHP developer",null);
		assertEquals(adsids.length, 1);
		assertTrue(containsIds(ids[2],adsids));		
	}

	public void testSearchWithBadParams() {
		String[] adsids;
		adsids = this.bridge.getAds("Internet","PHP developer","Lalaland");
		assertNull(adsids);
		adsids = this.bridge.getAds(null,"PHP developer","Lalaland");
		assertNull(adsids);
		adsids = this.bridge.getAds("Internet",null,"Lalaland");
		assertNull(adsids);
		adsids = this.bridge.getAds(null,null,"Lalaland");
		assertNull(adsids);
		adsids = this.bridge.getAds("unknown","PHP developer","Tel-aviv");
		assertNull(adsids);
		adsids = this.bridge.getAds("unknown",null,"Tel-aviv");
		assertNull(adsids);
		adsids = this.bridge.getAds("unknown","PHP developer",null);
		assertNull(adsids);
		adsids = this.bridge.getAds("unknown",null,null);
		assertNull(adsids);
		adsids = this.bridge.getAds("Internet","something","Tel-aviv");
		assertNull(adsids);
		adsids = this.bridge.getAds(null,"something","Tel-aviv");
		assertNull(adsids);
		adsids = this.bridge.getAds("Internet","something",null);
		assertNull(adsids);
		adsids = this.bridge.getAds(null,"something",null);
		assertNull(adsids);
	}
	
}
