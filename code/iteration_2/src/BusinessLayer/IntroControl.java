package BusinessLayer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import ArchitecturalLayer.Dispatcher;
import ArchitecturalLayer.Interceptor;
import ArchitecturalLayer.infoRequest;

public class IntroControl {
	
	
	public void setUp(){
		Interceptor myInterceptor = new Interceptor () {
			public void onPreMarshalRequest(infoRequest context) {
				String description = context.getType();
				int componentID = context.getComponentID();
				File loggingFile = new File("LoggingFile.txt");
				try {
					FileWriter logWriter = new FileWriter(loggingFile , true);
					PrintWriter out = new PrintWriter(logWriter);
					out.println(description + "," + componentID + "," + System.currentTimeMillis());
					out.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}

		};
		Dispatcher dispatcher = new Dispatcher();
		dispatcher.register(myInterceptor);
	}

}
