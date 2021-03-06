package BusinessLayer.CompositeProduct;

public interface Part {

	/**
	 * Get the ID of this Component.
	 *
	 * @return the ID of this Component.
	 */
	int getComponentId();

	void setComponentId(int newComponentId);

	/**
	 * Get the componentName of this Component.
	 *
	 * @return the componentName of this Component.
	 */
	String getComponentName();

	void setComponentName(String newComponentName);

	/**
	 * Get a String that describes this Component. Note that
	 * this method overrides the toString method inherited
	 * from Object.
	 *
	 * @return a String describing this Component.
	 */
	
	String getTypeOfComponent();
	String getComponentDetails();

	void addStock();

	void decrementStock();
	
	double getWeight();

}