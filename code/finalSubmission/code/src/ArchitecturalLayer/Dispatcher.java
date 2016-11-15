package ArchitecturalLayer;

import java.util.ArrayList;

public class Dispatcher {
	
	static ArrayList<Interceptor> listOfInterceptors = new ArrayList<>();
	
	public synchronized void register(Interceptor i){
		listOfInterceptors.add(i);
	}
	
	public synchronized void remove() {
		// Method left empty
	}
	
	public synchronized void iterate_list(infoRequest context) {
		for(int i=0;i< listOfInterceptors.size(); i++) {
			Interceptor ic = listOfInterceptors.get(i);
			ic.loggingServiceRequest(context);
		}
	}
	
	public Dispatcher theInstance() {
		return this;
	}
}