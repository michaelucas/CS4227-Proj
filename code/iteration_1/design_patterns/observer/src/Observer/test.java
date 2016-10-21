package Observer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		productList pl = new productList();
		pl.Display();
		Scanner in = new Scanner(System.in);
		System.out.println("Buy a Tablet?");
		String answer = in.nextLine();
		
		//should be in control class
		Product p = pl.getProduct();
		p.registerObserver(pl);
		p.buyStock();
		
		//this is fine
		
		System.out.println("Adding Product:\nName:");
		String name = in.nextLine();
		System.out.println("\nStock:");
		int stock = Integer.parseInt(in.nextLine());
		System.out.println("Price:");
		double price = Double.parseDouble(in.nextLine());
		
		AddNewProduct a = new AddNewProduct();
		a.process(name, price, stock);
		a.addProduct("placeholder" , pl);
		
		pl.Display();
	}

}
