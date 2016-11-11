//Author Connor Buggan

package BusinessLayer;
import java.util.logging.Level;
import java.util.logging.Logger;

import UserInterfaceLayer.IntroUI;


public class runProject {
	
	private static final Logger LOGGER = Logger.getLogger( AdminProductList.class.getName() );
	
	public static void main(String[] args){
		
		try{
			IntroUI program = new IntroUI();
		}
		catch (Exception e) {
            LOGGER.log(Level.SEVERE, "context", e);
		}
	}
		

}
