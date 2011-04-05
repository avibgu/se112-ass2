package domain;

import java.util.Vector;

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
		Integer id = null;
		if (getJobsController().login(user, pass))
			id = getJobsController().publishMessage(desc, area, role, domain, user);
			if (id != null)
				return id.toString();
		
	    return null;
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
		
		return msg.toStringArray();
	}

	@Override
	public String[] getAds(String role, String domain, String area) {
		String ans[] = null;
		Vector<Message> results = getJobsController().searchMessage(area, role, domain);
		if (results != null){
			int size = results.size();
			
			ans = new String [size];
			
			for (int i=0; i < size; i++)
				ans[i] = String.valueOf(results.get(i).getId());
		}
		
		return ans;
	}

	@Override
	public String getCompanyId(String name) {
		return String.valueOf(getJobsController().getCompany(name).getId());
	}

	@Override
	public String[] getMyAdsIds(String user, String pass) {
		String ans[] = null;
		if (getJobsController().login(user, pass)){
			Vector<Message> messages =  getJobsController().getCompany(user).getCompanyMsgs();
			ans = new String[messages.size()];
			for (int i=0; i<messages.size();++i){
				ans[i] = String.valueOf(messages.get(i).getId());
			}
		}	
		return ans;
	}

	@Override
	public int getMyCredit(String user, String pass) {
		if (getJobsController().login(user, pass)){
			return getJobsController().getCompany(user).getNumOfMessages();
		}
		return -2;
	}

	public void setJobsController(JobsController jobsController) {
		this.jobsController = jobsController;
	}

	public JobsController getJobsController() {
		return jobsController;
	}

}
