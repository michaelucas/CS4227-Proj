package BusinessLayer;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import ArchitecturalLayer.Dispatcher;
import ArchitecturalLayer.Interceptor;
import ArchitecturalLayer.infoRequest;

public class IntroControl {

	private static final Logger LOGGER = Logger.getLogger( AdminProductList.class.getName() );
	
	public void setUp(){
		Interceptor myInterceptor = new Interceptor () {
			public void loggingServiceRequest(infoRequest context) {
				String description = context.getType();
				int componentID = context.getComponentID();
				File loggingFile = new File("LoggingFile.txt");
				try {
					FileWriter logWriter = new FileWriter(loggingFile , true);
					PrintWriter out = new PrintWriter(logWriter);
					out.println(description + "," + componentID + "," + System.currentTimeMillis());
					out.close();
				} catch (Exception e) {
		            LOGGER.log(Level.SEVERE, "context", e);
				}
			}

		};
		Dispatcher dispatcher = new Dispatcher();
		dispatcher.register(myInterceptor);
	}

}
