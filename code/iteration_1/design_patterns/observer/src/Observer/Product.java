package Observer;

import java.io.IOException;
import java.util.ArrayList;

public class Product implements Subject {
	
	 //private int productId;
	 private String productName;
	 private boolean isActive;
	 private boolean isProductDiscount;
	 protected double unitCost;
	 private int stock;
	 private ArrayList<Observer> observers;
	
	public Product(String productName, double unitCost, int stock){
		this.productName = productName;
		this.unitCost = unitCost;
		this.stock = stock;
		observers = new ArrayList<Observer>();
		
	}
	
	public String toString(){
		String output;
		output = productName + "," + stock  + "," +  unitCost;
		return output;
	}
	
	public void buyStock(){
		stock--;
		DataControl d = new DataControl();
		try {
			d.rewriteProductFile(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notifyObservers();
	}
	

	@Override
	public void registerObserver(Observer O) {
		// TODO Auto-generated method stub
		observers.add(O);

	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		Observer o;
        try {
            for(int i = 0; i < observers.size();i++ )
            {
                o = observers.get(i);
                o.update();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	
	
}
