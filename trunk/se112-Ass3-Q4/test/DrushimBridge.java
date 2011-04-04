public interface DrushimBridge {
	
	public void addDomain(String string);
	public void addRole(String string);
	public void addArea(String string);
	
	/**
	 * @param name - Company name
	 * @param user - Username
	 * @param pass - Password
	 * @param numOfAds - number of ads
	 * @return company ID if succeed. Otherwise null
	 */
	public String addCompany(String name, String user, String pass, int numOfAds);

	/**
	 * Search company ID by company name
	 * @param name
	 * @return company ID if found. Otherwise null
	 */
	public String getCompanyId(String name);
	
	/**
	 * Get your company credit
	 * @param user - company username
	 * @param pass - company password
	 * @return amount of ads can be published
	 */
	public int getMyCredit(String user, String pass);
	
	/**
	 * Add new ad
	 * @param user - company username
	 * @param pass - company password
	 * @param domain - ad domain
	 * @param role - ad title
	 * @param desc - ad description
	 * @param area - job area
	 * @return ad ID if succeed. Otherwise null.
	 */
	public String addNewAd(String user, String pass,  String domain, String role, String desc, String area);

	/**
	 * get all company's ads ids
	 * @param user - company username
	 * @param pass - company password
	 * @return array of ads' ids.
	 */
	public String[] getMyAdsIds(String user, String pass);
	
	/**
	 * Filter all open ads by role/doamin/area
	 * If a filter field is not null the returned ads' fields must be equal to filter fields. 
	 * Example: search by role:  searchAds("...",null,null)
	 * Example: search by area and role:  searchAds("...",null,"...")
	 * Example: get all open ads:  searchAds(null,null,null)
	 * @param domain
	 * @param role
	 * @param area
	 * @return Array of ads' ids. If one of the arguments are wrong, return NULL.
	 */
	public String[] getAds(String domain, String role, String area);

	/**
	 * get Ad information
	 * @param id ad id
	 * @return array contains ad information
	 * [ "company id", "domain", "role", "desc", "area", "status"]
	 */
	public String[] getAd(String id);
	
	/**
	 * Close ad
	 * @param user company's username
	 * @param pass company's password
	 * @param id - ad's id
	 * @return TRUE if succeed. Otherwise FALSE
	 */
	public boolean closeAd(String user, String pass, String id);
}
