
public class publishMessageStoryTest extends assigningWebTest {
	
	protected void setUp() throws Exception {
		super.setUp();
		register(1,10);
		
	}
	public void testPublishMessage(){
		assertTrue(addMessage(1,"C++ developer","Requirements: - First degree in software engineering. -  2 years of experience at least."));
		assertTrue(addMessage(2,"System administrator","Knowledge in unix and linux platforms. Recommendations are required. "));
		assertFalse(addMessage(3,"System Admin",""));
	}
	
	public void testMessageLimit(){
		
		assertTrue(addMessage(1,"C++ developer","Requirements: - First degree in software engineering. -  2 years of experience at least."));
		assertTrue(addMessage(2,"C++ developer","Requirements: - First degree in software engineering. -  2 years of experience at least."));
		assertTrue(addMessage(3,"C++ developer","Requirements: - First degree in software engineering. -  2 years of experience at least."));
		assertTrue(addMessage(4,"C++ developer","Requirements: - First degree in software engineering. -  2 years of experience at least."));
		assertTrue(addMessage(5,"C++ developer","Requirements: - First degree in software engineering. -  2 years of experience at least."));
		assertTrue(addMessage(6,"C++ developer","Requirements: - First degree in software engineering. -  2 years of experience at least."));
		assertTrue(addMessage(7,"C++ developer","Requirements: - First degree in software engineering. -  2 years of experience at least."));
		assertTrue(addMessage(8,"C++ developer","Requirements: - First degree in software engineering. -  2 years of experience at least."));
		assertTrue(addMessage(9,"C++ developer","Requirements: - First degree in software engineering. -  2 years of experience at least."));
		assertTrue(addMessage(10,"C++ developer","Requirements: - First degree in software engineering. -  2 years of experience at least."));
		assertFalse(addMessage(11,"C++ developer","Requirements: - First degree in software engineering. -  2 years of experience at least."));
		
	}
	
	public void testLengthTitle(){
		String longTitle = "I need c++ developer for new company in Hertzelia for full time job. Please send your CV to : jobs@blabla.co.il bla bla bla bla bla bla bla bla bla";
		assertTrue(addMessage(1,"java developer","computer science graduate."));
		assertFalse(addMessage(1,longTitle,"computer science graduate."));
	}

}
