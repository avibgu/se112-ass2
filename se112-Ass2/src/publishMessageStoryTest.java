import junit.framework.TestCase;


public class publishMessageStoryTest extends assigningWebTest {
	
		
	public void testPublishMessage(){
		assertTrue(addMessage(1,"C++ developer","Requirements: - First degree in software engineering. -  2 years of experience at least."));
		assertTrue(addMessage(2,"System administrator","Knowledge in unix and linux platforms. Recommendations are required. "));
		assertFalse(addMessage(3,"System Admin",""));
	}
	
	public void testMessageLimit(){
		register(1,10);
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
	
	public void testUpdateMessage(){
		addMessage(4,"C++ developer","Requirements: - First degree in software engineering. -  2 years of experience at least.");
		assertTrue(editMessage(4,"C++ developer","Requirements: - First degree in software engineering. - 5 years of experience at least."));
		
	}

}
