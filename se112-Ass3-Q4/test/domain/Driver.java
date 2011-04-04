package domain;
public abstract class Driver {
	public static ProxyBridge getBridge(){
		ProxyBridge bridge = new ProxyBridge(); 
		// add when real bridge is ready
//		bridge.real = new RealBridge(); 
		return bridge;
	}
}
