package domain;
import junit.framework.TestCase;


public class DrushimTests extends TestCase {

		protected DrushimBridge bridge;

		public DrushimTests(){
			super();
		}
		
		public DrushimTests(String name){
			super(name);
		}

		/**
		 * Set Up method
		 */
		protected void setUp() throws Exception {
			super.setUp();
			this.bridge= Driver.getBridge();
			this.initDomains();
			this.initRoles();
			this.initAreas();
			this.initCompanies();
		}

		/**
		 * Insert values of domains 
		 */
		private void initDomains(){
			this.bridge.addDomain("Hardware");
			this.bridge.addDomain("Software");
			this.bridge.addDomain("Internet");
			this.bridge.addDomain("System");
			this.bridge.addDomain("QA");
			this.bridge.addDomain("IT");
			this.bridge.addDomain("Other");
		}
		
		/**
		 * Insert values of roles 
		 */
		private void initRoles(){
			this.bridge.addRole("Doctor");
			this.bridge.addRole("QA");
			this.bridge.addRole("PHP developer");
			this.bridge.addRole("Nurse");
			this.bridge.addRole("Secretary");
			this.bridge.addRole("DBA team leader");
		}
		
		/**
		 * Insert values of areas 
		 */
		private void initAreas(){
			this.bridge.addArea("Tel-Aviv");
			this.bridge.addArea("Jerusalem");
			this.bridge.addArea("Haifa");
			this.bridge.addArea("Beer-Sheva");
		}		
		
		private void initCompanies() {
			this.bridge.addCompany("Google", "google", "goog1234", 0);
			this.bridge.addCompany("Intel", "intel", "0inside", 100);
			this.bridge.addCompany("Elbit","ebits","bitsNbytes",100);
		}
		
		/**
		 * Tear Down method
		 */
		protected void tearDown() throws Exception {
			super.tearDown();
		}
		
	
}
