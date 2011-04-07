package domain;

public class ProxyBridge implements DrushimBridge{

	public DrushimBridge real;
	
	private static final String[][] COMPANIES=
	{ {"Google", "google", "goog1234"},
	  {"Intel", "intel", "0inside"} ,
	  {"Elbit","ebits","bitsNbytes"} };
		
	public ProxyBridge() {
		this.real=null;
	}
	
	@Override
	public void addArea(String string) {
		if(this.real!=null)
			this.real.addArea(string);
	}

	@Override
	public String addCompany(String name, String user, String pass, int numOfAds) {
		if(this.real!=null)
			return this.real.addCompany(name,user,pass,numOfAds);
		for(int i=0; i<COMPANIES.length; i++)
			if(COMPANIES[i][0].equals(name))
				return ""+(i+1);
		return null;
	}

	@Override
	public void addDomain(String string) {
		if(this.real!=null)
			this.real.addDomain(string);
	}

	@Override
	public String addNewAd(String user, String pass, String domain, String role, String desc, String area) {
		if(this.real!=null)
			return this.real.addNewAd(user, pass, domain, role, desc, area);
		if( role.length()>0 & desc.length()>0 & domain.length()>0 & area.length()>0 ) {
			if(user.equals("intel")) {
				if(role.equals("DBA team leader"))
					return "1";
				else
					return "3";
			} else if(user.equals("ebits")) {
				if(role.equals("Secretary"))
					return "2";
				else if(role.equals("PHP developer"))
					return "4";
			}
		}
		return null;
	}

	@Override
	public void addRole(String string) {
		if(this.real !=null)
			this.real.addRole(string);
	}

	@Override
	public String getCompanyId(String name) {
		for(int i=0; i<COMPANIES.length; i++)
			if(COMPANIES[i][0].equals(name))
				return ""+(i+1);
		return null;
	}

	@Override
	public String[] getMyAdsIds(String user, String pass) {
		if(this.real!=null)
			return this.real.getMyAdsIds(user, pass);
		if(user.equals("intel"))
			return new String[] { "1" };
		return new String[] { };
	}

	@Override
	public int getMyCredit(String user, String pass) {
		if(this.real!=null)
			return this.real.getMyCredit(user, pass);
		if(user.equals("intel"))
			return 99;
		if(user.equals("ebits"))
			return 100;
		return 0;
	}

	@Override
	public boolean closeAd(String user, String pass, String id) {
		if(this.real != null)
			return this.real.closeAd(user, pass, id);
		return true;
	}

	@Override
	public String[] getAd(String id) {
		if(this.real!=null)
			return this.real.getAd(id);
		return null;
	}

	@Override
	public String[] getAds(String domain, String role, String area) {
		if(this.real!=null)
			return this.real.getAds(role, domain, area);
		
		if(role!=null && role.equals("something"))
			return null;
		if(area!=null && area.equals("Lalaland"))
			return null;
		if(domain!=null && domain.equals("unknown"))
			return null;
		
		if(role==null & domain==null & area==null)
			return new String[] { "1", "2", "3", "4" };
		else if(role==null & area==null) {
			if(domain.equals("Internet"))
				return new String[] {"1" , "3"} ;
			else if(domain.equals("Other"))
				return new String[] {"2"};
			else if(domain.equals("Software"))
				return new String[] {"4"};
		} else if(role==null & domain==null) {
			if(area.equals("Tel-aviv"))
				return new String[] {"1" , "4"} ;
			else if(area.equals("Jerusalem"))
				return new String[] {"2"};
			else if(area.equals("Haifa"))
				return new String[] {"3"};
		} else if(domain==null & area==null) {
			if(role.equals("PHP developer"))
				return new String[] { "3","4" };
			else if(role.equals("DBA team leader"))
				return new String[] { "1" };
			else if(role.equals("Secretary"))
				return new String[] { "2" };
		} else if(domain==null && area.equals("Tel-aviv") && role.equals("PHP developer"))
			return new String[] { "4" };
		else if(area==null && domain.equals("Internet") && role.equals("PHP developer"))
			return new String[] { "3" };
		return new String[0];
	}
	
}