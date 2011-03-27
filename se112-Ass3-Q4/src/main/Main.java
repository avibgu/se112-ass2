/**
 * 
 */
package main;

import java.util.Vector;

import domain.JobsController;
import domain.Message;

/**
 * @author gshir
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JobsController jobsController = new JobsController();
		
		jobsController.publishMessage("C++ developer",
				 "Requirements: " +
				 "- First degree in software engineering. " +
				 "- 2 years of experience at least. " +
				 "Location: " +
				 "- Tel Aviv. " +
				 "Field: " +
				 "- software development.");

		Vector<Message> ans = jobsController.searchMessage("Tel Aviv", "", "");
		
		for (Message m: ans) System.out.println( m );
	}

}
