package ArchitecturalLayer;

import java.util.ArrayList;

public class Dispatcher {
	//
	static ArrayList<Interceptor> listOfInterceptors = new ArrayList<Interceptor>();
	
	synchronized public void register(Interceptor i){
		listOfInterceptors.add(i);
	}
	
	synchronized public void remove() {
		
	}
	
	synchronized public void iterate_list(infoRequest context) {
		for(int i=0;i< listOfInterceptors.size(); i++) {
			Interceptor ic = listOfInterceptors.get(i);
			ic.onPreMarshalRequest(context);
		}
	}
	
	public Dispatcher theInstance() {
		return this;
	}
}