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
		
		addMessage(7, "C++ developer", "Requirements: " +
										 "- First degree in software engineering. " +
										 "- 2 years of experience at least. " +
										 "Location: " +
										 "- Tel Aviv. " +
										 "Field: " +
										 "- software development.");
		
		addMessage(8, "Java developer", "Requirements: " +
										  "- First degree in software engineering. " +
										  "- 2 years of experience at least. " +
										  "Location: " +
										  "- Beer Sheva. " +
										  "Field: " +
										  "- software development.");
	}
	
	public void testSearchJobWithThreeParameters(){
		
		assertEquals(1, searchJobs("Tel Aviv", "C++ developer", "software development").size());
		assertEquals(0, searchJobs("Beer Sheva", "C++ developer", "software development").size());
	}
	
	public void testSearchJobWithTwoParameters(){
		
		assertEquals(1, searchJobs("Tel Aviv", "C++ developer", "").size());
		assertEquals(0, searchJobs("Beer Sheva", "C++ developer", "").size());
		
		assertEquals(1, searchJobs("Tel Aviv", "", "software development").size());
		assertEquals(0, searchJobs("Beer Sheva", "", "Construction").size());
		
		assertEquals(1, searchJobs("", "C++ developer", "software development").size());
		assertEquals(0, searchJobs("", "PHP developer", "software development").size());		
	}
	
	public void testSearchJobWithOneParameters(){
		
		assertEquals(1, searchJobs("Tel Aviv", "", "").size());
		assertEquals(0, searchJobs("Bat Yam", "", "").size());	
		
		assertEquals(1, searchJobs("", "C++ developer", "").size());
		assertEquals(0, searchJobs("", "PHP developer", "").size());	
		
		assertEquals(2, searchJobs("", "", "software development").size());
		assertEquals(0, searchJobs("", "", "Construction").size());	
	}
}
