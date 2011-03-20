/**
 * 
 */

/**
 * @author Avi Digmi
 *
 */
public class SearchJobStoryTest extends assigningWebTest {

	protected void setUp() throws Exception {
		
		super.setUp();
		
		register(17,10);
		
		addMessage(170, "C++ developer", "Requirements: " +
										 "- First degree in software engineering. " +
										 "- 2 years of experience at least. " +
										 "Location: " +
										 "- Tel Aviv. " +
										 "Field: " +
										 "- software development.");
		
		addMessage(171, "Java developer", "Requirements: " +
										  "- First degree in software engineering. " +
										  "- 2 years of experience at least. " +
										  "Location: " +
										  "- Beer Sheva. " +
										  "Field: " +
										  "- software development.");
	}
	
	public void testSearchJobWithThreeParameters(){
		
		assertNotNull(searchJobs("Tel Aviv", "C++ developer", "software development"));
		assertNull(searchJobs("Beer Sheva", "C++ developer", "software development"));		
	}
	
	public void testSearchJobWithTwoParameters(){
		
		assertNotNull(searchJobs("Tel Aviv", "C++ developer", ""));
		assertNull(searchJobs("Beer Sheva", "C++ developer", ""));
		
		assertNotNull(searchJobs("Tel Aviv", "", "software development"));
		assertNull(searchJobs("Beer Sheva", "", "Construction"));
		
		assertNotNull(searchJobs("", "C++ developer", "software development"));
		assertNull(searchJobs("", "PHP developer", "software development"));		
	}
	
	public void testSearchJobWithOneParameters(){
		
		assertNotNull(searchJobs("Tel Aviv", "", ""));
		assertNull(searchJobs("Bat Yam", "", ""));	
		
		assertNotNull(searchJobs("", "C++ developer", ""));
		assertNull(searchJobs("", "PHP developer", ""));	
		
		assertNotNull(searchJobs("", "", "software development"));
		assertNull(searchJobs("", "", "Construction"));	
	}
}
