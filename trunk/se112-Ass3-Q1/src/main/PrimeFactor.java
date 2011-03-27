/**
 * 
 */
package main;

/**
 * @author gshir
 *
 */
public class PrimeFactor {

	public PrimeFactor() {}
	
	public String getPrimeFactors(long num){
		
		String answer = "";
		
		if (1 != num && 0 != num){
		
			long p = getNextPrime(num);
			
			answer = String.valueOf(p);
			
			if ( p != num )
				answer += ", " + getPrimeFactors( num / p);
		}

		return answer;
	}

	private long getNextPrime(long num) {
		
		long answer = num;
		
		for (long i = 2; i <= num; i++){
			
			if ( 0 == num % i ){
				
				answer = i;
				break;
			}
		}
		
		return answer;
	}
}
