package domain;

public class RealBridge implements DrushimBridge {
	
	private JobsController jobsController;
	
	public RealBridge(){
		
		setJobsController(new JobsController());
	}
	
	@Override
	public void addArea(String string) {

		getJobsController().addLocation(string);
	}

	@Override
	public String addCompany(String name, String user, String pass, int numOfAds) {

		return String.valueOf(getJobsController().addCompany(name, user, pass, numOfAds));
	}

	@Override
	public void addDomain(String string) {

		getJobsController().addField(string);
	}

	@Override
	public String addNewAd(String user, String pass, String domain, String role, String desc, String area) {

		if (getJobsController().login(user, pass))
			return getJobsController().publishMessage(desc, area, role, domain, user).toString();
		
		else return null;
	}

	@Override
	public void addRole(String string) {

		getJobsController().addRole(string);
	}

	@Override
	public boolean closeAd(String user, String pass, String id) {

		if (getJobsController().login(user, pass))
			return getJobsController().closeAd(user, pass, Integer.valueOf(id)) ;
		
		return false;
	}

	@Override
	public String[] getAd(String id) {

		Message msg = getJobsController().getMessage(Integer.valueOf(id));
		
		String ans[] = {msg.getCompanyId(), msg.getField(), msg.getRole(), msg.getBody(), msg.getLocation(), msg.getStatus()};
		
		return ans;
	}

	@Override
	public String[] getAds(String role, String domain, String area) {
		throw new UnsupportedOperationException();
		// TODO Auto-generated method stub
	}

	@Override
	public String getCompanyId(String name) {
		throw new UnsupportedOperationException();
		// TODO Auto-generated method stub
	}

	@Override
	public String[] getMyAdsIds(String user, String pass) {
		throw new UnsupportedOperationException();
		// TODO Auto-generated method stub
	}

	@Override
	public int getMyCredit(String user, String pass) {
		throw new UnsupportedOperationException();
		// TODO Auto-generated method stub
	}

	public void setJobsController(JobsController jobsController) {
		this.jobsController = jobsController;
	}

	public JobsController getJobsController() {
		return jobsController;
	}

}
