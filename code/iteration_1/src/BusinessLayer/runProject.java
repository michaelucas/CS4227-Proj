package BusinessLayer;
import UserInterfaceLayer.mainProgramUI;


public class runProject {
	
	public static void main(String[] args){
		
		try{
			mainProgramUI program = new mainProgramUI();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
		

}
