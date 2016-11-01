package BusinessLayer;
import UserInterfaceLayer.IntroUI;


public class runProject {
	
	public static void main(String[] args){
		
		try{
			IntroUI program = new IntroUI();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
		

}
