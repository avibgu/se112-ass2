package main;

import domain.Company;
import domain.JobsController;
import domain.User;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JobsController jobsController = new JobsController();
		
		Company comp1 = new Company("HiTechComp", "HiTechComp", "12345678", 10);
		
		jobsController.addCompany(comp1);
		
		jobsController.addField("Software");
		jobsController.addField("Hardware");
		
		jobsController.addLocation("Tel Aviv");
		jobsController.addLocation("Beer Sheva");
		
		jobsController.addRole("Developer");
		jobsController.addRole("QA Engineer");

		User user1 = new User("Avi");
		User user2 = new User("Shiran");
		
		jobsController.registerToUpdates(user1, comp1);
		
		Integer msgId = jobsController.publishMessage("Programmer postion at HiTechComp",
				"Tel Aviv", "Developer", "Software", "HiTechComp");
		
		jobsController.registerToUpdates(user2, comp1);
		
		jobsController.editAd("HiTechComp", "12345678", msgId.intValue(),
				"QA Position at HiTechComp", "Beer Sheva", "QA Engineer",
				"Hardware", "OPEN");
		
		jobsController.unregisterFromUpdates(user1, comp1);
		
		jobsController.closeAd("HiTechComp", "12345678", msgId.intValue());
	}
}
