package DataLayer;

import java.util.ArrayList;

public class data {
	
	data() {
		
	}
	
	public static ArrayList<Component> getComponentTypeList(String componentType) {
		//Filled with factory stuff
		//Method will take in param of component type e.g. CPU
		//Factory stuff will search txt files for products matching CPU
		//Create ArrayList of Component type filled with all CPUs
		//Return ArrayList
		ArrayList<Component> componentList = new ArrayList<Component>();
		return componentList;
	}
}