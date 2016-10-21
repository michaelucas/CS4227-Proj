package Observer;


import java.io.FileNotFoundException;
import java.util.ArrayList;

public class productList implements Observer{
	
		ArrayList<Product> listOfProducts;
		DataControl d;
		
		public productList() throws FileNotFoundException{
			listOfProducts = new ArrayList<Product>(); 
			d = new DataControl();
			listOfProducts = d.factoryDesignPatternSearch();
		}	
		
		public void Display(){
			Product p;
			System.out.println("Product" + "\t" + "Price" + "\t" + "Stock");
			for(int i = 0; i < listOfProducts.size();i++){
				p = listOfProducts.get(i);
				System.out.println(p.toString());
			}
		}
		@Override
		public void update() {
			try {
				listOfProducts = d.factoryDesignPatternSearch();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		public Product getProduct() {
			// TODO Auto-generated method stub
			return listOfProducts.get(0);
			
		}

}
