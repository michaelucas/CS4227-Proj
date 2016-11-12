package ArchitecturalLayer;

@FunctionalInterface
public interface Interceptor {
	public void onPreMarshalRequest(infoRequest context);
}
