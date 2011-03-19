
public class Driver {
	
	public static AssigningWebBridge getBridge() {
		ProxyBridge bridge=new ProxyBridge (); 
		// add when real bridge is ready
		bridge.real =  new RealBridge (); 
		return bridge;
	}


}
