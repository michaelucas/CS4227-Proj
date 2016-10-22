package BusinessLayer.Product;

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
	 * Get the stock of this Component.
	 *
	 * @return the stock of this Component.
	 */
	int getStock();

	void setStock(int newStock);

	/**
	 * Get a String that describes this Component. Note that
	 * this method overrides the toString method inherited
	 * from Object.
	 *
	 * @return a String describing this Component.
	 */
	
	String getTypeOfComponent();
	String getComponentDetails();

}