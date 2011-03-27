package main;

import junit.framework.TestCase;

public class PrimeFactorTests extends TestCase {
	
	private PrimeFactor primeFactor;

	protected void setUp() throws Exception {
		super.setUp();
		primeFactor = new PrimeFactor();
	}
	
	/**
	 * Test the number one - End case.
	 */
	public void testTheNumberOne() {
		
		assertEquals("", primeFactor.getPrimeFactors(1));
	}
	
	/**
	 * Test the number zero - End case.
	 */
	public void testTheNumberZero() {
		
		assertEquals("", primeFactor.getPrimeFactors(0));
	}
	
	/**
	 * testPrimeNumber used to test the equivalence class of prime numbers which should return the number itself.
	 * 
	 */
	public void testPrimeNumber() {
		assertEquals("7", primeFactor.getPrimeFactors(7));
		assertEquals("23", primeFactor.getPrimeFactors(23));
	}
	
	
	/**
	 * testNumberWithTwoFactors used to test the equivalence class numbers with two prime factors.
	 */
	public void testNumberWithTwoFactors() {
		
		assertEquals("3, 5", primeFactor.getPrimeFactors(15));
	}
	
	/**
	 * testNumberWithTwoFactors used to test the equivalence class numbers with three prime factors.
	 */
	public void testNumberWithThreeFactors() {
		
		assertEquals("2, 3, 5", primeFactor.getPrimeFactors(30));
		assertEquals("3, 3, 5", primeFactor.getPrimeFactors(45));
	}
	
	/**
	 * testNumberWithNFactors used to test some numbers with identical  and non-identical factors. 
	 * This is the test which shows us that the program is working for any arbitrary number.
	 */
	public void testNumberWithNFactors() {
		
		assertEquals("2, 2, 2, 2, 2, 2, 2, 2", primeFactor.getPrimeFactors(256));
		assertEquals("2, 2, 2, 2, 7, 31", primeFactor.getPrimeFactors(3472));
	}
	
	/**
	 * testVeryLargeNumber should test if the program can handle very long numbers without crashing.
	 */
	public void testVeryLargeNumber() {
		
		assertEquals("2, 2, 2, 2, 2, 13, 834671", primeFactor.getPrimeFactors(347223136));
	}
}
