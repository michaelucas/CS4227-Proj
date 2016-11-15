package ArchitecturalLayer;

import BusinessLayer.CompositeProduct.Component;

public class ContextObject implements infoRequest{
	
	private boolean editAction;
	private boolean addAction;
	private boolean removeAction;
	private boolean buyAction;
	public Component actionComponent;
	
	public ContextObject(String type, Component actionComponent){
		this.actionComponent = actionComponent;
		switch(type){
			case "edit":editAction= true;
				break;
			case "add":addAction= true;
				break;
			case "remove":removeAction= true;
				break;
			case "Bought":buyAction= true;
				break;
			default:
		    	System.out.println("Invalid");
				break;
		}
	}

	@Override
	public String getType() {
		if(editAction)
			return "EDIT COMPONENT";
		else if (addAction)
			return "ADD COMPONENT";
		else if(removeAction)
			return "REMOVE COMPONENT";
		else if(buyAction)
			return "BOUGHT COMPUTERSYSTEM";
		else return "INVALID ACTION";
	}

	@Override
	public int getComponentID() {
		return actionComponent.getComponentId();
	}

}
