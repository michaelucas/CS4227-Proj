package ArchitecturalLayer;

@FunctionalInterface
public interface Interceptor {
	public void loggingServiceRequest(infoRequest context);
}
